package com.example.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.data.database.dao.BuildingDao;
import com.example.data.database.dao.FloorDao;
import com.example.data.database.dao.RoomDao;
import com.example.data.entities.Building;
import com.example.data.entities.Floor;
import com.example.data.entities.Room;

@Database(entities = {Building.class, Floor.class, Room.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BuildingDao buildingDao();
    public abstract FloorDao floorDao();
    public abstract RoomDao roomDao();
}
