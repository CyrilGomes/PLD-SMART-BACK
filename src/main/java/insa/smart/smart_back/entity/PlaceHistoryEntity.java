package insa.smart.smart_back.entity;

import org.geolatte.geom.Point;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "place_history")
public class PlaceHistoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity created_by;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public UserEntity getCreated_by() {
        return created_by;
    }

    public void setCreated_by(UserEntity user) {
        this.created_by = user;
    }

    @Column(name = "name")
    private String name;

    @Column(name = "description", length = 1000)
    private String description;

    public String getDescription() {
        return description;
    }

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "position")
    private Point position;

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public void setId(Long id) {
        this.id = id;
    }

}