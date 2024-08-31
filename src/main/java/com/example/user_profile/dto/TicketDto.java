package com.example.user_profile.dto;

import com.example.user_profile.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TicketDto {

    private Long id;

    private String flight;

    private Date departure;

    private Date arrival;

    private String from;

    private String to;

    private Integer price;

    private String gate;

    private String seat;

    private User user;

}
