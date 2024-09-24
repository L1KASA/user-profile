package com.example.user_profile.service;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.dto.UserDto;

import java.util.List;


public interface TicketService {
    TicketDto addTicket(TicketDto ticketDto);

    TicketDto getTicketById(long id);

    List<TicketDto> getAllTickets();

    TicketDto updateTicket(Long id, TicketDto updatedTicket);

    TicketDto assignUserToTicket(Long id, Long userId, TicketDto ticketDto);

    //TicketDto unassignUserFromTicket(Long id, Long userId, TicketDto ticketDto);

    List<TicketDto> findTicketsByUserId(Long userId);

    void deleteTicket(Long id);
}
