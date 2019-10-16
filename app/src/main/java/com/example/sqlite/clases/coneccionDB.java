package com.example.sqlite.clases;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class coneccionDB extends SQLiteOpenHelper{

    public coneccionDB(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase market) {
        market.execSQL("create table users(id integer primary key autoincrement, " +
                "firsname text not null, lastname text not null, email text not null, " +
                "password text not null, password2 text not null)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase market, int i, int i1) {
        market.execSQL("DROP TABLE IF EXISTS users");
        onCreate(market);
    }
}
