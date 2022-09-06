package com.example.herramientas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.widget.Toast;

public class ActividadHerramientas extends AppCompatActivity implements ComunicaMenu, ManejaFlashCamara{

    private Fragment[] misFragmentos;
    private CameraManager miCamara;

    private String[] idCamara;

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

        //crear frament de forma programatica

            Fragment menu_iluminado = new Menu();

            Bundle datos = new Bundle();

            datos.putInt("BOTONPULSADO", queBoton);

            menu_iluminado.setArguments(datos);

            miTransicion.replace(R.id.menu, menu_iluminado);

        miTransicion.replace(R.id.herramientas, misFragmentos[queBoton]);

        miTransicion.commit();

    }

    @Override
    public void enciedeApaga(boolean estadoFlash) {
        if (estadoFlash){
            Toast.makeText(this, "Flash Apagado", Toast.LENGTH_SHORT).show();

            miCamara = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

            try {
                idCamara = miCamara.getCameraIdList();
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }

        }else{
            Toast.makeText(this, "Flash Encendio", Toast.LENGTH_SHORT).show();
        }
    }
}