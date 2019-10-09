package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.clases.coneccionDB;

public class Singup extends AppCompatActivity {

    private EditText fname, lapellido, ecorreo, pcontraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singup);

        //obtener id's
        fname=findViewById(R.id.idfname);
        lapellido=findViewById(R.id.apellido);
        ecorreo=findViewById(R.id.correo);
        pcontraseña=findViewById(R.id.contrasena);

    }
    public void Singup(View view){
        //coneccion db
        coneccionDB connection= new coneccionDB(this, "connection", null, 1);
        //let Db Read-write
        SQLiteDatabase market = connection.getWritableDatabase();
        //get data
        String Fname= fname.getText().toString();
        String Lapellido= lapellido.getText().toString();
        String Ecorreo= ecorreo.getText().toString();
        String Pcontraseña= pcontraseña.getText().toString();

        if(!Fname.isEmpty() && !Lapellido.isEmpty() && !Ecorreo.isEmpty() && !Pcontraseña.isEmpty()){
            //validacion email no repetido
            Cursor row=market.rawQuery(
                    "SELECT *FROM users WHERE email = '"+ Ecorreo + "'LIMIT 1", null
            );

            if(row.moveToFirst()){
                Toast.makeText(this, "Email already exist", Toast.LENGTH_SHORT).show();
                market.close();
            }else{
            //save data-- guardar los datos
            ContentValues pack= new ContentValues();
            pack.put("firsname",Fname);
            pack.put("lastname",Lapellido);
            pack.put("email",Ecorreo);
            pack.put("password",Pcontraseña);
            market.insert("users", null, pack);
            Toast.makeText(this, "The user has registered", Toast.LENGTH_SHORT).show();

            //cerrar base de datos
            market.close();
            }
        }else{
            fname.setText("Field can't be empty");
            lapellido.setText("Field can't be empty");
            ecorreo.setText("Field can't be empty");
            pcontraseña.setText("Field can't be empty");
            Toast.makeText(this, "There are empty field", Toast.LENGTH_SHORT).show();
        }


    }
}
