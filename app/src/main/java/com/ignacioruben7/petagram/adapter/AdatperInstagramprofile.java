package com.ignacioruben7.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.ignacioruben7.petagram.R;
import com.ignacioruben7.petagram.pojo.Mascota;

import java.util.ArrayList;

/**
 * Created by ignacio on 08/07/16.
 */
public class AdatperInstagramprofile extends RecyclerView.Adapter<AdatperInstagramprofile.AdatperInstagramprofileViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;

    public AdatperInstagramprofile(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public AdatperInstagramprofileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_instagram,parent,false);
        return new AdatperInstagramprofileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final AdatperInstagramprofileViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgMascotaCard.setImageResource(mascota.getFoto());
        holder.tvCounterLikesCard.setText(String.valueOf(mascota.getRate()));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class AdatperInstagramprofileViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgMascotaCard;
        private TextView tvCounterLikesCard;
        private ImageButton btnCountLikesCard;

        public AdatperInstagramprofileViewHolder(View itemView){
            super(itemView);

            imgMascotaCard = (ImageView) itemView.findViewById(R.id.imgMascotaCard);
            tvCounterLikesCard = (TextView) itemView.findViewById(R.id.tvCounterLikesCard);
            btnCountLikesCard = (ImageButton) itemView.findViewById(R.id.btnCountLikesCard);
        }
    }


}
