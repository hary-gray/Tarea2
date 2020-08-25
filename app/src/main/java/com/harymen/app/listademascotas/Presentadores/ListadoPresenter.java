package com.harymen.app.listademascotas.Presentadores;

import android.content.Context;

import com.harymen.app.listademascotas.Fragments.IListado;
import com.harymen.app.listademascotas.POJO.Mascota;
import com.harymen.app.listademascotas.db.ConstructoMascotas;

import java.util.ArrayList;

public class ListadoPresenter implements IListadoPresenter {
    private IListado iListado;
    private Context context;
    private ConstructoMascotas constructoMascotas;
    private ArrayList<Mascota> mascotas;
    public ListadoPresenter(IListado iListado, Context context) {
    this.iListado=iListado;
    this.context=context;
    obtenerMascotas();
    }

    @Override
    public void obtenerMascotas() {
    constructoMascotas=new ConstructoMascotas(context);
    mascotas = constructoMascotas.obtenerDatos();
    mostararMascotas();
    }

    @Override
    public void mostararMascotas() {
    iListado.inicializarAdaptadorListaMascotas(iListado.crearAdaptador(mascotas));
    iListado.generarLinearLayoutVertical();
    }
}
