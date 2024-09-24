package com.example.user_profile.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

public class UpdateAgeListener {

    @PrePersist
    @PreUpdate
    public void calculateAge( User p ) {
        if (p.getDateOfBirthday() != null) {
            p.setAge(ChronoUnit.YEARS.between(
                    LocalDateTime.ofInstant(Instant.ofEpochMilli(p.getDateOfBirthday().getTime()), ZoneOffset.UTC),
                    LocalDateTime.now())
            );
        }
    }

}
