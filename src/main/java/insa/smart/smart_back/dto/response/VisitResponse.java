package insa.smart.smart_back.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class VisitResponse  implements Serializable {

    private final Long placeId;

    public VisitResponse(Long placeId) {
        this.placeId = placeId;
    }
}
