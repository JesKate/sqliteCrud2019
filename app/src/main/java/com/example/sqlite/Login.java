package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.clases.coneccionDB;

public class Login extends AppCompatActivity {
    coneccionDB conn;
    EditText idemail, contrasena;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        idemail=findViewById(R.id.idcorreo);
        contrasena=findViewById(R.id.Password);
    }

    public void registro(View view){
        startActivity(new Intent(Login.this,Singup.class));
    }

    public void LogInS (View view){
        conn = new coneccionDB(this,"users",null,1);
        SQLiteDatabase market=conn.getReadableDatabase();
        String[] parametros = {idemail.getText().toString()};

        String email = idemail.getText().toString();
        String password = contrasena.getText().toString();

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Debe llenar los campos", Toast.LENGTH_SHORT).show();
        } else if (!email.isEmpty() && !password.isEmpty()){
            try {
                Cursor cursor=market.rawQuery("SELECT "+"email"+
                        " FROM "+"users"+" WHERE "+"email"+"=? ",parametros);
                if (cursor.moveToFirst()){
                    String[] parametros2 = {contrasena.getText().toString()};

                    try {
                        Cursor cursor2=market.rawQuery("SELECT "+"password"+
                                " FROM "+"users"+" WHERE "+"password"+"=? ",parametros2);
                        if (cursor2.getCount()>0){

                            iniciar();
                        } else {
                            Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e){

                    }
                } else {
                    Toast.makeText(this, "Usuario incorrecto", Toast.LENGTH_SHORT).show();
                }

            } catch (Exception e){

            }
        }
    }
    private void iniciar() {
        startActivity(new Intent(Login.this, MainActivity.class));
    }
}
