package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "status")
public class StatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<PlaceStatusEntity> place_statuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<PlaceReportEntity> place_reports = new LinkedHashSet<>();

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<CommentStatusEntity> comment_statuses = new LinkedHashSet<>();

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<CommentReportEntity> comment_reports = new LinkedHashSet<>();

    @OneToMany(mappedBy = "status", orphanRemoval = true)
    private Set<SuggestedPlaceHintStatus> suggestedPlaceHintStatuses = new LinkedHashSet<>();

    public Set<SuggestedPlaceHintStatus> getSuggestedPlaceHintStatuses() {
        return suggestedPlaceHintStatuses;
    }

    public void setSuggestedPlaceHintStatuses(Set<SuggestedPlaceHintStatus> suggestedPlaceHintStatuses) {
        this.suggestedPlaceHintStatuses = suggestedPlaceHintStatuses;
    }

    public Set<CommentReportEntity> getComment_reports() {
        return comment_reports;
    }

    public void setComment_reports(Set<CommentReportEntity> comment_reports) {
        this.comment_reports = comment_reports;
    }

    public Set<CommentStatusEntity> getComment_statuses() {
        return comment_statuses;
    }

    public void setComment_statuses(Set<CommentStatusEntity> comment_statuses) {
        this.comment_statuses = comment_statuses;
    }

    public Set<PlaceReportEntity> getPlace_reports() {
        return place_reports;
    }

    public void setPlace_reports(Set<PlaceReportEntity> place_reports) {
        this.place_reports = place_reports;
    }

    public Set<PlaceStatusEntity> getPlace_statuses() {
        return place_statuses;
    }

    public void setPlace_statuses(Set<PlaceStatusEntity> status) {
        this.place_statuses = status;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}