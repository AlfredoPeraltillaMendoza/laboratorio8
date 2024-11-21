package com.example.models;

import com.example.data.entities.Building;
import com.example.data.entities.Floor;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class BuildingWithFloors {
    @Embedded
    public Building building;

    @Relation(
            parentColumn = "id",
            entityColumn = "buildingId"
    )
    public List<Floor> floors;
}
