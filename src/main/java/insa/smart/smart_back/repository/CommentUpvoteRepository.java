package insa.smart.smart_back.repository;

import insa.smart.smart_back.entity.CommentEntity;
import insa.smart.smart_back.entity.CommentUpvoteEntity;
import insa.smart.smart_back.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CommentUpvoteRepository extends JpaRepository<CommentUpvoteEntity, Long> {
    Boolean existsByCommentAndUser(CommentEntity comment, UserEntity user);
    void deleteByCommentAndUser(CommentEntity comment, UserEntity user);
}