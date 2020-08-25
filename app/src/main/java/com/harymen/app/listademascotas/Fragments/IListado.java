package com.harymen.app.listademascotas.Fragments;

import com.harymen.app.listademascotas.Adapatadores.MainAdapter;
import com.harymen.app.listademascotas.POJO.Mascota;

import java.util.ArrayList;

public interface IListado {
    public void generarLinearLayoutVertical();

    public MainAdapter crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorListaMascotas(MainAdapter adapter);
}
