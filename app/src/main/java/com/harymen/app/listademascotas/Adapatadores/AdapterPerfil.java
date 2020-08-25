package com.harymen.app.listademascotas.Adapatadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.harymen.app.listademascotas.POJO.Fotos;
import com.harymen.app.listademascotas.R;

import java.util.ArrayList;

public class AdapterPerfil extends RecyclerView.Adapter<AdapterPerfil.FotosViewHolder> {
    ArrayList<Fotos> images;
    public AdapterPerfil(ArrayList<Fotos> images) {
        this.images = images;
    }

    @NonNull
    @Override
    public FotosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fotos_perfil,parent,false);
        return new FotosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull FotosViewHolder holder, int position) {
    holder.imPerfil.setImageResource(images.get(position).getImage());
    holder.imLikesPerfil.setImageResource(R.drawable.huesoamarilloo);
    holder.tvLikesPerfil.setText(images.get(position).getLikes()+"");
    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public static class FotosViewHolder extends RecyclerView.ViewHolder {
        ImageView imPerfil;
        ImageView imLikesPerfil;
        TextView tvLikesPerfil;

        public FotosViewHolder(@NonNull View itemView) {
            super(itemView);
            imPerfil=(ImageView) itemView.findViewById(R.id.ivPerfiles);
            imLikesPerfil = (ImageView) itemView.findViewById(R.id.ivLikes);
            tvLikesPerfil = (TextView) itemView.findViewById(R.id.tvLikesPerfiles);
        }
    }
}
