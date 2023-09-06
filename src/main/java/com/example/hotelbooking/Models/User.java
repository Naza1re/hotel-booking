package com.example.hotelbooking.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }
    public User(){
    }

    public User(String name, String phoneNumber, String mail) {
        this.name = name;
        this.phone_Number = phoneNumber;
        this.mail = mail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phone_Number;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phone_Number = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name = "name")
    private String name;
    @Column(name = "phone_Number")
    private String phone_Number;

    @Column(name = "mail")
    private String mail;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
