package com.harymen.app.listademascotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

public class DetalleProgrammer extends AppCompatActivity {
    Toolbar toolbarDetalle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_programmer);
        toolbarDetalle =(Toolbar) findViewById(R.id.toolbarDetalle);
        setSupportActionBar(toolbarDetalle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}