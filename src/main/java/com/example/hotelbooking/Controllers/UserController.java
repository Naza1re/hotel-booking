package com.example.hotelbooking.Controllers;

import com.example.hotelbooking.DataBaseConnection.DBSession;
import com.example.hotelbooking.DataBaseConnection.UserDB;
import com.example.hotelbooking.Models.User;
import jakarta.persistence.Entity;
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
public class UserController {

    @GetMapping("/addUser")
    public String addUserPage(){
        return "add-user";
    }
    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user){
        Session session = DBSession.getSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        return "main";
    }

    @GetMapping("/allUsers")
    public String allUsers(Model model){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("From User", User.class);
        List<User> users = query.list();
        model.addAttribute("users",users);
        session.getTransaction().commit();
        return "all-users";
    }

    @GetMapping("/user{id}")
    public String profile(@PathVariable Long id,Model model){
        Session session = DBSession.getSession();
        session.beginTransaction();
        User user = UserDB.getUserById(id);
        
        model.addAttribute("user",user);
        session.getTransaction().commit();
        return "user-details";
    }






}
