package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "suggested_place_hint")
public class SuggestedPlaceHintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "suggestedPlaceHint", orphanRemoval = true)
    private Set<SuggestedPlaceHintStatus> statuses = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_step_hint_type_id")
    private TreasureHuntStepHintTypeEntity treasureHuntStepHintType;

    @ManyToOne
    @JoinColumn(name = "created_by_id")
    private UserEntity created_by;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    @Column(name = "value")
    private String value;

    public Set<SuggestedPlaceHintStatus> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<SuggestedPlaceHintStatus> statuses) {
        this.statuses = statuses;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreasureHuntStepHintTypeEntity getTreasureHuntStepHintType() {
        return treasureHuntStepHintType;
    }

    public void setTreasureHuntStepHintType(TreasureHuntStepHintTypeEntity treasureHuntStepHintType) {
        this.treasureHuntStepHintType = treasureHuntStepHintType;
    }

    public UserEntity getCreated_by() {
        return created_by;
    }

    public void setCreated_by(UserEntity created_by) {
        this.created_by = created_by;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }
}