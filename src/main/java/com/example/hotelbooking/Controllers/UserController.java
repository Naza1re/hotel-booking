package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.Models.User;
import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/adduser")
    public String addUserPage(){
        return "add-user";
    }
    @PostMapping("/adduser")
    public String addUser(@ModelAttribute User user){
        Session session = DBSession.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return "main";
    }


}
