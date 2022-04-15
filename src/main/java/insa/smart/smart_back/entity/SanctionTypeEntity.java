package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "sanction_type")
public class SanctionTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @OneToMany(mappedBy = "sanctionType", orphanRemoval = true)
    private Set<SanctionEntity> sanctions = new LinkedHashSet<>();

    public Set<SanctionEntity> getSanctions() {
        return sanctions;
    }

    public void setSanctions(Set<SanctionEntity> sanctions) {
        this.sanctions = sanctions;
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