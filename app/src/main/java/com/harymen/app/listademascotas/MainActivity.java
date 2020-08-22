package com.harymen.app.listademascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TabLayout tablayout;
    private ViewPager viewpager;
    ArrayList<Mascota> mascotas;
    public Mascota top1;
    public Mascota top2;
    public Mascota top3;
    public Mascota top4;
    public Mascota top5;
    Bundle args;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tablayout =(TabLayout)  findViewById(R.id.tablayout);
        viewpager =(ViewPager) findViewById(R.id.viewpager);
        inicializarListaMascotas();
        iniciarViewPagerAdapter();
        if (toolbar !=null){
            setSupportActionBar(toolbar);
        }
    }
    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new Listado());
        fragments.add(new Perfil());
        fragments.get(0).setArguments(args);
        return fragments;
    }
    private void iniciarViewPagerAdapter(){
        viewpager.setAdapter(new ViepagerAdapter(getSupportFragmentManager(),agregarFragments()));
        tablayout.setupWithViewPager(viewpager);
        tablayout.getTabAt(0).setIcon(R.drawable.huesoblancoo);
        tablayout.getTabAt(1).setIcon(R.drawable.huesoamarilloo);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_view:
                buscarTop(mascotas);
                Intent intent= new Intent(this,RaitingMascotas.class);
                intent.putExtra("Nombre1",top1.getNombre());
                intent.putExtra("Likes1",6);
                intent.putExtra("Foto1",top1.getFoto());
                intent.putExtra("Nombre2",top2.getNombre());
                intent.putExtra("Likes2",4);
                intent.putExtra("Foto2",top2.getFoto());
                intent.putExtra("Nombre3",top3.getNombre());
                intent.putExtra("Likes3",4);
                intent.putExtra("Foto3",top3.getFoto());
                intent.putExtra("Nombre4",top4.getNombre());
                intent.putExtra("Likes4",3);
                intent.putExtra("Foto4",top4.getFoto());
                intent.putExtra("Nombre5",top5.getNombre());
                intent.putExtra("Likes5",2);
                intent.putExtra("Foto5",top5.getFoto());
                //tvTitulo.setText(top1.getNombre() + " " + top2.getNombre());
                startActivity(intent);

                break;
            case R.id.contacto:
                Intent intent1 = new Intent(MainActivity.this,MensajeContacto.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
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
         args = new Bundle();
        for (int i = 0; i<mascotas.size();i++){
            args.putInt("image"+i,mascotas.get(i).getFoto());
            args.putString("nombre"+i,mascotas.get(i).getNombre());
            args.putInt("likes"+i,mascotas.get(i).getLikes());
        }
        args.putInt("size",mascotas.size());
    }
    public void buscarTop(ArrayList<Mascota> mascotas){
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