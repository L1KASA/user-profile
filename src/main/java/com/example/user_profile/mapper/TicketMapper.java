package com.example.user_profile.mapper;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.entity.Ticket;

public class TicketMapper {

    public static TicketDto mapToTicketDto(Ticket ticket) {

        return new TicketDto(
                ticket.getId(),
                ticket.getFlight(),
                ticket.getPointOfDeparture(),
                ticket.getPointOfArrival(),
                ticket.getDeparture(),
                ticket.getArrival(),
                ticket.getPrice(),
                ticket.getSeat(),
                ticket.getGate(),
                UserMapper.mapToUserDto(ticket.getUser())

        );

    }

    public static Ticket mapToTicket(TicketDto ticketDto) {

        return new Ticket(
                ticketDto.getId(),
                ticketDto.getFlight(),
                ticketDto.getPointOfDeparture(),
                ticketDto.getPointOfDeparture(),
                ticketDto.getDeparture(),
                ticketDto.getArrival(),
                ticketDto.getPrice(),
                ticketDto.getSeat(),
                ticketDto.getGate(),
                UserMapper.mapToUser(ticketDto.getUser())
        );
    }

}
