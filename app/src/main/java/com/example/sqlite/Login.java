package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.sqlite.clases.coneccionDB;

public class Login extends AppCompatActivity {
    coneccionDB conection;
    EditText email,contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email=findViewById(R.id.Email);
        contrasena=findViewById(R.id.Password);
    }
    public void registro(View view){
        startActivity(new Intent(Login.this,Singup.class));
    }
    public void LogInS (View view){
        conection=new coneccionDB(this,"users",null,1);
        SQLiteDatabase market=conection.getReadableDatabase();
        String[] parametros = {email.getText().toString()};
    }
}
