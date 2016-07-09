package com.ignacioruben7.petagram.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 07/07/16.
 */
public class Database extends SQLiteOpenHelper {
    private Context context;
    public Database(Context context) {
        super(context, ConstantesDatabase.DATABASE_NAME, null, ConstantesDatabase.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryCrearTablaMascotas = "CREATE TABLE " + ConstantesDatabase.TABLE_MASCOTAS + "(" +
                ConstantesDatabase.TABLE_MASCOTAS_ID                   + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesDatabase.TABLE_MASCOTAS_NOMBRE                         + " TEXT, "+
                ConstantesDatabase.TABLE_MASCOTAS_FOTO                   + " INTEGER, "+
                ConstantesDatabase.TABLE_MASCOTAS_RATE                   + " TEXT "+
                ")";

        String queryCrearTablaMascotasFavoritas = "CREATE TABLE " + ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS + "(" +
                ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_ID                   + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_NOMBRE                         + " TEXT, "+
                ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_FOTO                   + " INTEGER, "+
                ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS_RATE                   + " TEXT "+
                ")";

        String queryCreartTablaRateMascotas= "CREATE TABLE " + ConstantesDatabase.TABLE_RATES_MASCOTAS + "(" +
                ConstantesDatabase.TABLE_RATES_MASCOTAS_ID                   + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                ConstantesDatabase.TABLE_RATES_MASCOTAS_ID_MASCOTAS                   + " INTEGER, "+
                ConstantesDatabase.TABLE_RATES_MASCOTAS_NUMERO_RATES                   + " INTEGER, "+
                "FOREIGN KEY (" + ConstantesDatabase.TABLE_RATES_MASCOTAS_ID_MASCOTAS+ ") " +
                "REFERENCES "+ ConstantesDatabase.TABLE_MASCOTAS + "("+ ConstantesDatabase.TABLE_MASCOTAS_ID +")"+
                ")";

        sqLiteDatabase.execSQL(queryCrearTablaMascotas);
        sqLiteDatabase.execSQL(queryCrearTablaMascotasFavoritas);
        sqLiteDatabase.execSQL(queryCreartTablaRateMascotas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXIST"+ ConstantesDatabase.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST"+ ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS);
        db.execSQL("DROP TABLE IF EXIST"+ ConstantesDatabase.TABLE_RATES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerMascotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String queryMascotas = "SELECT * FROM " + ConstantesDatabase.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryMascotas,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryRate = "SELECT COUNT ("+ ConstantesDatabase.TABLE_RATES_MASCOTAS_NUMERO_RATES +") as rates " +
                                " FROM " + ConstantesDatabase.TABLE_RATES_MASCOTAS +
                                " WHERE " + ConstantesDatabase.TABLE_RATES_MASCOTAS_ID_MASCOTAS + "=" + mascotaActual.getId();

            Cursor registrosRates = db.rawQuery(queryRate,null);
            if (registrosRates.moveToNext()){
                mascotaActual.setRate(registrosRates.getInt(0));
            }else {
                mascotaActual.setRate(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public ArrayList<Mascota> obtenerMascotasFavoritas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();
        String queryMascotas = "SELECT * FROM " + ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(queryMascotas,null);

        while (registros.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);
        }
        db.close();

        return mascotas;
    }

    public void insertarMascotas(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDatabase.TABLE_MASCOTAS,null, contentValues);
        db.close();
    }

    public void insertarFavoritos(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDatabase.TABLE_MASCOTAS_FAVORITAS,null, contentValues);
        db.close();
    }

    public void insertarRateMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesDatabase.TABLE_RATES_MASCOTAS,null,contentValues);
        db.close();
    }

    public int obtenerRatesMascota(Mascota mascota){
        int rate = 0;
        String query = "SELECT COUNT("+ ConstantesDatabase.TABLE_RATES_MASCOTAS_NUMERO_RATES +")" +
                        " FROM "+ ConstantesDatabase.TABLE_RATES_MASCOTAS +
                        " WHERE " + ConstantesDatabase.TABLE_RATES_MASCOTAS_ID_MASCOTAS + "="+mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        if (registros.moveToNext()){
            rate = registros.getInt(0);
        }
        db.close();

        return rate;
    }

}
