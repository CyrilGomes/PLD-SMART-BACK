package insa.smart.smart_back.entity;

import javax.persistence.*;

@Entity
@Table(name = "invitation_treasure_hunt")
public class InvitationTreasureHuntEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "to_user_id")
    private UserEntity to_user;

    @ManyToOne
    @JoinColumn(name = "from_user_id")
    private UserEntity from_user;

    @ManyToOne
    @JoinColumn(name = "treasure_hunt_id")
    private TreasureHuntEntity treasureHunt;

    public UserEntity getTo_user() {
        return to_user;
    }

    public void setTo_user(UserEntity to_user) {
        this.to_user = to_user;
    }

    public UserEntity getFrom_user() {
        return from_user;
    }

    public void setFrom_user(UserEntity from_user) {
        this.from_user = from_user;
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