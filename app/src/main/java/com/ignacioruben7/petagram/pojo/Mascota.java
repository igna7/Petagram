package com.ignacioruben7.petagram.pojo;

/**
 * Created by ignacio on 23/06/16.
 */
public class Mascota {
    private int id;
    private String nombre;
    private int foto;
    private int rate;

    public Mascota() {

    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Mascota(String nombre, int foto, int rate) {
        this.nombre = nombre;
        this.foto = foto;
        this.rate = rate;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
