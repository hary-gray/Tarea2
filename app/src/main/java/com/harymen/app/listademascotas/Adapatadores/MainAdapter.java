package com.harymen.app.listademascotas.Adapatadores;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harymen.app.listademascotas.POJO.Mascota;
import com.harymen.app.listademascotas.R;
import com.harymen.app.listademascotas.db.ConstructoMascotas;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MainAdapter(ArrayList<Mascota> mascotas ,Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.maincardview,null,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, final int position) {
        holder.Asignar(mascotas.get(position));
        holder.ivHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mascota mascota=mascotas.get(position);
                //mascota.setLikes(mascota.getLikes()+1);
                ConstructoMascotas constructoMascotas= new ConstructoMascotas(activity);
                constructoMascotas.darLikeMascota(mascota);

                holder.tvLikes.setText(constructoMascotas.obtenerLikesMascota(mascota)+"");

            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
      private ImageView ivMyImage;
      private ImageView ivHuesoBlanco;
      private ImageView ivHuesoAmarillo;
      private TextView tvNombre;
      private TextView tvLikes;
      public MascotaViewHolder(@NonNull View itemView) {
          super(itemView);
          ivMyImage=(ImageView) itemView.findViewById(R.id.ivMyImage);
          ivHuesoBlanco =(ImageView) itemView.findViewById(R.id.ivHuesoBlanco);
          tvNombre =(TextView) itemView.findViewById(R.id.tvNombre);
          ivHuesoAmarillo =(ImageView) itemView.findViewById(R.id.ivHuesoAmarillo);
          tvLikes =(TextView) itemView.findViewById(R.id.tvLikes);
      }

        public void Asignar(Mascota mascota) {
           ivMyImage.setImageResource(mascota.getFoto());
           ivHuesoBlanco.setImageResource(R.drawable.huesoblancoo);
           tvNombre.setText(mascota.getNombre());
           ivHuesoAmarillo.setImageResource(R.drawable.huesoamarilloo);
           tvLikes.setText(mascota.getLikes()+"");
        }
    }

}
