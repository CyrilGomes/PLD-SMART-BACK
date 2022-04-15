package insa.smart.smart_back.entity;

import javax.persistence.*;

@Entity
@Table(name = "treasure_hunt_step_hint")
public class TreasureHuntStepHintEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_step_id")
    private TreasureHuntStepEntity treasureHuntStep;

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_step_hint_type_id")
    private TreasureHuntStepHintTypeEntity treasureHuntStepHintType;

    public TreasureHuntStepHintTypeEntity getTreasureHuntStepHintType() {
        return treasureHuntStepHintType;
    }

    public void setTreasureHuntStepHintType(TreasureHuntStepHintTypeEntity treasureHuntStepHintType) {
        this.treasureHuntStepHintType = treasureHuntStepHintType;
    }

    public TreasureHuntStepEntity getTreasureHuntStep() {
        return treasureHuntStep;
    }

    public void setTreasureHuntStep(TreasureHuntStepEntity treasureHuntStep) {
        this.treasureHuntStep = treasureHuntStep;
    }

    public void setId(Long id) {
        this.id = id;
    }

}