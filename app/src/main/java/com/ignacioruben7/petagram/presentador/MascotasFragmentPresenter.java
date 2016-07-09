package com.ignacioruben7.petagram.presentador;

import android.content.Context;

import com.ignacioruben7.petagram.database.ConstructorMascotas;
import com.ignacioruben7.petagram.fragment.IMascotasFragmentView;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 07/07/16.
 */
public class MascotasFragmentPresenter implements IMascotasFragmentPresenter{
    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.mascotasPrincipal();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iMascotasFragmentView.inicializarAdaptadorRV(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }
}
