package com.example.user_profile.mapper;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.entity.Ticket;

import java.util.ArrayList;
import java.util.HashSet;

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
                null,

                new ArrayList<>()
        );

    }

    public static Ticket mapToTicket(TicketDto ticketDto) {

        return new Ticket(
                ticketDto.getId(),
                ticketDto.getFlight(),
                ticketDto.getPointOfDeparture(),
                ticketDto.getPointOfArrival(),
                ticketDto.getDeparture(),
                ticketDto.getArrival(),
                ticketDto.getPrice(),
                ticketDto.getSeat(),
                ticketDto.getGate(),
                ticketDto.getUser() != null ? UserMapper.mapToUser(ticketDto.getUser()) : null,

                ticketDto.getLuggages() != null ? new HashSet<>(ticketDto.getLuggages().stream()
                        .map(LuggageMapper::mapToLuggage)
                        .toList()) : new HashSet<>()
        );
    }

}
