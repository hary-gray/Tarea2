package com.harymen.app.listademascotas.db;

import android.content.ContentValues;
import android.content.Context;

import com.harymen.app.listademascotas.POJO.Mascota;
import com.harymen.app.listademascotas.R;

import java.util.ArrayList;

public class ConstructoMascotas {
    private static final int LIKE = 1;
    private Context context;
    public ConstructoMascotas(Context context) {
        this.context = context;
    }
    public ArrayList<Mascota> obtenerDatos(){
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
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
        mascotas.add(new Mascota("Bolt", R.drawable.boltt, 0)); */
        BaseDatos db = new BaseDatos(context);
        if(db.obtenerTodasLasMascotas().size() < 2){ insertarMascota(db);}
        return db.obtenerTodasLasMascotas();
    }

    public void insertarMascota(BaseDatos db){
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Damita");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.damita);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Pluto");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.plutoo);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Bolt");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.boltt);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Ralph");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ralphh);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Corage");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.coragee);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Vagabundo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.perro);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Bethoven");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.bethovenn);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Rex");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.rexx);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Firulays");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.firulayss);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Ay. de santa");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.ayudante);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Oddie");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.odiee);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"George");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.georgee);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Scoby doo");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.scoobydooo);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Spike");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.spikee);
        db.insertarMascota(contentValues);
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NAME,"Bee");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO, R.drawable.beee);
        db.insertarMascota(contentValues);
    }
    public void darLikeMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues=new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA,mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_LIKES,LIKE);
        db.insertarLikes(contentValues);
    }
    public int obtenerLikesMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikes(mascota);
    }
}
