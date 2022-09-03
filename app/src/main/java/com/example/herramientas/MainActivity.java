package com.example.herramientas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ComunicaMenu{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void menu(int queBoton) {

        Intent in = new Intent(this, ActividadHerramientas.class);

        in.putExtra("BOTON_PULSADO", queBoton);

        startActivity(in);
    }
}