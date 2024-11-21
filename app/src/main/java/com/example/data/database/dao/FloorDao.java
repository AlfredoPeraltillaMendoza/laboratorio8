package com.example.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.data.entities.Floor;


import java.util.List;

@Dao
public interface FloorDao {
    @Insert
    void insert(Floor floor);

    @Query("SELECT * FROM Floor WHERE buildingId = :buildingId")
    List<Floor> getFloorsByBuilding(int buildingId);
}