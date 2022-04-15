package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "place_status")
public class PlaceStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;

    @Column(name = "changed_at")
    private LocalDate changed_at;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public LocalDate getChanged_at() {
        return changed_at;
    }

    public void setChanged_at(LocalDate created_at) {
        this.changed_at = created_at;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}