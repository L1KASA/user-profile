package com.example.user_profile.service.impl;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.entity.Ticket;
import com.example.user_profile.exception.ResourceNotFoundException;
import com.example.user_profile.mapper.TicketMapper;
import com.example.user_profile.repository.TicketRepository;
import com.example.user_profile.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Override
    public TicketDto addTicket(TicketDto ticketDto) {
        Ticket ticket = TicketMapper.mapToUser(ticketDto);
        ticketRepository.save(ticket);
        return TicketMapper.mapToUserDto(ticket);
    }

    @Override
    public TicketDto getTicketById(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id));

        return TicketMapper.mapToUserDto(ticket);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();

        return tickets.stream().map(TicketMapper::mapToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto updatedTicket) {

        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id)
        );

        ticket.setFlight(updatedTicket.getFlight());
        ticket.setPrice(updatedTicket.getPrice());
        ticket.setArrival(updatedTicket.getArrival());
        ticket.setDeparture(updatedTicket.getDeparture());
        ticket.setGate(ticket.getGate());
        ticket.setPointOfArrival(updatedTicket.getPointOfArrival());
        ticket.setPointOfDeparture(updatedTicket.getPointOfDeparture());
        ticket.setSeat(updatedTicket.getSeat());

        ticketRepository.save(ticket);

        return TicketMapper.mapToUserDto(ticket);
    }

    @Override
    public void deleteTicket(Long id) {

        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id)
        );

        ticketRepository.delete(ticket);

    }


}
