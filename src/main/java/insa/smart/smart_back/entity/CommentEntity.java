package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "comment")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "comment", orphanRemoval = true)
    private Set<CommentUpvoteEntity> upvotes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "comment", orphanRemoval = true)
    private Set<CommentDownvoteEntity> downvotes = new LinkedHashSet<>();

    @OneToMany(mappedBy = "comment", orphanRemoval = true)
    private Set<CommentStatusEntity> statuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "comment", orphanRemoval = true)
    private Set<CommentReportEntity> reports = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    @ManyToOne
    @JoinColumn(name = "place_id")
    private PlaceEntity place;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public UserEntity getUser() {
        return user;
    }

    @Column(name = "upvote", nullable = false)
    private Integer upvote;

    @Column(name = "message", nullable = false, length = 1000)
    private String message;

    @Column(name = "deleted_at")
    private LocalDate deleted_at;

    @Column(name = "created_at")
    private LocalDate created_at;

    @Column(name = "downvote", nullable = false)
    private Integer downvote;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    public Set<CommentReportEntity> getReports() {
        return reports;
    }

    public void setReports(Set<CommentReportEntity> reports) {
        this.reports = reports;
    }

    public Set<CommentStatusEntity> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<CommentStatusEntity> statuses) {
        this.statuses = statuses;
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

    public LocalDate getDeleted_at() {
        return deleted_at;
    }

    public void setDeleted_at(LocalDate deleted_at) {
        this.deleted_at = deleted_at;
    }

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public Integer getDownvote() {
        return downvote;
    }

    public void setDownvote(Integer downvote) {
        this.downvote = downvote;
    }

    public Integer getUpvote() {
        return upvote;
    }

    public void setUpvote(Integer upvote) {
        this.upvote = upvote;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public PlaceEntity getPlace() {
        return place;
    }

    public void setPlace(PlaceEntity place) {
        this.place = place;
    }

    public void setId(Long id) {
        this.id = id;
    }

}