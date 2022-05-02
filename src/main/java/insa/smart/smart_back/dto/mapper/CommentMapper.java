package insa.smart.smart_back.dto.mapper;

import insa.smart.smart_back.dto.CommentDTO;
import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.entity.CommentEntity;
import insa.smart.smart_back.entity.PlaceEntity;
import insa.smart.smart_back.entity.UserEntity;
import org.modelmapper.ModelMapper;

public class CommentMapper {
    private final ModelMapper modelMapper;

    public CommentMapper() {
        modelMapper = new ModelMapper();
    }

    public CommentDTO convertToDTO(CommentEntity comment) {
        CommentDTO commentDTO = modelMapper.map(comment, CommentDTO.class);
        UserEntity user = comment.getUser();
        commentDTO.setCreated_by(user.getUsername());

        return commentDTO;
    }

    public CommentEntity convertToEntity(CommentDTO commentDTO, PlaceEntity place, UserEntity user) {
        CommentEntity comment = modelMapper.map(commentDTO, CommentEntity.class);

        comment.setUser(user);
        comment.setPlace(place);

        return comment;
    }
}
