package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "treasure_hunt")
public class TreasureHuntEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity created_by;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "ending_step")
    private TreasureHuntStepEntity endingStep;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "starting_step")
    private TreasureHuntStepEntity startingStep;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "treasureHunt", orphanRemoval = true)
    private Set<TreasureHuntStepEntity> steps = new LinkedHashSet<>();

    @OneToMany(mappedBy = "treasureHunt", orphanRemoval = true)
    private Set<ParticipateTreasureHuntEntity> participations = new LinkedHashSet<>();

    @OneToMany(mappedBy = "treasureHunt", orphanRemoval = true)
    private Set<InvitationTreasureHuntEntity> invitations = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    @Column(name = "opens_at")
    private LocalDate opens_at;

    public LocalDate getOpens_at() {
        return opens_at;
    }

    public void setOpens_at(LocalDate opens_at) {
        this.opens_at = opens_at;
    }

    @Column(name = "closes_at")
    private LocalDate closes_at;

    public LocalDate getCloses_at() {
        return closes_at;
    }

    public void setCloses_at(LocalDate closes_at) {
        this.closes_at = closes_at;
    }

    @Column(name = "created_at")
    private LocalDate created_at;

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    @Column(name = "last_modification_at")
    private LocalDate last_modification_at;

    public LocalDate getLast_modification_at() {
        return last_modification_at;
    }

    public void setLast_modification_at(LocalDate last_modification_at) {
        this.last_modification_at = last_modification_at;
    }

    @Column(name = "deleted_at")
    private LocalDate deleted_at;

    public Set<InvitationTreasureHuntEntity> getInvitations() {
        return invitations;
    }

    public void setInvitations(Set<InvitationTreasureHuntEntity> invitations) {
        this.invitations = invitations;
    }

    public Set<ParticipateTreasureHuntEntity> getParticipations() {
        return participations;
    }

    public void setParticipations(Set<ParticipateTreasureHuntEntity> participations) {
        this.participations = participations;
    }

    public TreasureHuntStepEntity getEndingStep() {
        return endingStep;
    }

    public void setEndingStep(TreasureHuntStepEntity endingStep) {
        this.endingStep = endingStep;
    }

    public TreasureHuntStepEntity getStartingStep() {
        return startingStep;
    }

    public void setStartingStep(TreasureHuntStepEntity treasureHuntStep) {
        this.startingStep = treasureHuntStep;
    }

    public Set<TreasureHuntStepEntity> getSteps() {
        return steps;
    }

    public void setSteps(Set<TreasureHuntStepEntity> steps) {
        this.steps = steps;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getCreated_by() {
        return created_by;
    }

    public void setCreated_by(UserEntity created_by) {
        this.created_by = created_by;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}