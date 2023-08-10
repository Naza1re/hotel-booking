package com.example.hotelbooking.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "number")
    private int number;
    @Column(name = "seats")
    private int seats;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
