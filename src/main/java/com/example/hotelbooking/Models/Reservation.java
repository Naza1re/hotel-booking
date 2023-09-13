package com.example.hotelbooking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", arrival_date='" + arrival_date + '\'' +
                ", date_of_departure='" + date_of_departure + '\'' +
                ", user=" + user +
                ", room=" + room +
                '}';
    }

    @Column(name = "arrival_date")
    private String arrival_date;

    @Column(name = "date_of_departure")
    private String date_of_departure;



    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Reservation(String arrival_date, String date_of_departure, User user, Room room) {
        this.arrival_date = arrival_date;
        this.date_of_departure = date_of_departure;
        this.user = user;
        this.room = room;
    }



}
