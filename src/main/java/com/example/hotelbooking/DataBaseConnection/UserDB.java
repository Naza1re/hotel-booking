package com.example.hotelbooking.DataBaseConnection;

import com.example.hotelbooking.Models.User;
import org.hibernate.Session;

public class UserDB {

    public static User getUserById(Long id){
        Session session = DBSession.getSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        return user;
    }
}
