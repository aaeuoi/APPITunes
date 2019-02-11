package com.example.appitunes;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.appitunes.ResultadoCanciones;
import com.example.appitunes.Cancion;

public class CancionesHolder extends RecyclerView.ViewHolder {

    private TextView caja_id;
    private TextView caja_artista;
    private TextView caja_cancion;
/*
    public CancionesHolder(View itemView) {

        super(itemView);
        caja_id = (TextView) itemView.findViewById(R.layout.fila_record.id );
        caja_artista = (TextView) itemView.findViewById(R.layout.fila_record.artista);
        caja_cancion = (TextView) itemView.findViewById(R.layout.fila_record.cancion);
    }
*/
    public CancionesHolder(@NonNull View itemView) {
        super(itemView);

        caja_id = (TextView) itemView.findViewById(R.id.id);
        caja_artista = (TextView) itemView.findViewById(R.id.artista);
        caja_cancion = (TextView) itemView.findViewById(R.id.cancion);
    }


    public void cargarDatos(Cancion c) {
        caja_id.setText(c.getArtistId() + " ");
        caja_artista.setText(c.getArtistName() + " ");
        caja_cancion.setText(c.getTrackName());
    }
    public CancionesHolder onCreateViewHholder (View v) {
        return this;
    }


    public void onClick (View view) {
        Log.d("MIAPP",  "han tocado una fila");
    }

}
