package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.DataBaseConnection.RoomDB;
import com.example.hotelbooking.DataBaseConnection.UserDB;
import com.example.hotelbooking.Models.Reservation;
import com.example.hotelbooking.Models.User;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationsController {
    @PostMapping("/booking/{id}")
    public String makeReservation(
                                  @PathVariable Long id,
                                  @RequestParam("user") String user,
                                  @RequestParam("arrival_date") String arrivalDate,
                                  @RequestParam("data_of_departure") String departureDate){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Reservation reservation = new Reservation(arrivalDate,departureDate,UserDB.getUserByName(user),RoomDB.getRoomById(id));
        System.out.println(user);
        System.out.println(UserDB.getUserByName(user));
        session.save(reservation);
        session.getTransaction().commit();
        return "main";
    }



}
