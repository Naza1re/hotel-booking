package com.example.hotelbooking.Models;


import jakarta.persistence.*;

@Entity
@Table(name = "room")
public class Room {

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "number")
    private int number;
    @Column(name = "seats")
    private int seats;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
