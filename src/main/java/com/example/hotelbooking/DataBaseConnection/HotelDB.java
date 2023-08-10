package com.example.hotelbooking.DataBaseConnection;

import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.Room;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HotelDB {

    public static Hotel getHotelById(Long id){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Hotel hotel = session.get(Hotel.class,id);
        session.getTransaction().commit();
        return hotel;
    }




}
