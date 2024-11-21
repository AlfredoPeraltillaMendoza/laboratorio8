package com.example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;

import com.example.data.database.AppDatabase;
import com.example.data.entities.Building;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layoutId = getResources().getIdentifier("activity_main", "layout", getPackageName());
        if (layoutId != 0) {
            setContentView(layoutId);
        } else {
            throw new RuntimeException("Layout activity_main no encontrado.");
        }

        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class, "database-name"
        ).allowMainThreadQueries().build(); // Evitar en producción

        new Thread(() -> {
            try {
                // Insertar un nuevo edificio
                Building newBuilding = new Building();
                newBuilding.id = 1;
                newBuilding.name = "Edificio A";
                newBuilding.location = "Centro";
                db.buildingDao().insert(newBuilding);
                Log.d(TAG, "Edificio insertado: " + newBuilding.name);

                // Consultar todos los edificios
                List<Building> buildings = db.buildingDao().getAll();
                for (Building building : buildings) {
                    Log.d(TAG, "Edificio encontrado: ID=" + building.id + ", Nombre=" + building.name + ", Ubicación=" + building.location);
                }

                // Afdctualizar un edificio existente
                if (!buildings.isEmpty()) {
                    Building buildingToUpdate = buildings.get(0);
                    buildingToUpdate.location = "Zona Norte";
                    db.buildingDao().update(buildingToUpdate);
                    Log.d(TAG, "Edificio actualizado: " + buildingToUpdate.name + " -> Ubicación: " + buildingToUpdate.location);
                }

                // Eliminar un edificio por ID
                if (!buildings.isEmpty()) {
                    db.buildingDao().delete(buildings.get(0));
                    Log.d(TAG, "Primer edificio eliminado");
                }

                // 5. Consultar nuevamente después de eliminar
                List<Building> remainingBuildings = db.buildingDao().getAll();
                Log.d(TAG, "Edificios restantes: " + remainingBuildings.size());

            } catch (Exception e) {
                Log.e(TAG, "Error al interactuar con la base de datos", e);
            }
        }).start();
    }
}
