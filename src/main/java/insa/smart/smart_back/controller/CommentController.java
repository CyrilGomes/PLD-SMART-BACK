package insa.smart.smart_back.controller;

import insa.smart.smart_back.dto.CommentDTO;
import insa.smart.smart_back.service.abstraction.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping(value = "/comment", produces =
        {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping(value = "/upvote/{id}")
    @ResponseBody
    public ResponseEntity<?> upvote(Principal principal, @PathVariable Long id) {
        if(commentService.userHasUpvoted(id, principal))
        {
            commentService.unvote(id, principal);
            return ResponseEntity.ok("Comment unvoted");
        }
        else
        {
            if(commentService.userHasDownvoted(id, principal))
            {
                commentService.unvote(id, principal);
            }

            commentService.upvote(id, principal);
            return ResponseEntity.ok("Comment upvoted");
        }
    }

    @PostMapping(value = "/downvote/{id}")
    @ResponseBody
    public ResponseEntity<?> downvote(Principal principal, @PathVariable Long id) {
        if(commentService.userHasDownvoted(id, principal))
        {
            commentService.unvote(id, principal);
            return ResponseEntity.ok("Comment unvoted");
        }
        else
        {
            if(commentService.userHasUpvoted(id, principal))
            {
                commentService.unvote(id, principal);
            }

            commentService.downvote(id, principal);
            return ResponseEntity.ok("Comment downvoted");
        }
    }
}
