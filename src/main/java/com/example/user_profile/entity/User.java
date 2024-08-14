package com.example.user_profile.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(LastUpdateListener.class)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Name name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String gender;

    @Column()
    private Date dateOfBirthday;
    @Column()
    private long age;

    @Column(nullable = true)
    @LastModifiedDate
    private Date lastUpdate;

    @PrePersist
    @PreUpdate
    public void calculateAge() {
        if (dateOfBirthday != null) {
            age = ChronoUnit.YEARS.between(
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(dateOfBirthday.getTime()), ZoneOffset.UTC),
                    LocalDateTime.now()
            );
        }
    }
}



