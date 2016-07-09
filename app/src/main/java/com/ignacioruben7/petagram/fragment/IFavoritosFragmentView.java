package com.ignacioruben7.petagram.fragment;

import com.ignacioruben7.petagram.adapter.AdatperInstagramprofile;
import com.ignacioruben7.petagram.adapter.MascotaAdapter;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 08/07/16.
 */
public interface IFavoritosFragmentView {
    public void generarLinearLayoutVertical();

    public AdatperInstagramprofile crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(AdatperInstagramprofile adatperInstagramprofile);
}
