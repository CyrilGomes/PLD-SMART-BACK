package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "participate_treasure_hunt")
public class ParticipateTreasureHuntEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    @Column(name = "started_at")
    private LocalDate started_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Column(name = "finished_at")
    private LocalDate finished_at;

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_id")
    private TreasureHuntEntity treasureHunt;

    public LocalDate getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(LocalDate finished_at) {
        this.finished_at = finished_at;
    }

    public LocalDate getStarted_at() {
        return started_at;
    }

    public void setStarted_at(LocalDate started_at) {
        this.started_at = started_at;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public TreasureHuntEntity getTreasureHunt() {
        return treasureHunt;
    }

    public void setTreasureHunt(TreasureHuntEntity treasureHunt) {
        this.treasureHunt = treasureHunt;
    }

    public void setId(Long id) {
        this.id = id;
    }

}