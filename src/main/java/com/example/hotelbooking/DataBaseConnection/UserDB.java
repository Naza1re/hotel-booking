package com.example.hotelbooking.DataBaseConnection;

import com.example.hotelbooking.Models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class UserDB {

    public static User getUserById(Long id){
        Session session = DBSession.getSession();
        session.beginTransaction();
        User user = session.get(User.class,id);
        session.getTransaction().commit();
        return user;
    }
    public static User getUserByName(String name1){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Query<User> query = session.createQuery("from User where name = :name1",User.class);
        System.out.println(query);
        query.setParameter("name1",name1);
        User user = query.uniqueResult();
        return user;
    }
}
