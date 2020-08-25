package com.harymen.app.listademascotas.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.harymen.app.listademascotas.Adapatadores.MainAdapter;
import com.harymen.app.listademascotas.POJO.Mascota;
import com.harymen.app.listademascotas.Presentadores.IListadoPresenter;
import com.harymen.app.listademascotas.Presentadores.ListadoPresenter;
import com.harymen.app.listademascotas.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Listado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Listado extends Fragment implements IListado {
    RecyclerView rvMascotas1;
    private IListadoPresenter presenter;
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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_listado, container, false);
        rvMascotas1 =(RecyclerView) v.findViewById(R.id.rvMascotas1);
        presenter =new ListadoPresenter(this,getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm=new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas1.setLayoutManager(llm);
    }

    @Override
    public MainAdapter crearAdaptador(ArrayList<Mascota> mascotas) {
        MainAdapter adapter = new MainAdapter(mascotas,getActivity());
        return adapter;
    }

    @Override
    public void inicializarAdaptadorListaMascotas(MainAdapter adapter) {
        rvMascotas1.setAdapter(adapter);
    }
}