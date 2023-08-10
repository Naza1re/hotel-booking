package com.example.hotelbooking.DataBaseConnection;

import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.Room;
import com.example.hotelbooking.Models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBSession {
    public static Session getSession(){
        SessionFactory factory = new Configuration()
                .configure("hibernate.config.xml")
                .addAnnotatedClass(Hotel.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Room.class)
                .buildSessionFactory();


        Session session = factory.getCurrentSession();
        return session;
    }
}
