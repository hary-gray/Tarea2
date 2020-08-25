package com.harymen.app.listademascotas.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.harymen.app.listademascotas.POJO.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;
    public BaseDatos(@Nullable Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION );
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                    ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                    ConstantesBaseDatos.TABLE_MASCOTAS_NAME + " TEXT, " +
                                    ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                                    ")";
        String queryCrearTablaLikes = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";

    db.execSQL(queryCrearTablaMascota);
    db.execSQL(queryCrearTablaLikes);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db , int oldVersion , int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES);
        onCreate(db);
    }
    public ArrayList<Mascota> obtenerTodasLasMascotas(){
        ArrayList<Mascota> mascotas= new ArrayList<>();
        String query = "SELECT * FROM "+ ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registro = db.rawQuery(query,null);
        while (registro.moveToNext()){
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registro.getInt(0));
            mascotaActual.setNombre(registro.getString(1));
            mascotaActual.setFoto(registro.getInt(2));

            String queryLikes = "SELECT COUNT("+ConstantesBaseDatos.TABLE_LIKES_LIKES +")"+
                            " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                            " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA +"="+mascotaActual.getId();

            Cursor registrosLike = db.rawQuery(queryLikes, null);
            if(registrosLike.moveToNext()){
                mascotaActual.setLikes(registrosLike.getInt(0));
            }else{
                mascotaActual.setLikes(0);
            }

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }
    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS,null,contentValues);
        db.close();
    }
    public void insertarLikes(ContentValues contentValues){
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES,null,contentValues);
        db.close();
    }
    public int obtenerLikes(Mascota mascota){
        int likes = 0;
        String query="SELECT COUNT("+ ConstantesBaseDatos.TABLE_LIKES_LIKES  +")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES +
                 " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" + mascota.getId();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);
        if (registros.moveToNext()){
         likes= registros.getInt(0);
        }
        db.close();
        return likes;
    }
}
