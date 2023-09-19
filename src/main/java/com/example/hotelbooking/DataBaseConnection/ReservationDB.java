package com.example.hotelbooking.DataBaseConnection;

import com.example.hotelbooking.Models.Hotel;
import com.example.hotelbooking.Models.Reservation;
import org.hibernate.Session;

public class ReservationDB {

    public static Reservation getReservationById(Long id){
        Session session = DBSession.getSession();
        session.beginTransaction();
        Reservation reservation = session.get(Reservation.class,id);
        session.getTransaction().commit();
        return reservation;
    }


}
