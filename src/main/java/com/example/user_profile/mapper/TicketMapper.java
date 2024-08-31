package com.example.user_profile.mapper;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.Ticket;
import com.example.user_profile.entity.User;

public class TicketMapper {

    public static TicketDto mapToUserDto(Ticket ticket) {

        return new TicketDto(
                ticket.getId(),
                ticket.getTo(),
                ticket.getDeparture(),
                ticket.getArrival(),
                ticket.getFrom(),
                ticket.getTo(),
                ticket.getPrice(),
                ticket.getGate(),
                ticket.getSeat(),
                ticket.getUser()
        );

    }

    public static Ticket mapToUser(TicketDto ticketDto) {

        return new Ticket(
                ticketDto.getId(),
                ticketDto.getTo(),
                ticketDto.getDeparture(),
                ticketDto.getArrival(),
                ticketDto.getFrom(),
                ticketDto.getTo(),
                ticketDto.getPrice(),
                ticketDto.getGate(),
                ticketDto.getSeat(),
                ticketDto.getUser()
        );
    }

}
