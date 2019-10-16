package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.clases.coneccionDB;

public class Singup extends AppCompatActivity {

    coneccionDB conn;
    private EditText fname, lapellido, ecorreo, pcontrasena, pcontrasena2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //obtener id's
        fname = findViewById(R.id.idfname);
        lapellido = findViewById(R.id.apellido);
        ecorreo = findViewById(R.id.correo);
        pcontrasena = findViewById(R.id.contrasena);
        pcontrasena2 = findViewById(R.id.contrasena2);
    }

    public void Signup(View view) {
        //coneccion db
        conn = new coneccionDB(this, "market", null, 1);
        //let Db Read-write
        SQLiteDatabase market = conn.getReadableDatabase();
        //get data

        String[] parametros={ecorreo.getText().toString()};

        String name = fname.getText().toString();
        String apellido = lapellido.getText().toString();
        String correo = ecorreo.getText().toString();
        String contrasena = pcontrasena.getText().toString();
        String contrasena2 = pcontrasena2.getText().toString();

        if (name.length()==0) {
            Toast.makeText(this, "fill in the name field", Toast.LENGTH_SHORT).show();
        } else if (apellido.length()==0) {
            Toast.makeText(this, "fill in the Last name field", Toast.LENGTH_SHORT).show();
        } else if (correo.length()==0) {
            Toast.makeText(this, "fill in the Email field", Toast.LENGTH_SHORT).show();
        } else if (contrasena.length()==0) {
            Toast.makeText(this, "fill in the Password field", Toast.LENGTH_SHORT).show();
        } else if (contrasena.length() < 8) {
            Toast.makeText(this, "The password must be 8 characters", Toast.LENGTH_SHORT).show();
        } else if (contrasena.length()==0) {
            Toast.makeText(this, "fill in the Confirmation Password field", Toast.LENGTH_SHORT).show();
        } else if (!name.isEmpty() && !apellido.isEmpty() && !correo.isEmpty() && !contrasena.isEmpty() &&
                !contrasena2.isEmpty() && contrasena2.equals(contrasena)) {
            //validacion email no repetido
            try{
                Cursor row = market.rawQuery(
                        "SELECT "+"email"+
                                " FROM "+"users"+" WHERE "+"email"+"=? ",parametros
                );
                row.moveToFirst();
                Toast.makeText(this, "El correo "+row.getString(0)+" ya existe", Toast.LENGTH_SHORT).show();
                row.close();

            }catch (Exception e) {
                register();
            }
            //Toast.makeText(this, "Hola mundo", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Las contraseñas deben ser iguales", Toast.LENGTH_SHORT).show();
        }
    }
        public void register(){
            conn=new coneccionDB(this,"market",null,1);

            SQLiteDatabase market=conn.getWritableDatabase();

            String Fname = fname.getText().toString();
            String Lapellido = lapellido.getText().toString();
            String Ecorreo = ecorreo.getText().toString();
            String Pcontrasena = pcontrasena.getText().toString();
            String Pcontrasena2 = pcontrasena2.getText().toString();
            //save data-- guardar los datos
            ContentValues pack = new ContentValues();
            pack.put("firsname", Fname);
            pack.put("lastname", Lapellido);
            pack.put("email", Ecorreo);
            pack.put("password", Pcontrasena);
            pack.put("password2", Pcontrasena2);

            Long insert=market.insert("users", null, pack);
            Toast.makeText(this, "The user has been registered", Toast.LENGTH_SHORT).show();

            //cerrar base de datos
            market.close();
        }

}
