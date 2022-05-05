package insa.smart.smart_back.dto.mapper;

import insa.smart.smart_back.dto.PlaceDTO;
import insa.smart.smart_back.entity.PlaceEntity;
import org.modelmapper.ModelMapper;

public class ResumedPlaceMapper {
    private final ModelMapper modelMapper = new ModelMapper();

    public PlaceDTO convertToDTO(PlaceEntity placeEntity) {
        PlaceDTO resumedPlaceDTO = new PlaceDTO();
        resumedPlaceDTO.setPosition(placeEntity.getPosition());
        resumedPlaceDTO.setId(placeEntity.getId());
        resumedPlaceDTO.setName(placeEntity.getName());
        resumedPlaceDTO.setPosition(placeEntity.getPosition());

        return resumedPlaceDTO;
    }

}
