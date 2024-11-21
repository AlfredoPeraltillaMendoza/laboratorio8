package com.example.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.data.entities.Room;


import java.util.List;

@Dao
public interface RoomDao {
    @Insert
    void insert(Room room);

    @Query("SELECT * FROM Room WHERE floorId = :floorId")
    List<Room> getRoomsByFloor(int floorId);
}