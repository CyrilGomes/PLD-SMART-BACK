package insa.smart.smart_back.service.abstraction;

import insa.smart.smart_back.dto.PlaceDTO;

import java.text.ParseException;
import java.util.List;

public interface PlaceService {

    List<PlaceDTO> getAll();

    PlaceDTO createPlace(PlaceDTO placeDTO) throws ParseException;
}
