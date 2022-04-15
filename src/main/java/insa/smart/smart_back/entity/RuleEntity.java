package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "rule")
public class RuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "label", nullable = false)
    private String label;

    @OneToMany(mappedBy = "rule", orphanRemoval = true)
    private Set<GroupRuleEntity> groupRuleEntities = new LinkedHashSet<>();

    public Set<GroupRuleEntity> getGroupRuleEntities() {
        return groupRuleEntities;
    }

    public void setGroupRuleEntities(Set<GroupRuleEntity> groupRuleEntities) {
        this.groupRuleEntities = groupRuleEntities;
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