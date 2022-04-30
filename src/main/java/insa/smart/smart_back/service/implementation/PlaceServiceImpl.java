package insa.smart.smart_back.service.implementation;

import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.dto.mapper.PlaceMapper;
import insa.smart.smart_back.entity.PlaceEntity;
import insa.smart.smart_back.entity.UserEntity;
import insa.smart.smart_back.repository.PlaceEntityRepository;
import insa.smart.smart_back.repository.UserRepository;
import insa.smart.smart_back.service.abstraction.PlaceService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceEntityRepository placeRepository;

    @Autowired
    private UserRepository userRepository;

    private PlaceMapper placeMapper = new PlaceMapper();


    @Override
    public List<PlaceDTO> getAll() {

        return placeRepository.findAll().stream().map(placeMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public PlaceDTO createPlace(PlaceDTO placeDTO) throws ParseException {

        //System.out.println(placeDTO);
        UserEntity user = userRepository.findByEmail(placeDTO.getCreated_by());
        PlaceEntity createdPlace = placeRepository.save(placeMapper.convertToEntity(placeDTO,user));

        return placeMapper.convertToDto(createdPlace);
    }


}
