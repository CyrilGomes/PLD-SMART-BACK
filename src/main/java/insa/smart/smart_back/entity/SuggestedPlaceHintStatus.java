package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "suggested_place_hint_status")
public class SuggestedPlaceHintStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "changed_at")
    private LocalDate changed_at;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity status;

    @ManyToOne
    @JoinColumn(name = "suggested_place_hint_id")
    private SuggestedPlaceHintEntity suggestedPlaceHint;

    public LocalDate getChanged_at() {
        return changed_at;
    }

    public void setChanged_at(LocalDate changed_at) {
        this.changed_at = changed_at;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }

    public SuggestedPlaceHintEntity getSuggestedPlaceHint() {
        return suggestedPlaceHint;
    }

    public void setSuggestedPlaceHint(SuggestedPlaceHintEntity suggestedPlaceHint) {
        this.suggestedPlaceHint = suggestedPlaceHint;
    }
}