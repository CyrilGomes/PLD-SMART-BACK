package insa.smart.smart_back.entity;

import org.geolatte.geom.Point;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "place")
public class PlaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceUserVisitedEntity> placeUserVisitedEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceUserStarredEntity> placeUserStarredEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<CommentEntity> comments = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceCategoryEntity> places = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceHistoryEntity> history = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceStatusEntity> statuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceReportEntity> reports = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<PlaceHintEntity> hints = new LinkedHashSet<>();

    @OneToMany(mappedBy = "place", orphanRemoval = true)
    private Set<SuggestedPlaceHintEntity> suggestedHints = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "position", nullable = false)
    private Point position;

    @Column(name = "deleted_at")
    private LocalDate deleted_at;

    @Column(name = "last_modification_at")
    private LocalDate last_modification_at;

    @Column(name = "created_at")
    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private UserEntity created_by;

    public Set<SuggestedPlaceHintEntity> getSuggestedHints() {
        return suggestedHints;
    }

    public void setSuggestedHints(Set<SuggestedPlaceHintEntity> suggestedHints) {
        this.suggestedHints = suggestedHints;
    }

    public Set<PlaceHintEntity> getHints() {
        return hints;
    }

    public void setHints(Set<PlaceHintEntity> hints) {
        this.hints = hints;
    }

    public Set<PlaceReportEntity> getReports() {
        return reports;
    }

    public void setReports(Set<PlaceReportEntity> reports) {
        this.reports = reports;
    }

    public Set<PlaceStatusEntity> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<PlaceStatusEntity> status) {
        this.statuses = status;
    }

    public Set<PlaceHistoryEntity> getHistory() {
        return history;
    }

    public void setHistory(Set<PlaceHistoryEntity> history) {
        this.history = history;
    }

    public Set<PlaceCategoryEntity> getPlaces() {
        return places;
    }

    public void setPlaces(Set<PlaceCategoryEntity> places) {
        this.places = places;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
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

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserEntity getCreated_by() {
        return created_by;
    }

    public void setCreated_by(UserEntity userEntity) {
        this.created_by = userEntity;
    }

    public void setId(Long id) {
        this.id = id;
    }

}