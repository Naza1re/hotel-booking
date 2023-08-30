package com.example.hotelbooking.DataBaseConnection;

import com.example.hotelbooking.Models.Room;
import org.hibernate.Session;

public class RoomDB {

        public static Room getRoomById(Long id){
            Session session = DBSession.getSession();
            session.beginTransaction();
            Room room = session.get(Room.class,id);
            session.getTransaction().commit();
            return room;
        }   
}
