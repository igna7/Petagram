package com.ignacioruben7.petagram.database;

import android.content.ContentValues;
import android.content.Context;

import com.ignacioruben7.petagram.R;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 07/07/16.
 */
public class ConstructorMascotas {
    private static final int RATE = 1;
    private Context context;
    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> mascotasPrincipal(){
        Database db = new Database(context);
        insertarTresMascotas(db);
        return db.obtenerMascotas();

    }

    public ArrayList<Mascota> mascotasFavoritos(){
        Database db = new Database(context);
        return db.obtenerMascotasFavoritas();

    }


    public void insertarTresMascotas(Database db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_NOMBRE,"Arturito");
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FOTO,R.drawable.mascota1);


        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_NOMBRE,"Firulais");
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FOTO,R.drawable.mascota2);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_NOMBRE,"Shakiro");
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FOTO,R.drawable.mascota3);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_NOMBRE,"Pedrito");
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_FOTO,R.drawable.mascota4);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_NOMBRE,"Ojitos");
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_FOTO,R.drawable.mascota5);

        db.insertarMascotas(contentValues);

        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_NOMBRE,"Santa");
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_FOTO,R.drawable.mascota6);

        db.insertarMascotas(contentValues);
    }

    public void añadirMascotaFavoritos(Mascota mascota){
        Database db = new Database(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_ID,mascota.getId());
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_NOMBRE, mascota.getNombre());
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_FOTO, mascota.getFoto());
        contentValues.put(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_RATE, mascota.getRate());
        db.insertarFavoritos(contentValues);
    }


    public void darRateMascota(Mascota mascota){
        Database db = new Database(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesDatabase.TABLE_RATES_MASCOTAS_ID_MASCOTAS,mascota.getId());
        contentValues.put(ConstantesDatabase.TABLE_RATES_MASCOTAS_NUMERO_RATES, RATE);
        db.insertarRateMascota(contentValues);
    }

    public int obtenerRatesMascotas(Mascota mascota){
        Database db = new Database(context);
        return db.obtenerRatesMascota(mascota);
    }
}
