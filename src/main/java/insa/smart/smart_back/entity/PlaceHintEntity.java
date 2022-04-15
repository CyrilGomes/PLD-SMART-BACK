package insa.smart.smart_back.entity;

import javax.persistence.*;

@Entity
@Table(name = "place_hint")
public class PlaceHintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_step_hint_type_id")
    private TreasureHuntStepHintTypeEntity treasureHuntStepHintType;

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public TreasureHuntStepHintTypeEntity getTreasureHuntStepHintType() {
        return treasureHuntStepHintType;
    }

    public void setTreasureHuntStepHintType(TreasureHuntStepHintTypeEntity treasureHuntStepIndiceType) {
        this.treasureHuntStepHintType = treasureHuntStepIndiceType;
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