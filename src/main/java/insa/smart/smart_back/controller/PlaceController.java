package insa.smart.smart_back.controller;

import insa.smart.smart_back.dto.CommentDTO;
import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.service.abstraction.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.text.ParseException;

@RestController
@RequestMapping(value = "/place", produces =
        {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class PlaceController {

    @Autowired
    private PlaceService placeService;


    @GetMapping
    @ResponseBody
    public ResponseEntity<?> getPlaces() throws Exception {

        return ResponseEntity.ok(placeService.getAll());
    }

    @GetMapping(value = "/resumed")
    @ResponseBody
    public ResponseEntity<?> getResumedPlaces() throws Exception {

        return ResponseEntity.ok(placeService.getAllResumed());
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<?> getPlace(@PathVariable Long id) throws Exception {

        return ResponseEntity.ok(placeService.getPlaceById(id));
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

        placeService.visitPlace(id, principal);

        return ResponseEntity.ok("Place visited");

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
