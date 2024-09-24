package com.example.user_profile.mapper;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.dto.UserDto;
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
                ticket.getUser() != null ? UserMapper.mapToUserDto(ticket.getUser()) : null


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
                ticketDto.getUser() != null ? UserMapper.mapToUser(ticketDto.getUser()) : null
        );
    }

}
