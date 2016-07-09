package com.ignacioruben7.petagram.fragment;

import com.ignacioruben7.petagram.adapter.MascotaAdapter;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 07/07/16.
 */
public interface IMascotasFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdapter adaptador);
}
