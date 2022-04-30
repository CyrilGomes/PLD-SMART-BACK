package insa.smart.smart_back.repository;

import insa.smart.smart_back.entity.PlaceUserVisitedEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceUserVisitedRepository extends JpaRepository<PlaceUserVisitedEntity, Long> {
}