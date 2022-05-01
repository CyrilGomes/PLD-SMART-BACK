package insa.smart.smart_back.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "hashed_password", nullable = false)
    private String hashed_password;

    @Column(name = "created_at", nullable = false)
    private LocalDate created_at;

    @Column(name = "last_modification_at")
    private LocalDate last_modification_at;

    @Column(name = "deleted_at")
    private LocalDate deleted_at;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<GroupEntity> created_groups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "created_by", orphanRemoval = true)
    private Set<PlaceEntity> created_places = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PlaceUserVisitedEntity> placeUserVisitedEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PlaceUserStarredEntity> placeUserStarredEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<GroupModeratorEntity> groupModeratorEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<CommentEntity> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<GroupMemberEntity> groupMembers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<SanctionEntity> sanctions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PasswordRecoveryEntity> passwordRecoveryEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<CommentUpvoteEntity> upvotes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<CommentDownvoteEntity> downvotes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PlaceStatusEntity> placeStatusEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<PlaceReportEntity> placeReportEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<CommentStatusEntity> commentStatusEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<CommentReportEntity> commentReportEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "created_by", orphanRemoval = true)
    private Set<SuggestedPlaceHintEntity> suggestedPlaceHints = new LinkedHashSet<>();

    @OneToMany(mappedBy = "created_by", orphanRemoval = true)
    private Set<TreasureHuntEntity> treasureHuntEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private Set<ParticipateTreasureHuntEntity> participedTreasureHunts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "from_user", orphanRemoval = true)
    private Set<InvitationTreasureHuntEntity> invitationForTreasureHuntSent = new LinkedHashSet<>();

    @OneToMany(mappedBy = "from_user", orphanRemoval = true)
    private Set<InvitationTreasureHuntEntity> invitationTreasureHuntReceived = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<RoleEntity> roles;



}