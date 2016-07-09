package com.ignacioruben7.petagram.database;

/**
 * Created by ignacio on 07/07/16.
 */
public final class ConstantesDatabase {
    public static final String DATABASE_NAME = "mascotas";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_MASCOTAS = "mascotas";
    public static final String TABLE_MASCOTAS_ID = "id";
    public static final String TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_FOTO = "foto";
    public static final String TABLE_MASCOTAS_RATE = "rate";

    public static final String TABLE_MASCOTAS_FAVORITAS = "mascotas_favoritas";
    public static final String TABLE_MASCOTAS_FAVORITAS_ID = "id";
    public static final String TABLE_MASCOTAS_FAVORITAS_NOMBRE = "nombre";
    public static final String TABLE_MASCOTAS_FAVORITAS_FOTO = "foto";
    public static final String TABLE_MASCOTAS_FAVORITAS_RATE = "rate";

    public static final String TABLE_RATES_MASCOTAS = "mascotas_rates";
    public static final String TABLE_RATES_MASCOTAS_ID = "id";
    public static final String TABLE_RATES_MASCOTAS_ID_MASCOTAS = "id_mascota";
    public static final String TABLE_RATES_MASCOTAS_NUMERO_RATES = "numero_rates";
}
