package insa.smart.smart_back.service.implementation;

import insa.smart.smart_back.entity.CommentDownvoteEntity;
import insa.smart.smart_back.entity.CommentEntity;
import insa.smart.smart_back.entity.CommentUpvoteEntity;
import insa.smart.smart_back.entity.UserEntity;
import insa.smart.smart_back.repository.*;
import insa.smart.smart_back.service.abstraction.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentUpvoteRepository commentUpvoteRepository;

    @Autowired
    private CommentDownvoteRepository commentDownvoteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public boolean userHasUpvoted(Long commentId, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        CommentEntity comment = commentRepository.findById(commentId).get();

        return commentUpvoteRepository.existsByCommentAndUser(comment, user);
    }

    @Override
    public boolean userHasDownvoted(Long commentId, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        CommentEntity comment = commentRepository.findById(commentId).get();

        return commentDownvoteRepository.existsByCommentAndUser(comment, user);
    }

    @Override
    public void upvote(Long commentId, Principal principal) {
        CommentUpvoteEntity commentUpvote = new CommentUpvoteEntity();
        commentUpvote.setComment(commentRepository.findById(commentId).get());
        commentUpvote.setUser(userRepository.findByEmail(principal.getName()));
        commentUpvoteRepository.save(commentUpvote);
    }

    @Override
    public void downvote(Long commentId, Principal principal) {
        CommentDownvoteEntity commentDownvote = new CommentDownvoteEntity();
        commentDownvote.setComment(commentRepository.findById(commentId).get());
        commentDownvote.setUser(userRepository.findByEmail(principal.getName()));
        commentDownvoteRepository.save(commentDownvote);
    }

    @Override
    public void unvote(Long commentId, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        CommentEntity comment = commentRepository.findById(commentId).get();

        commentUpvoteRepository.deleteByCommentAndUser(comment, user);
        commentDownvoteRepository.deleteByCommentAndUser(comment, user);
    }
}
