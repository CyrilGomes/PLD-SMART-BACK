package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "user_group")
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity user;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<GroupModeratorEntity> moderators = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<CommentEntity> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<GroupRuleEntity> rules = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<GroupMemberEntity> groupMembers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<SanctionEntity> sanctions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<CategoryEntity> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private Set<TreasureHuntEntity> treasureHunts = new LinkedHashSet<>();

    public String getName() {
        return name;
    }

    @Column(name = "deleted_at")
    private LocalDate deleted_at;

    @Column(name = "last_modification_at")
    private LocalDate last_modification_at;

    @Column(name = "created_at")
    private LocalDate created_at;

    public Set<TreasureHuntEntity> getTreasureHunts() {
        return treasureHunts;
    }

    public void setTreasureHunts(Set<TreasureHuntEntity> treasureHunts) {
        this.treasureHunts = treasureHunts;
    }

    public Set<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEntity> categories) {
        this.categories = categories;
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

    public Set<GroupRuleEntity> getRules() {
        return rules;
    }

    public void setRules(Set<GroupRuleEntity> rules) {
        this.rules = rules;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }

    public Set<GroupModeratorEntity> getModerators() {
        return moderators;
    }

    public void setModerators(Set<GroupModeratorEntity> moderators) {
        this.moderators = moderators;
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

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}