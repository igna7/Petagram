package com.ignacioruben7.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ignacioruben7.petagram.R;
import com.ignacioruben7.petagram.adapter.AdatperInstagramprofile;
import com.ignacioruben7.petagram.adapter.MascotaAdapter;
import com.ignacioruben7.petagram.pojo.Mascota;
import com.ignacioruben7.petagram.presentador.FavoritosFragmentPresenter;
import com.ignacioruben7.petagram.presentador.IFavoritosFragmentPresenter;
import com.ignacioruben7.petagram.presentador.IMascotasFragmentPresenter;
import com.ignacioruben7.petagram.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascota extends Fragment implements IFavoritosFragmentView{

    private RecyclerView listaFavoritos;
    ArrayList<Mascota> mascotas;
    private IFavoritosFragmentPresenter presenter;
    public PerfilMascota() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota,container,false);
        listaFavoritos = (RecyclerView) v.findViewById(R.id.rvInstagramMascotas);
        presenter = new FavoritosFragmentPresenter(this, getContext());
        return v;
    }

    /*
    public void initMascotasCard(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Chester",R.drawable.mascota1,2));
        mascotas.add(new Mascota("Daysi",R.drawable.mascota2,4));
        mascotas.add(new Mascota("Perry",R.drawable.mascota3,5));
        mascotas.add(new Mascota("Bestia",R.drawable.mascota4,6));
        mascotas.add(new Mascota("Corsar",R.drawable.mascota5,8));
        mascotas.add(new Mascota("Zu",R.drawable.mascota6,0));
        mascotas.add(new Mascota("Chester",R.drawable.mascota7,2));
        mascotas.add(new Mascota("Daysi",R.drawable.mascota8,4));
        mascotas.add(new Mascota("Perry",R.drawable.mascota9,5));

    }*/

    @Override
    public void generarLinearLayoutVertical() {
        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(LinearLayoutManager.VERTICAL);
        listaFavoritos.setLayoutManager(glm);
    }

    @Override
    public AdatperInstagramprofile crearAdaptador(ArrayList<Mascota> mascotas) {
        AdatperInstagramprofile adatperInstagramprofile = new AdatperInstagramprofile(mascotas,getActivity());
        return adatperInstagramprofile;
    }

    @Override
    public void inicializarAdaptadorRV(AdatperInstagramprofile adatperInstagramprofile) {
        listaFavoritos.setAdapter(adatperInstagramprofile);
    }
}
