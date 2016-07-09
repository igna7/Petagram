package com.ignacioruben7.petagram.presentador;

import android.content.Context;

import com.ignacioruben7.petagram.database.ConstructorMascotas;
import com.ignacioruben7.petagram.fragment.IFavoritosFragmentView;
import com.ignacioruben7.petagram.fragment.IMascotasFragmentView;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 08/07/16.
 */
public class FavoritosFragmentPresenter implements IFavoritosFragmentPresenter {
    private IFavoritosFragmentView iFavoritosFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;
    public FavoritosFragmentPresenter(IFavoritosFragmentView iFavoritosFragmentView, Context context) {
        this.iFavoritosFragmentView = iFavoritosFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }

    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.mascotasFavoritos();
        mostrarMascotasRV();
    }

    @Override
    public void mostrarMascotasRV() {
        iFavoritosFragmentView.inicializarAdaptadorRV(iFavoritosFragmentView.crearAdaptador(mascotas));
        iFavoritosFragmentView.generarLinearLayoutVertical();
    }
}
