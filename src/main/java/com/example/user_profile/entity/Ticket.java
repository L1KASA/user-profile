package com.example.user_profile.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String flight;

    @Column(nullable = false)
    private Date departure;

    @Column(nullable = false)
    private Date arrival;

    @Column(nullable = false)
    private String from;

    @Column(nullable = false)
    private String to;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String gate;

    @Column(nullable = false, unique = true)
    private String seat;

    @ManyToOne
    private User user;

}
