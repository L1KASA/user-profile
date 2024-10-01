package com.example.user_profile.dto;

import com.example.user_profile.entity.Ticket;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class LuggageDto {

    private Long id;

    private String type;

    private Integer weight;

    private TicketDto ticket;
}