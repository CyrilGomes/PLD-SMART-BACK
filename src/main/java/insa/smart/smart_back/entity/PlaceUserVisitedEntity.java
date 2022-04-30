package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "place_user_visited")
public class PlaceUserVisitedEntity {

    //TODO eventuellement mettre une clé composite
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "place_id", nullable = false)
    private PlaceEntity place;

    @Column(name = "visited_at", nullable = false)
    private LocalDate visited_at;

    public LocalDate getVisited_at() {
        return visited_at;
    }

    public void setVisited_at(LocalDate visited_at) {
        this.visited_at = visited_at;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity placeEntity) {
        this.place = placeEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}