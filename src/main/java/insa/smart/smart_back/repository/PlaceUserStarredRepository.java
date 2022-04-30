package insa.smart.smart_back.repository;

import insa.smart.smart_back.entity.PlaceUserStarredEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceUserStarredRepository extends JpaRepository<PlaceUserStarredEntity, Long> {
}