package com.example.hotelbooking.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hotel")
public class Hotel {
    public Hotel(String name, String city, String street) {
        this.name = name;
        this.city = city;
        this.street = street;
    }

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "city")
    private String city;
    public Hotel(){

    }
    @Column(name = "room")
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Room> rooms;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Column(name = "street")
    private String street;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
