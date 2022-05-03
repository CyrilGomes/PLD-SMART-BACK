package insa.smart.smart_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import insa.smart.smart_back.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometries;
import org.geolatte.geom.Point;
import org.geolatte.geom.crs.CoordinateReferenceSystems;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
public class ResumedPlaceDTO {

    private Long id;
    private double longitude;

    private double latitude;

    public void setPosition(Point position){
        this.longitude = position.getPosition().getCoordinate(0);
        this.latitude = position.getPosition().getCoordinate(1);
    }

    @JsonIgnore
    public Point getPosition(){

        Point point = Geometries.mkPoint(new G2D(longitude, latitude), CoordinateReferenceSystems.WGS84);
        return point;
    }

    @Override
    public String toString() {
        return "ResumedPlaceDTO{" +
                "id=" + id +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
