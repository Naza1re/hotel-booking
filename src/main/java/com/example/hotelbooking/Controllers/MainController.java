package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.Models.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(Model model){
        Session session = DBSession.getSession();
        session.beginTransaction();
        String sqlQuery = "FROM Room r WHERE r.id NOT IN (SELECT res.room.id FROM Reservation res)";
        Query<Room> query = session.createQuery(sqlQuery, Room.class);
        List<Room> rooms = query.list();
        System.out.println(rooms);
        model.addAttribute("rooms",rooms);
        session.getTransaction().commit();
        return "main";
    }

    @GetMapping("/addHotel")
    public String addHotelPage(){
        return "add-hotel";
    }
    @GetMapping("/login")
    public String login(){
        return "login";
    }



}
