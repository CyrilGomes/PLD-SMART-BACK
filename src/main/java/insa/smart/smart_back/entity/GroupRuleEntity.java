package insa.smart.smart_back.entity;

import javax.persistence.*;

@Entity
@Table(name = "group_rule")
public class GroupRuleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private RuleEntity rule;

    @Column(name = "value")
    private Boolean value;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public RuleEntity getRule() {
        return rule;
    }

    public void setRule(RuleEntity rule) {
        this.rule = rule;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}