package com.example.dm2.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class FragmentListado extends Fragment {

    private Juego juegos[] = new Juego[]{new Juego("Overwatch","FPS","20€"),
                                            new Juego("League","MOBA","F2P"),
                                            new Juego("PUBG","BattleRoyale","30€")};

    JuegosListener listener;
    ListView lstListado;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstances) {

        return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);
        lstListado = (ListView) getView().findViewById(R.id.lstJuegos);
        lstListado.setAdapter(new AdaptadorJuegos(this));
        lstListado.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (listener != null) {
                    listener.onJuegoSeleccionado((Juego)lstListado.getAdapter().getItem(position));
                }
            }
        });
    }

    class AdaptadorJuegos extends ArrayAdapter<Juego> {
        Activity context;


        AdaptadorJuegos(Fragment context) {
            super(context.getActivity(), R.layout.listitem_juegos, juegos);
            this.context = context.getActivity();
        }

        public View getView(int pos, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_juegos, null);

            TextView lblNombre = (TextView) item.findViewById(R.id.lblNombre);
            lblNombre.setText(juegos[pos].getNombre());

            TextView lblNombreReal = (TextView) item.findViewById(R.id.lblTipo);
            lblNombreReal.setText(juegos[pos].getTipo());

            return (item);
        }


    }

    public interface JuegosListener{
        void onJuegoSeleccionado(Juego sh);
    }

    public void setJuegosListener (JuegosListener listener){
        this.listener=listener;
    }
}
