package com.example.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Floor {
    @PrimaryKey
    public int id;

    public int buildingId; // Foreign key
    public int number;
}