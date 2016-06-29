package com.ignacioruben7.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ignacioruben7.petagram.pojo.Mascota;
import com.ignacioruben7.petagram.R;

import java.util.ArrayList;

/**
 * Created by ignacio on 23/06/16.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter (ArrayList<Mascota> contactos, Activity activity){
        this.mascotas = contactos;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvName.setText(mascota.getNombre());
        mascotaViewHolder.tvRate.setText(mascota.getRate());

        mascotaViewHolder.imgBone1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity,"Añadiste a "+ mascota.getNombre() + " en tus Favoritos",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvName;
        private TextView tvRate;
        private ImageButton imgBone1;

        public MascotaViewHolder(View itemView) {
            super(itemView);

            imgFoto     = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvName      = (TextView) itemView.findViewById(R.id.tvName);
            tvRate     = (TextView) itemView.findViewById(R.id.tvRate);
            imgBone1 = (ImageButton) itemView.findViewById(R.id.imgBone1);
        }
    }

}
