package com.harymen.app.listademascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList <Mascota> mascotas;
    private RecyclerView rvMascotas1;
    TextView tvTitulo;
    Mascota top1;
    Mascota top2;
    Mascota top3;
    Mascota top4;
    Mascota top5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitulo=(TextView) findViewById(R.id.tvTitulo);
        Toolbar myActionBar = (Toolbar) findViewById(R.id.myActionBar);
        setSupportActionBar(myActionBar);
        rvMascotas1=(RecyclerView) findViewById(R.id.rvMascotas1);
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas1.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

        TabLayout tabLayout=(TabLayout) findViewById(R.id.tablayout);
        ViewPager viewPager=(ViewPager) findViewById(R.id.viewPager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_view:
                buscarTop();
                Intent intent= new Intent(this,RaitingMascotas.class);
                intent.putExtra("Nombre1",top1.getNombre());
                intent.putExtra("Likes1",top1.getLikes());
                intent.putExtra("Foto1",top1.getFoto());
                intent.putExtra("Nombre2",top2.getNombre());
                intent.putExtra("Likes2",top2.getLikes());
                intent.putExtra("Foto2",top2.getFoto());
                intent.putExtra("Nombre3",top3.getNombre());
                intent.putExtra("Likes3",top3.getLikes());
                intent.putExtra("Foto3",top3.getFoto());
                intent.putExtra("Nombre4",top4.getNombre());
                intent.putExtra("Likes4",top4.getLikes());
                intent.putExtra("Foto4",top4.getFoto());
                intent.putExtra("Nombre5",top5.getNombre());
                intent.putExtra("Likes5",top5.getLikes());
                intent.putExtra("Foto5",top5.getFoto());
                //tvTitulo.setText(top1.getNombre() + " " + top2.getNombre());
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void inicializarAdaptador(){
        MainAdapter adapter = new MainAdapter(mascotas/*,this*/);
        rvMascotas1.setAdapter(adapter);
    }
    private void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Damita", R.drawable.damita, 0));
        mascotas.add(new Mascota("Pluto", R.drawable.plutoo, 0));
        mascotas.add(new Mascota("Vagabundo", R.drawable.perro, 0));
        mascotas.add(new Mascota("Bethoven", R.drawable.bethovenn, 0));
        mascotas.add(new Mascota("Rex", R.drawable.rexx, 0));
        mascotas.add(new Mascota("Firulays", R.drawable.firulayss, 0));
        mascotas.add(new Mascota("Ay. de santa", R.drawable.ayudante, 0));
        mascotas.add(new Mascota("Odie", R.drawable.odiee, 0));
        mascotas.add(new Mascota("George", R.drawable.georgee, 0));
        mascotas.add(new Mascota("Scooby Doo", R.drawable.scoobydooo, 0));
        mascotas.add(new Mascota("Corage", R.drawable.coragee, 0));
        mascotas.add(new Mascota("Spike", R.drawable.spikee, 0));
        mascotas.add(new Mascota("Bee", R.drawable.beee, 0));
        mascotas.add(new Mascota("Ralph", R.drawable.ralphh, 0));
        mascotas.add(new Mascota("Bolt", R.drawable.boltt, 0));
        //mascotas.add(new Mascota("hueso", R.drawable.huesoamarilloo, 0));
    }
    private void buscarTop(){
        int m=mascotas.size();
        int ind1=-1; int ind2=-1; int ind3=-1; int ind4=-1; int ind5=-1;

        for (int i = 0; i < m ; i++){
            if (i==0){
                top1=mascotas.get(i);
                ind1=i;
                ind2=i;ind3=i;ind4=i;ind5=i;
                top2=mascotas.get(i); top3=mascotas.get(i);
                top4=mascotas.get(i); top5=mascotas.get(i);
            } else{
                if (mascotas.get(i).getLikes()>top1.getLikes()){
                    top1=mascotas.get(i);
                    ind1=i;
                }
                if(mascotas.get(i).getLikes()<top2.getLikes()){
                    ind2=i;ind3=i;ind4=i;ind5=i;
                    top2=mascotas.get(i); top3=mascotas.get(i);
                    top4=mascotas.get(i); top5=mascotas.get(i);
                }
            }
        }//for primero
        for (int i = 0; i < m ; i++){
            if (i!=ind1){
                if (mascotas.get(i).getLikes()>=top2.getLikes()){
                    top2=mascotas.get(i);
                    ind2=i;
                }
            }
        }//for segundo
        for (int i = 0; i < m ; i++){
            if (i!=ind1 & i!=ind2){
                if (mascotas.get(i).getLikes()>=top3.getLikes()){
                    top3=mascotas.get(i);
                    ind3=i;
                }
            }
        }//for tercero
        for (int i = 0; i < m ; i++){
            if (i!=ind1 & i!=ind2 & i!= ind3){
                if (mascotas.get(i).getLikes()>=top4.getLikes()){
                    top4=mascotas.get(i);
                    ind4=i;
                }
            }
        }//for cuarto
        for (int i = 0; i < m ; i++){
            if (i!=ind1 & i!=ind2& i!= ind3 & i!=ind4){
                if (mascotas.get(i).getLikes()>=top5.getLikes()){
                    top5=mascotas.get(i);
                    ind5=i;
                }
            }
        }//for quinto
    }

}