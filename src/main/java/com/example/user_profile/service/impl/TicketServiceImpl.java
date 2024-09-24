package com.example.user_profile.service.impl;

import com.example.user_profile.dto.TicketDto;
import com.example.user_profile.entity.Ticket;
import com.example.user_profile.entity.User;
import com.example.user_profile.exception.ResourceNotFoundException;
import com.example.user_profile.mapper.TicketMapper;
import com.example.user_profile.repository.TicketRepository;
import com.example.user_profile.repository.UserRepository;
import com.example.user_profile.service.TicketService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TicketServiceImpl implements TicketService {

    private UserRepository userRepository;
    private TicketRepository ticketRepository;

    @Override
    public TicketDto addTicket(TicketDto ticketDto) {


        Ticket ticket = TicketMapper.mapToTicket(ticketDto);

        if (ticketDto.getUser() != null && ticketDto.getUser().getId() != null) {
            User user = userRepository.findById(ticketDto.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("User not found"));
            ticket.setUser(user);  // Связываем пользователя с билетом
        }

        ticketRepository.save(ticket);
        return TicketMapper.mapToTicketDto(ticket);
    }

    @Override
    public TicketDto getTicketById(long id) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id));

        return TicketMapper.mapToTicketDto(ticket);
    }

    @Override
    public List<TicketDto> getAllTickets() {
        List<Ticket> tickets = ticketRepository.findAll();

        return tickets.stream().map(TicketMapper::mapToTicketDto)
                .collect(Collectors.toList());
    }

    @Override
    public TicketDto updateTicket(Long id, TicketDto updatedTicket) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id)
        );

        Optional.ofNullable(updatedTicket.getFlight()).ifPresent(ticket::setFlight);
        Optional.ofNullable(updatedTicket.getDeparture()).ifPresent(ticket::setDeparture);
        Optional.ofNullable(updatedTicket.getArrival()).ifPresent(ticket::setArrival);
        Optional.ofNullable(updatedTicket.getGate()).ifPresent(ticket::setGate);
        Optional.ofNullable(updatedTicket.getSeat()).ifPresent(ticket::setSeat);
        Optional.ofNullable(updatedTicket.getPointOfArrival()).ifPresent(ticket::setPointOfArrival);
        Optional.ofNullable(updatedTicket.getPointOfDeparture()).ifPresent(ticket::setPointOfDeparture);
        Optional.ofNullable(updatedTicket.getPrice()).ifPresent(ticket::setPrice);

        Ticket updatedTicketObj = ticketRepository.save(ticket);

        return TicketMapper.mapToTicketDto(updatedTicketObj);
    }

    @Override
    public TicketDto assignUserToTicket(Long id, Long userId, TicketDto ticketDto) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id)
        );

        Optional.ofNullable(ticketDto.getUser()).ifPresent( userDto -> {
            ticket.setUser(userRepository.findById(userId).orElseThrow(
                    () -> new ResourceNotFoundException("User is not exists with given id " + userId)
            ));
                }
        );

        ticketRepository.save(ticket);

        return TicketMapper.mapToTicketDto(ticket);
    }

    @Override
    public List<TicketDto> findTicketsByUserId(Long userId) {
        List<Ticket> tickets = ticketRepository.findTicketsByUserId(userId);

        return tickets.stream().map(TicketMapper::mapToTicketDto).collect(Collectors.toList());
    }

    @Override
    public void deleteTicket(Long id) {

        Ticket ticket = ticketRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Ticket is not exists with given id " + id)
        );

        ticket.setUser(null);

        ticketRepository.delete(ticket);

    }


}
