package com.example.novorevendas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    private static final String name = "banco.produtos";
    private static final int version = 1;


    public Conexao(Context context) {
        super(context, name, null , version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table produto(id integer primary key autoincrement," + " nome varchar (50), valor vaarchar (10), descricao varchar (150), tipo varchar (15))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {

    }
}
