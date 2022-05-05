package insa.smart.smart_back.dto.mapper;

import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.entity.PlaceEntity;
import insa.smart.smart_back.entity.PlaceUserVisitedEntity;
import insa.smart.smart_back.entity.UserEntity;
import insa.smart.smart_back.repository.UserRepository;
import insa.smart.smart_back.service.JwtUserDetailsService;
import insa.smart.smart_back.service.abstraction.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.time.LocalDate;

public class PlaceMapper {


    private final ModelMapper modelMapper = new ModelMapper();


    public PlaceEntity convertToEntity(PlaceDTO placeDTO, UserEntity user) throws ParseException {
        PlaceEntity place = modelMapper.map(placeDTO, PlaceEntity.class);
        place.setCreated_by(user);
        place.setPosition(placeDTO.getPosition());

        // todo: c'est la faute de cyril
        place.setCreated_at(LocalDate.now());



        /*
        if (placeDTO.getId() != null) {
            place oldplace = .getPostById(postDto.getId());
            place.setRedditID(oldPost.getRedditID());
            place.setSent(oldPost.isSent());
        }
        */

        return place;
    }

    public PlaceDTO convertToDto(PlaceEntity place) {
        PlaceDTO placeDTO = modelMapper.map(place, PlaceDTO.class);
        placeDTO.setPosition(place.getPosition());
        UserEntity user = place.getCreated_by();
        if(user == null){
            placeDTO.setCreated_by("Unknown");
        }
        else{
            placeDTO.setCreated_by(user.getUsername());
        }

        return placeDTO;
    }
}
