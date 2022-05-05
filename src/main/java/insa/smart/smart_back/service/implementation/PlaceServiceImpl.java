package insa.smart.smart_back.service.implementation;

import insa.smart.smart_back.dto.CommentDTO;
import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.dto.mapper.CommentMapper;
import insa.smart.smart_back.dto.mapper.PlaceMapper;
import insa.smart.smart_back.dto.mapper.ResumedPlaceMapper;
import insa.smart.smart_back.entity.*;
import insa.smart.smart_back.repository.*;
import insa.smart.smart_back.service.abstraction.PlaceService;
import org.geolatte.geom.Point;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceEntityRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PlaceUserStarredRepository placeUserStarredRepository;

    @Autowired
    private PlaceUserVisitedRepository placeUserVisitedRepository;

    private final PlaceMapper placeMapper = new PlaceMapper();

    private final ResumedPlaceMapper resumedPlaceMapper = new ResumedPlaceMapper();
    private final CommentMapper commentMapper = new CommentMapper();


    @Override
    public List<PlaceDTO> getAll(boolean resumed) {
        if(resumed)
            return placeRepository.findAll().stream().map(resumedPlaceMapper::convertToDTO).collect(Collectors.toList());

        return placeRepository.findAll().stream().map(placeMapper::convertToDto).collect(Collectors.toList());
    }


    @Override
    public List<PlaceDTO> getPlacesWithinRange(Point p, double range, boolean resumed) {
        if(resumed)
            return placeRepository.getPlaceWithinRange(p, range).stream().map(resumedPlaceMapper::convertToDTO).collect(Collectors.toList());
        return placeRepository.getPlaceWithinRange(p, range).stream().map(placeMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PlaceDTO getPlaceById(Long id) {
        return placeMapper.convertToDto(placeRepository.findById(id).get());
    }

    @Override
    public PlaceDTO createPlace(PlaceDTO placeDTO) throws ParseException {

        //System.out.println(placeDTO);
        UserEntity user = userRepository.findByEmail(placeDTO.getCreated_by());
        PlaceEntity createdPlace = placeRepository.save(placeMapper.convertToEntity(placeDTO,user));

        return placeMapper.convertToDto(createdPlace);
    }

    @Override
    public void starPlace(Long placeId, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        PlaceEntity place = placeRepository.getById(placeId);
        PlaceUserStarredEntity placeUserStarred = new PlaceUserStarredEntity();
        placeUserStarred.setUser(user);
        placeUserStarred.setPlace(place);
        placeUserStarredRepository.save(placeUserStarred);

    }


    @Override
    public Long visitPlace(Long placeId, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        PlaceEntity place = placeRepository.getById(placeId);
        PlaceUserVisitedEntity placeUserVisited = new PlaceUserVisitedEntity();
        placeUserVisited.setUser(user);
        placeUserVisited.setPlace(place);
        placeUserVisited.setVisited_at(LocalDate.now());
        placeUserVisitedRepository.save(placeUserVisited);

        return placeId;

    }

    @Override
    public List<PlaceDTO> getVisitedPlaceByUser(Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());

        return user.getPlaceUserVisitedEntities().stream().map(placeUserVisitedEntity -> placeMapper.convertToDto(placeRepository.getById(placeUserVisitedEntity.getPlace().getId()))).collect(Collectors.toList());
    }

    @Override
    public List<PlaceDTO> getStarredPlaceByUser(Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());

        return user.getPlaceUserStarredEntities().stream().map(placeUserStarredEntity -> placeMapper.convertToDto(placeRepository.getById(placeUserStarredEntity.getPlace().getId()))).collect(Collectors.toList());
    }

    @Override
    public void addComment(Long placeId, CommentDTO commentDTO, Principal principal) {
        UserEntity user = userRepository.findByEmail(principal.getName());
        PlaceEntity place = placeRepository.getById(placeId);

        CommentEntity comment = commentMapper.convertToEntity(commentDTO, place, user);
        commentRepository.save(comment);
    }

    @Override
    public List<CommentDTO> getCommentsByPlace(Long placeId) {
        PlaceEntity place = placeRepository.getById(placeId);
        return place.getComments().stream().map(commentMapper::convertToDTO).collect(Collectors.toList());
    }
}
