package com.example.user_profile.controller;

import com.example.user_profile.dto.TicketDto;

import com.example.user_profile.entity.Ticket;
import com.example.user_profile.service.TicketService;
import com.example.user_profile.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tickets")
@AllArgsConstructor
public class TicketController {

    private TicketService ticketService;


    @PostMapping
    public ResponseEntity<TicketDto> addTicket(@RequestBody TicketDto ticketDto) {
        TicketDto savedTicket = ticketService.addTicket(ticketDto);

        return new ResponseEntity<>(savedTicket, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketDto> getTicketById(@PathVariable long id) {

        TicketDto ticketDto = ticketService.getTicketById(id);

        return ResponseEntity.ok(ticketDto);
    }

    @GetMapping
    public ResponseEntity<List<TicketDto>> getAllTickets() {

        List<TicketDto> ticketsDto = ticketService.getAllTickets();

        return ResponseEntity.ok(ticketsDto);
    }

    @PutMapping("ticket/{ticketId}")
    public ResponseEntity<TicketDto> updateTicket(@PathVariable Long ticketId, @PathVariable Long userId, @RequestBody TicketDto updatedTicket) {
        TicketDto ticketDto = ticketService.updateTicket(ticketId, updatedTicket, userId);

        return ResponseEntity.ok(ticketDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTicket(@PathVariable("id") Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.ok("Ticket deleted successfully.");
    }

}
