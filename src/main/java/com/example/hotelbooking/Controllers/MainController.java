package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.HotelDTO;
import com.example.hotelbooking.Models.User;
import jakarta.servlet.annotation.HandlesTypes;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    @GetMapping("/addHotel")
    public String addHotelPage(){
        return "add-hotel";
    }
    @PostMapping("/addHotel")
    public String addHotel(@ModelAttribute Hotel hotel) {
        Session session = DBSession.getSession();
        session.beginTransaction();
        session.save(hotel);
        session.getTransaction().commit();
        return "main";
    }
    @GetMapping("/addUser")
    public String addUserPage(){
        return "add-user";
    }

}
