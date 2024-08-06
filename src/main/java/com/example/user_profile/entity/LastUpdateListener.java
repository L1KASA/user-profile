package com.example.user_profile.entity;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import java.util.Date;

public   class LastUpdateListener {

    @PreUpdate
    @PrePersist
    public void setLastUpdate( User p ) {
        p.setLastUpdate(new Date());
    }
}
