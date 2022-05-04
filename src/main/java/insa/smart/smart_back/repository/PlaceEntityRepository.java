package insa.smart.smart_back.repository;

import insa.smart.smart_back.entity.PlaceEntity;
import org.geolatte.geom.Point;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlaceEntityRepository extends JpaRepository<PlaceEntity, Long> {

    @Query( value = "SELECT * FROM place pl WHERE ST_DistanceSphere(pl.position, :p) " +
            "<:range", nativeQuery = true)
    List<PlaceEntity> getPlaceWithinRange(Point p, double range);
}