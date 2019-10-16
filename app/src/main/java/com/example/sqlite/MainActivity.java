package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.example.sqlite.clases.coneccionDB;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView list;
    List<String> item = null;
    coneccionDB con;
    private EditText ecorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list=findViewById(R.id.list);
        ecorreo=findViewById(R.id.correo);
    }

    private void listarUsuarios(){
        con=new coneccionDB(this,"market",null,1);
        SQLiteDatabase market=con.getReadableDatabase();

        Cursor cur = getUsers();
        item = new ArrayList<String>();
        String user = "";

        if (cur.moveToFirst()){
            do{
                user = cur.getString(0);
                item.add(user);
            }while(cur.moveToNext());
        }

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, item);
        list.setAdapter(adaptador);
    }
    public Cursor getUsers(){
        String Ecorreo= ecorreo.getText().toString();
        con=new coneccionDB(this,"market",null,1);
        SQLiteDatabase market=con.getReadableDatabase();
        String[] row= {};

        Cursor curs=market.rawQuery(
                "SELECT *FROM users WHERE email = '"+ Ecorreo + "'LIMIT 1", null
        );
        return curs;
    }


}
