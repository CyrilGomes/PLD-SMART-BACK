package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user")
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

    public Set<InvitationTreasureHuntEntity> getInvitationTreasureHuntReceived() {
        return invitationTreasureHuntReceived;
    }

    public void setInvitationTreasureHuntReceived(Set<InvitationTreasureHuntEntity> invitationTreasureHuntReceived) {
        this.invitationTreasureHuntReceived = invitationTreasureHuntReceived;
    }

    public Set<InvitationTreasureHuntEntity> getInvitationForTreasureHuntSent() {
        return invitationForTreasureHuntSent;
    }

    public void setInvitationForTreasureHuntSent(Set<InvitationTreasureHuntEntity> invitationForTreasureHuntSent) {
        this.invitationForTreasureHuntSent = invitationForTreasureHuntSent;
    }

    public Set<ParticipateTreasureHuntEntity> getParticipedTreasureHunts() {
        return participedTreasureHunts;
    }

    public void setParticipedTreasureHunts(Set<ParticipateTreasureHuntEntity> participedTreasureHunts) {
        this.participedTreasureHunts = participedTreasureHunts;
    }

    public Set<TreasureHuntEntity> getTreasureHuntEntities() {
        return treasureHuntEntities;
    }

    public void setTreasureHuntEntities(Set<TreasureHuntEntity> treasureHuntEntities) {
        this.treasureHuntEntities = treasureHuntEntities;
    }

    public Set<SuggestedPlaceHintEntity> getSuggestedPlaceHints() {
        return suggestedPlaceHints;
    }

    public void setSuggestedPlaceHints(Set<SuggestedPlaceHintEntity> suggestedPlaceHints) {
        this.suggestedPlaceHints = suggestedPlaceHints;
    }

    public Set<CommentReportEntity> getCommentReportEntities() {
        return commentReportEntities;
    }

    public void setCommentReportEntities(Set<CommentReportEntity> commentReportEntities) {
        this.commentReportEntities = commentReportEntities;
    }

    public Set<CommentStatusEntity> getCommentStatusEntities() {
        return commentStatusEntities;
    }

    public void setCommentStatusEntities(Set<CommentStatusEntity> commentStatusEntities) {
        this.commentStatusEntities = commentStatusEntities;
    }

    public Set<PlaceReportEntity> getPlaceReportEntities() {
        return placeReportEntities;
    }

    public void setPlaceReportEntities(Set<PlaceReportEntity> placeReportEntities) {
        this.placeReportEntities = placeReportEntities;
    }

    public Set<PlaceStatusEntity> getPlaceStatusEntities() {
        return placeStatusEntities;
    }

    public void setPlaceStatusEntities(Set<PlaceStatusEntity> placeStatusEntities) {
        this.placeStatusEntities = placeStatusEntities;
    }

    public Set<CommentDownvoteEntity> getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(Set<CommentDownvoteEntity> downvotes) {
        this.downvotes = downvotes;
    }

    public Set<CommentUpvoteEntity> getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Set<CommentUpvoteEntity> upvotes) {
        this.upvotes = upvotes;
    }

    public Set<PasswordRecoveryEntity> getPasswordRecoveryEntities() {
        return passwordRecoveryEntities;
    }

    public void setPasswordRecoveryEntities(Set<PasswordRecoveryEntity> passwordRecoveryEntities) {
        this.passwordRecoveryEntities = passwordRecoveryEntities;
    }

    public Set<SanctionEntity> getSanctions() {
        return sanctions;
    }

    public void setSanctions(Set<SanctionEntity> sanctions) {
        this.sanctions = sanctions;
    }

    public Set<GroupMemberEntity> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(Set<GroupMemberEntity> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Set<GroupModeratorEntity> getGroupModeratorEntities() {
        return groupModeratorEntities;
    }

    public void setGroupModeratorEntities(Set<GroupModeratorEntity> groupModeratorEntities) {
        this.groupModeratorEntities = groupModeratorEntities;
    }

    public Set<PlaceUserStarredEntity> getPlaceUserStarredEntities() {
        return placeUserStarredEntities;
    }

    public void setPlaceUserStarredEntities(Set<PlaceUserStarredEntity> placeUserStarredEntities) {
        this.placeUserStarredEntities = placeUserStarredEntities;
    }

    public Set<PlaceUserVisitedEntity> getPlaceUserVisitedEntities() {
        return placeUserVisitedEntities;
    }

    public void setPlaceUserVisitedEntities(Set<PlaceUserVisitedEntity> placeUserVisitedEntities) {
        this.placeUserVisitedEntities = placeUserVisitedEntities;
    }

    public Set<PlaceEntity> getCreated_places() {
        return created_places;
    }

    public void setCreated_places(Set<PlaceEntity> createdPlaces) {
        this.created_places = createdPlaces;
    }

    public Set<GroupEntity> getCreated_groups() {
        return created_groups;
    }

    public void setCreated_groups(Set<GroupEntity> created_groups) {
        this.created_groups = created_groups;
    }

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public LocalDate getLast_modification_at() {
        return last_modification_at;
    }

    public void setLast_modification_at(LocalDate last_modification_at) {
        this.last_modification_at = last_modification_at;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public String getHashed_password() {
        return hashed_password;
    }

    public void setHashed_password(String hashed_password) {
        this.hashed_password = hashed_password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}