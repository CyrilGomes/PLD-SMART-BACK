package insa.smart.smart_back.controller;

import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.dto.mapper.PlaceMapper;
import insa.smart.smart_back.dto.request.JwtRequest;
import insa.smart.smart_back.dto.response.JwtResponse;
import insa.smart.smart_back.entity.PlaceEntity;
import insa.smart.smart_back.service.abstraction.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
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
}
