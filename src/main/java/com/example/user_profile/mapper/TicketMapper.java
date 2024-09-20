package com.example.user_profile.mapper;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.dto.UserDto;
import com.example.user_profile.entity.Ticket;
import com.example.user_profile.entity.User;

public class TicketMapper {

    public static TicketDto mapToUserDto(Ticket ticket) {

        return new TicketDto(
                ticket.getId(),
                ticket.getFlight(),
                ticket.getPointOfDeparture(),
                ticket.getPointOfArrival(),
                ticket.getDeparture(),
                ticket.getArrival(),
                ticket.getPrice(),
                ticket.getSeat(),
                ticket.getGate()

        );

    }

    public static Ticket mapToUser(TicketDto ticketDto) {

        return new Ticket(
                ticketDto.getId(),
                ticketDto.getFlight(),
                ticketDto.getPointOfDeparture(),
                ticketDto.getPointOfDeparture(),
                ticketDto.getDeparture(),
                ticketDto.getArrival(),
                ticketDto.getPrice(),
                ticketDto.getSeat(),
                ticketDto.getGate()
        );
    }

}
