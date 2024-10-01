package com.example.user_profile.service;

import com.example.user_profile.dto.TicketDto;

import java.util.List;


public interface TicketService {
    TicketDto addTicket(TicketDto ticketDto);

    TicketDto getTicketById(long id);

    List<TicketDto> getAllTickets();

    TicketDto updateTicket(Long id, TicketDto updatedTicket);

    TicketDto assignUserToTicket(Long id, Long userId);

    TicketDto unassignUserFromTicket(Long id);

    List<TicketDto> findTicketsByUserId(Long userId);

    void deleteTicket(Long id);
}
