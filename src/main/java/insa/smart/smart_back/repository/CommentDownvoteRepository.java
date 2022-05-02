package insa.smart.smart_back.repository;

import insa.smart.smart_back.entity.CommentDownvoteEntity;
import insa.smart.smart_back.entity.CommentEntity;
import insa.smart.smart_back.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentDownvoteRepository extends JpaRepository<CommentDownvoteEntity, Long> {
    Boolean existsByCommentAndUser(CommentEntity comment, UserEntity user);
    void deleteByCommentAndUser(CommentEntity comment, UserEntity user);
}