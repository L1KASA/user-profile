package com.example.user_profile.entity;

import jakarta.persistence.PreRemove;

public class UserRemoveListener {
    @PreRemove
    public void onUserRemove(User user) {
        //user.getTickets().forEach(ticket -> ticket.setUser(null));
        return
    }
}
