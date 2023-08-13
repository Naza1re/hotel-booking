package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.Models.Hotel;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/addHotel")
    public String addHotelPage(){
        return "add-hotel";
    }



}
