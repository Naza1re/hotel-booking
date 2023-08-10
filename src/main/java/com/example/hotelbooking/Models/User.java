package com.example.hotelbooking.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
