package insa.smart.smart_back.controller;


import insa.smart.smart_back.service.abstraction.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/user", produces = { MediaType.APPLICATION_JSON_VALUE })
@CrossOrigin
public class UserController {

    @Autowired
    private PlaceService placeService;

    @GetMapping(value = "/visitedplaces")
    @ResponseBody
    public ResponseEntity<?> getVisitedPlaces(Principal principal) throws Exception {
        return ResponseEntity.ok(placeService.getVisitedPlaceByUser(principal));
    }

    @GetMapping(value = "/starredplaces")
    @ResponseBody
    public ResponseEntity<?> getStarredPlaces(Principal principal) throws Exception {
        return ResponseEntity.ok(placeService.getStarredPlaceByUser(principal));
    }
}
