package insa.smart.smart_back.controller;

import insa.smart.smart_back.dto.CommentDTO;
import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.dto.response.VisitResponse;
import insa.smart.smart_back.service.abstraction.PlaceService;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.security.Principal;
import java.text.ParseException;
import java.util.Objects;
import java.util.Optional;

import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;
import static org.geolatte.geom.builder.DSL.*;

@RestController
@RequestMapping(value = "/place", produces =
        {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class PlaceController {

    @Autowired
    private PlaceService placeService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getPlaces(@RequestParam(required = false) Optional<Double> lat,
                                       @RequestParam(required = false) Optional<Double> lng,
                                       @RequestParam(required = false) Optional<Double> radius) throws Exception {

        if(lat.isPresent() == lng.isPresent() == radius.isPresent()){
            double trueLat = lat.get();
            double tueLng = lng.get();
            double trueRadius = radius.get();
            Point<G2D> point = point(WGS84, g(tueLng, trueLat));
            return ResponseEntity.ok(placeService.getPlacesWithinRange(point,trueRadius, false));
        }

        return ResponseEntity.ok(placeService.getAll(false));
    }

    @GetMapping(value = "/resumed")
    @ResponseBody
    public ResponseEntity<?> getResumedPlaces(@RequestParam(required = false) Optional<Double> lat,
                                              @RequestParam(required = false) Optional<Double> lng,
                                              @RequestParam(required = false) Optional<Double> radius) throws Exception {
        if(lat.isPresent() == lng.isPresent() == radius.isPresent()){
            double trueLat = lat.get();
            double tueLng = lng.get();
            double trueRadius = radius.get();
            Point<G2D> point = point(WGS84, g(tueLng, trueLat));
            return ResponseEntity.ok(placeService.getPlacesWithinRange(point,trueRadius, true));
        }

        if(lat.isPresent() || lng.isPresent() || radius.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        return ResponseEntity.ok(placeService.getAll(true));
    }



    public void placeVisitedUpdate(PlaceDTO placeDTO, Principal principal){
        for (PlaceDTO i:placeService.getVisitedPlaceByUser(principal)
        ) {
            if(Objects.equals(i.getId(), placeDTO.getId())){
                //placeDTO.setVisited(true);
                return;
            }
        }
    }


    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> getPlace(Principal principal, @PathVariable Long id) throws Exception {
        PlaceDTO placeDTO = placeService.getPlaceById(id);

        placeVisitedUpdate(placeDTO, principal);
        return ResponseEntity.ok(placeDTO);
    }


    @PostMapping(value = "/{id}/star")
    @ResponseBody
    public ResponseEntity<?> starPlace(Principal principal, @PathVariable Long id) {

        placeService.starPlace(id, principal);

        return ResponseEntity.ok("Place starred");

    }

    @PostMapping(value = "/{id}/visit")
    @ResponseBody
    public ResponseEntity<?> visitPlace(Principal principal, @PathVariable Long id) {


        return ResponseEntity.ok( new VisitResponse(placeService.visitPlace(id, principal)));

    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<?> createPlace(Principal principal, @RequestBody PlaceDTO placeDTO) {
        try {
            System.out.println(placeDTO);
            placeDTO.setCreated_by(principal.getName());
            PlaceDTO placeCreated = placeService.createPlace(placeDTO);
            return ResponseEntity.ok(placeCreated);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erreur lors de la création" +
                " de l'endroit");

    }

    @PostMapping(value = "/{id}/comment")
    @ResponseBody
    public ResponseEntity<?> commentPlace(Principal principal, @PathVariable Long id, @RequestBody CommentDTO comment) {

        placeService.addComment(id, comment, principal);

        return ResponseEntity.ok("Comment added");
    }

    @GetMapping(value = "/{id}/comments")
    @ResponseBody
    public ResponseEntity<?> getComments(@PathVariable Long id) {
        return ResponseEntity.ok(placeService.getCommentsByPlace(id));
    }
}
