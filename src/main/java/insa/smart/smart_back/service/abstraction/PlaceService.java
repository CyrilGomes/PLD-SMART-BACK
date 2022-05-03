package insa.smart.smart_back.service.abstraction;

import insa.smart.smart_back.dto.CommentDTO;
import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.dto.ResumedPlaceDTO;

import java.security.Principal;
import java.text.ParseException;
import java.util.List;

public interface PlaceService {

    List<PlaceDTO> getAll();

    List<ResumedPlaceDTO> getAllResumed();

    PlaceDTO getPlaceById(Long id);

    PlaceDTO createPlace(PlaceDTO placeDTO) throws ParseException;

    void starPlace(Long placeId, Principal principal);

    void visitPlace(Long placeId, Principal principal);

    List<PlaceDTO> getVisitedPlaceByUser(Principal principal);

    List<PlaceDTO> getStarredPlaceByUser(Principal principal);

    void addComment(Long placeId, CommentDTO commentDTO, Principal principal);

    List<CommentDTO> getCommentsByPlace(Long placeId);

}
