package com.harymen.app.listademascotas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Listado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Listado extends Fragment {
    RecyclerView rvMascotas1;
    public ArrayList<Mascota> mascotas;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Listado() {
        // Required empty public constructor
    }

    public static Listado newInstance(String param1, String param2) {
        Listado fragment = new Listado();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mascotas = new ArrayList<Mascota>();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

            int size = getArguments().getInt("size");
            for(int i=0;i<size;i++){
                int image = getArguments().getInt("image"+i);
                String nombre = getArguments().getString("nombre"+i);
                int likes = getArguments().getInt("likes"+i);
                mascotas.add(new Mascota(nombre,image,likes));
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_listado, container, false);
        rvMascotas1 =(RecyclerView) v.findViewById(R.id.rvMascotas1);
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas1.setLayoutManager(llm);
        inicializarAdaptador();
        return v;
    }
    private void inicializarAdaptador(){
        MainAdapter adapter = new MainAdapter(mascotas/*,this*/);
        rvMascotas1.setAdapter(adapter);
    }
}