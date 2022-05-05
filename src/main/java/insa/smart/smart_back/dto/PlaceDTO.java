package insa.smart.smart_back.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sun.org.apache.xpath.internal.operations.Bool;
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlaceDTO {

    private Long id;

    private String description;

    private String name;

    private double longitude;

    private double latitude;

    private LocalDate deleted_at;

    private LocalDate last_modification_at;

    private LocalDate created_at;

    private String created_by;

    private Boolean visited;

    public void setPosition(Point position){
        this.longitude = position.getPosition().getCoordinate(1);
        this.latitude = position.getPosition().getCoordinate(0);
    }

    @JsonIgnore
    public Point getPosition(){

        Point point = Geometries.mkPoint(new G2D(longitude, latitude), CoordinateReferenceSystems.WGS84);
        return point;
    }

    @Override
    public String toString() {
        return "PlaceDTO{" +
                "description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", deleted_at=" + deleted_at +
                ", last_modification_at=" + last_modification_at +
                ", created_at=" + created_at +
                ", created_by='" + created_by + '\'' +
                '}';
    }
}
