package com.example.user_profile.repository;

import com.example.user_profile.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findTicketsByUserId(Long userId);
    //List<Ticket> findTicketsByUser_Name_FirstName_AndUserName
}
