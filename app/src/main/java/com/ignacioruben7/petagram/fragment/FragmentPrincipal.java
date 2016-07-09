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
import com.ignacioruben7.petagram.presentador.IMascotasFragmentPresenter;
import com.ignacioruben7.petagram.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by ignacio on 28/06/16.
 */
public class FragmentPrincipal extends Fragment implements IMascotasFragmentView{
    private ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_principal,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new MascotasFragmentPresenter(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdapter adapter = new MascotaAdapter(mascotas, getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
