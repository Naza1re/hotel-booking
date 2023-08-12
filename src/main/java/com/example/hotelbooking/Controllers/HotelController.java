package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HotelController{

    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute Hotel hotel) {
        Session session = DBSession.getSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        return "main";
    }
    @GetMapping("/hotels")
    public String hotels(Model model){
        Session session = DBSession.getSession();
        session.beginTransaction();
        List<Hotel> hotels = session.createQuery("FROM Hotel", Hotel.class).list();
        model.addAttribute("hotels",hotels);
        session.getTransaction().commit();

        return "hotels";
    }

}
