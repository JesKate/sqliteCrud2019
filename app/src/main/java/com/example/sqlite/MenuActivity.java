package com.example.sqlite;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.sqlite.clases.coneccionDB;

import java.util.List;

public class MenuActivity extends AppCompatActivity {
    List<UsuarioList> listaU;

    private RecyclerView listR1;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listR1.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        listR1.setLayoutManager(lManager);

        adapter = new AdaptadorU(listaU);
        listR1.setAdapter(adapter);
    }
}
