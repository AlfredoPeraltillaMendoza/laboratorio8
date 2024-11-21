package com.example.data.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.data.entities.Building;

import java.util.List;

@Dao
public interface BuildingDao {
    @Insert
    void insert(Building building);

    @Delete
    void delete(Building building);

    @Update
    void update(Building building);

    @Query("SELECT * FROM Building")
    List<Building> getAll();
}
