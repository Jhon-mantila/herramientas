package com.example.herramientas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.os.Bundle;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu{

    Fragment[] misFragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_herramientas);

        misFragmentos = new Fragment[3];

        misFragmentos[0] = new Linterna();
        misFragmentos[1] = new Musica();
        misFragmentos[2] = new Nivel();

        Bundle extras = getIntent().getExtras();

        menu(extras.getInt("BOTON_PULSADO"));
    }

    public void menu(int queBoton){

        FragmentManager miManejador = getSupportFragmentManager();

        FragmentTransaction miTransicion = miManejador.beginTransaction();

        miTransicion.replace(R.id.herramientas, misFragmentos[queBoton]);

        miTransicion.commit();

    }
}