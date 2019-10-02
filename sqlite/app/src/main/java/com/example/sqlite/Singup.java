package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.clases.coneccionDB;

public class Singup extends AppCompatActivity {

    private EditText fname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        fname=findViewById(R.id.idfname);
    }
    public void Singup(View view){
        //coneccion db
        coneccionDB connection= new coneccionDB(this, "admin", null, 1);
        //let Db Read-write
        SQLiteDatabase market = connection.getWritableDatabase();
        //get data
        String Fname= fname.getText().toString();
        //save data-- guardar los datos
        ContentValues pack= new ContentValues();
        pack.put("firsname",Fname);
        pack.put("lastname","");
        pack.put("email","");
        pack.put("password","");
        market.insert("users", null, pack);
        Toast.makeText(this, "The user has registered", Toast.LENGTH_SHORT).show();

        //cerrar base de datos
        market.close();


    }
}
