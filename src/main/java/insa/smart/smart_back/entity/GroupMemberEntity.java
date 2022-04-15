package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "group_member")
public class GroupMemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToMany(mappedBy = "groupMember", orphanRemoval = true)
    private Set<TransactionEntity> transactions = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    @Column(name = "joined_at", nullable = false)
    private LocalDate joined_at;

    @Column(name = "coin", nullable = false)
    private Integer coin;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private GroupEntity group;

    @Column(name = "left_at")
    private LocalDate left_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Set<TransactionEntity> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<TransactionEntity> transactions) {
        this.transactions = transactions;
    }

    public LocalDate getLeft_at() {
        return left_at;
    }

    public void setLeft_at(LocalDate left_at) {
        this.left_at = left_at;
    }

    public LocalDate getJoined_at() {
        return joined_at;
    }

    public void setJoined_at(LocalDate joined_at) {
        this.joined_at = joined_at;
    }

    public Integer getCoin() {
        return coin;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public GroupEntity getGroup() {
        return group;
    }

    public void setGroup(GroupEntity group) {
        this.group = group;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setId(Long id) {
        this.id = id;
    }

}