package com.harymen.app.listademascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.harymen.app.listademascotas.Adapatadores.MainAdapter;
import com.harymen.app.listademascotas.POJO.Mascota;

import java.util.ArrayList;

public class RaitingMascotas extends AppCompatActivity {
    ArrayList<Mascota> top_mascotas;
    RecyclerView rvRaiting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting_mascotas);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        rvRaiting = (RecyclerView) findViewById(R.id.rvRaiting);
        Bundle parametros = getIntent().getExtras();
        String nombre1 = parametros.getString("Nombre1");
        String nombre2 = parametros.getString("Nombre2");
        String nombre3 = parametros.getString("Nombre3");
        String nombre4 = parametros.getString("Nombre4");
        String nombre5 = parametros.getString("Nombre5");
        int foto1 = parametros.getInt("Foto1");
        int foto2 = parametros.getInt("Foto2");
        int foto3 = parametros.getInt("Foto3");
        int foto4 = parametros.getInt("Foto4");
        int foto5 = parametros.getInt("Foto5");
        int Likes1 = parametros.getInt("Likes1");
        int Likes2 = parametros.getInt("Likes2");
        int Likes3 = parametros.getInt("Likes3");
        int Likes4 = parametros.getInt("Likes4");
        int Likes5 = parametros.getInt("Likes5");
        top_mascotas = new ArrayList<Mascota>();
        top_mascotas.add(new Mascota(nombre1,foto1,Likes1));
        top_mascotas.add(new Mascota(nombre2,foto2,Likes2));
        top_mascotas.add(new Mascota(nombre3,foto3,Likes3));
        top_mascotas.add(new Mascota(nombre4,foto4,Likes4));
        top_mascotas.add(new Mascota(nombre5,foto5,Likes5));

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        rvRaiting.setLayoutManager(llm);
        inicilizar_adaptador();
    }
    private  void inicilizar_adaptador(){
    MainAdapter adapter = new MainAdapter(top_mascotas,this);
    rvRaiting.setAdapter(adapter);
    }
}