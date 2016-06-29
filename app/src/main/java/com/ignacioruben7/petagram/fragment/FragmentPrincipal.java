package com.ignacioruben7.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ignacioruben7.petagram.R;
import com.ignacioruben7.petagram.adapter.MascotaAdapter;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 28/06/16.
 */
public class FragmentPrincipal extends Fragment{
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_principal,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);

        inicializarListaDeMascotas();
        inicializarAdaptador();
        return v;
    }
    public MascotaAdapter adapter;
    private void inicializarAdaptador(){
        adapter = new MascotaAdapter(mascotas, getActivity());
        listaMascotas.setAdapter(adapter);
    }

    public void inicializarListaDeMascotas(){
        mascotas = new ArrayList <Mascota>();

        mascotas.add(new Mascota("Arturito",R.drawable.mascota1,"5"));
        mascotas.add(new Mascota("Firulais",R.drawable.mascota2,"4"));
        mascotas.add(new Mascota("Shakiro",R.drawable.mascota3,"2"));
        mascotas.add(new Mascota("Snoopy",R.drawable.mascota4,"4"));
        mascotas.add(new Mascota("Ojitos",R.drawable.mascota5,"3"));
        mascotas.add(new Mascota("Alex",R.drawable.mascota6,"4"));
        mascotas.add(new Mascota("Miky",R.drawable.mascota7,"5"));
        mascotas.add(new Mascota("Flash",R.drawable.mascota8,"4"));
        mascotas.add(new Mascota("Terminator",R.drawable.mascota9,"3"));

    }
}
