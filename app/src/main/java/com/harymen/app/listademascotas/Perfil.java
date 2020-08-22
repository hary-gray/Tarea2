package com.harymen.app.listademascotas;

import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Perfil#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Perfil extends Fragment {
    ArrayList<Fotos> imagesDamita;
    RecyclerView rvPerfil;
    CircleImageView ivCircular;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Perfil() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Perfil.
     */
    // TODO: Rename and change types and number of parameters
    public static Perfil newInstance(String param1, String param2) {
        Perfil fragment = new Perfil();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_perfil, container, false);
        ivCircular=(CircleImageView) v.findViewById(R.id.ivCircular);
        ivCircular.setBottom(50);
        rvPerfil=(RecyclerView) v.findViewById(R.id.rvPerfil);
        GridLayoutManager glm = new GridLayoutManager(getActivity(),2);
        rvPerfil.setLayoutManager(glm);
        iniciaFotos();
        iniciarAdaptador();
        return v;
    }
    public void iniciaFotos(){
        imagesDamita=new ArrayList<Fotos>();
        imagesDamita.add(new Fotos(R.drawable.damita,5));
        imagesDamita.add(new Fotos(R.drawable.damita,3));
        imagesDamita.add(new Fotos(R.drawable.damita,4));
        imagesDamita.add(new Fotos(R.drawable.damita,1));
        imagesDamita.add(new Fotos(R.drawable.damita,6));
        imagesDamita.add(new Fotos(R.drawable.damita,2));
        imagesDamita.add(new Fotos(R.drawable.damita,3));
    }
    private void iniciarAdaptador(){
        AdapterPerfil adapter = new AdapterPerfil(imagesDamita);
        rvPerfil.setAdapter(adapter);
    }

}