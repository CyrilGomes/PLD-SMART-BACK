package insa.smart.smart_back.dto.mapper;

import insa.smart.smart_back.dto.ResumedPlaceDTO;
import insa.smart.smart_back.entity.PlaceEntity;
import org.modelmapper.ModelMapper;

public class ResumedPlaceMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public ResumedPlaceDTO convertToDTO(PlaceEntity placeEntity) {
        ResumedPlaceDTO resumedPlaceDTO = modelMapper.map(placeEntity, ResumedPlaceDTO.class);
        resumedPlaceDTO.setPosition(placeEntity.getPosition());
        return resumedPlaceDTO;
    }

}
