package com.example.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Room {
    @PrimaryKey
    public int id;

    public int floorId; // Foreign key
    public String name;
}