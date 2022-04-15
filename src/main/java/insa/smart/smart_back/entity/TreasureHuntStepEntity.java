package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "treasure_hunt_step")
public class TreasureHuntStepEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "treasureHuntStep", orphanRemoval = true)
    private Set<TreasureHuntStepHintEntity> hints = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_id")
    private TreasureHuntEntity treasureHunt;

    @Column(name = "order")
    private Integer order;

    @ManyToOne
    @JoinColumn(name = "goal_place_id")
    private PlaceEntity goalPlace;

    public Set<TreasureHuntStepHintEntity> getHints() {
        return hints;
    }

    public void setHints(Set<TreasureHuntStepHintEntity> hints) {
        this.hints = hints;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public PlaceEntity getGoalPlace() {
        return goalPlace;
    }

    public void setGoalPlace(PlaceEntity goalPlace) {
        this.goalPlace = goalPlace;
    }

    public TreasureHuntEntity getTreasureHunt() {
        return treasureHunt;
    }

    public void setTreasureHunt(TreasureHuntEntity treasureHunt) {
        this.treasureHunt = treasureHunt;
    }
}