package com.example.herramientas;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Linterna#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Linterna extends Fragment {

    private ImageView botonCamara;
    //inicializarlo
    private Boolean encendida = false;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Linterna() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Linterna.
     */
    // TODO: Rename and change types and number of parameters
    public static Linterna newInstance(String param1, String param2) {
        Linterna fragment = new Linterna();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmento =  inflater.inflate(R.layout.fragment_linterna, container, false);

        botonCamara = (ImageView) fragmento.findViewById(R.id.linterna);

        botonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(encendida){
                    botonApagaFlash();
                    //Simulando un boton on/off
                    encendida = false;
                }else{
                    botonEnciendeFlash();
                    //Simulando un boton on/off
                   encendida = true;
                }

            }
        });

        return fragmento;
    }

    public void botonEnciendeFlash(){
        botonCamara.setImageResource(R.drawable.linterna2);
        //Polimorfismo
        Activity esteFragmento = getActivity();
        //interfaz para la lineterna para pasar el parametro
        ((ManejaFlashCamara)esteFragmento).enciedeApaga(encendida);

    }
    public void botonApagaFlash(){
        botonCamara.setImageResource(R.drawable.linterna);
        //Polimorfismo
        Activity esteFragmento = getActivity();
        //interfaz para la lineterna para pasar el parametro
        ((ManejaFlashCamara)esteFragmento).enciedeApaga(encendida);
    }
}