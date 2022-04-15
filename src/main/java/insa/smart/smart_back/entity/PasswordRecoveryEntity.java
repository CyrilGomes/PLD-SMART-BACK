package insa.smart.smart_back.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "password_recovery")
public class PasswordRecoveryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "closes_at", nullable = false)
    private LocalDate closes_at;

    @Column(name = "verification_token", nullable = false)
    private String verification_token;

    @Column(name = "created_at", nullable = false)
    private LocalDate created_at;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public LocalDate getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDate created_at) {
        this.created_at = created_at;
    }

    public LocalDate getCloses_at() {
        return closes_at;
    }

    public void setCloses_at(LocalDate closes_at) {
        this.closes_at = closes_at;
    }

    public String getVerification_token() {
        return verification_token;
    }

    public void setVerification_token(String verification_token) {
        this.verification_token = verification_token;
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