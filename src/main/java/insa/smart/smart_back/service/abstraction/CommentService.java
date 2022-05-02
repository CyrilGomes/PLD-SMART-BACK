package insa.smart.smart_back.service.abstraction;

import insa.smart.smart_back.entity.UserEntity;

import java.security.Principal;

public interface CommentService {
    boolean userHasUpvoted(Long commentId, Principal principal);
    boolean userHasDownvoted(Long commentId, Principal principal);
    void upvote(Long commentId, Principal principal);
    void downvote(Long commentId, Principal principal);
    void unvote(Long commentId, Principal principal);
}
