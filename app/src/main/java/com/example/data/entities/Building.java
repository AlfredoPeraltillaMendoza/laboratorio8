package com.example.data.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Building {
    @PrimaryKey
    public int id;

    public String name;
    public String location;
}