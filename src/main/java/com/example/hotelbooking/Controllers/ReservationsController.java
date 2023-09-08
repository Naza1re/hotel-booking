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
    public String makeReservation(@ModelAttribute Reservation reservation,@PathVariable Long id,@RequestParam("user") String user){
        Session session = DBSession.getSession();

        session.beginTransaction();
        User user1 = UserDB.getUserByName(user);
        reservation.setUser(user1);
        reservation.setRoom(RoomDB.getRoomById(id));
        session.save(reservation);
        session.getTransaction().commit();
        return "main";
    }



}
