package com.example.dm2.fragments;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements FragmentListado.JuegosListener {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log.i("AAA", "aaaa");

        FragmentListado frgListado = (FragmentListado)getSupportFragmentManager().findFragmentById(R.id.FrgListado);
        frgListado.setJuegosListener(this);

    }
    public void onJuegoSeleccionado(Juego juego) {
        boolean haydetalle = (getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)!=null);
        if(haydetalle){
            ((FragmentDetalle) getSupportFragmentManager().findFragmentById(R.id.FrgDetalle)).mostrarDetalle(juego.getPrecio());

        }
        else{
            Intent i = new Intent(this, Detalle_Activity.class);
            i.putExtra(Detalle_Activity.EXTRA_TEXTO, juego.getPrecio());
            startActivity(i);
        }
    }
}
