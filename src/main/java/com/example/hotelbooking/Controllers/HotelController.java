package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.DataBaseConnection.HotelDB;
import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    @GetMapping("/hotels/rooms/{id}")
    public String showBookDetails(@PathVariable Long id, Model model) {
        Session session = DBSession.getSession();
        session.beginTransaction();
        Hotel hotel = session.get(Hotel.class,id);
        model.addAttribute("hotel", hotel);
        Query<Room> roomQuery = session.createQuery("FROM Room where hotel = :hotel", Room.class);
        roomQuery.setParameter("hotel", hotel);
        List<Room> rooms = roomQuery.list();
        model.addAttribute("rooms",rooms);
        session.getTransaction().commit();
        return "rooms";
    }


}
