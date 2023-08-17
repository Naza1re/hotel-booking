package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.DataBaseConnection.HotelDB;
import com.example.hotelbooking.DataBaseConnection.RoomDB;
import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@Controller
public class RoomController {
    @GetMapping("/rooms")
    public String roomsPage(@PathVariable Long id, Model model){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Hotel hotel = HotelDB.getHotelById(id);
        model.addAttribute("hotel",hotel);

        Query<Room> query = session.createQuery("FROM Room WHERE hotel = :hotel", Room.class);
        query.setParameter("hotel",hotel);
        List<Room> rooms = query.list();
            model.addAttribute("rooms",rooms);
            session.getTransaction().commit();
        return "rooms";
    }
    @GetMapping("/allRooms")
    public String allRoomsPage(Model model){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Query<Room> query = session.createQuery("FROM Room" , Room.class);
        List<Room> rooms = query.list();
        System.out.println(rooms);
        model.addAttribute("rooms",rooms);
        session.getTransaction().commit();
        return "allRooms";
    }
    @GetMapping("/booking/{id}")
    public String showBookingPage(@PathVariable Long id, Model model) {
            Session session = DBSession.getSession();
            session.beginTransaction();
            Room room = RoomDB.getRoomById(id);
            model.addAttribute("room",room);

            session.getTransaction().commit();
        return "booking";
    }



}
