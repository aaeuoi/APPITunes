package com.example.appitunes;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class AdapterCanciones extends RecyclerView.Adapter<CancionesHolder> implements View.OnClickListener {
    private List<ResultadoCanciones> datos;


    /**
     * ESTE MÉTODO CREA LAS CAJAS / ITEMS QUE ALBERGARÁ LA INFORMACIÓN
     * DE CADA REGISTRO / ELEMENTO. CREAMOS LA VISTA (LA CAJA)
     *
     * @param parent la propia lista, el RecyclerView
     * @param viewType
     * @return
     */
    @Override
    public CancionesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CancionesHolder cancionHolder = null;

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.fila_record, parent, false);
        itemView.setOnClickListener(this);//asociaría el listener
        cancionHolder = new CancionesHolder(itemView);

        return cancionHolder;
    }

    //Al holder, le meto la info de item que toca
    @Override
    public void onBindViewHolder(CancionesHolder holder, int position) {

        Cancion cancion = datos.get(position);
        holder.cargarDatos(cancion);

    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public AdapterCanciones (List<Cancion> lista_canciones)
    {
        this.datos = lista_canciones;
    }



    @Override
    public void onClick(View view) {
        Log.d("MIAPP", "Han tocado una fila");
        TextView caja_id = view.findViewById(R.layout.fila_record.id.id);
        TextView caja_artista = view.findViewById(R.layout.fila_record.id.artista);
        TextView caja_cancion = view.findViewById(R.layout.fila_record.id.cancion);

        String str_id = caja_id.getText().toString();
        String artista = caja_artista.getText().toString();
        String cancion = caja_cancion.getText().toString();
        int id = Integer.parseInt(str_id);//casting de String a long


        Cancion c = new Cancion(id, artista, cancion);

        //Puntacion p = new Puntacion(nombre, tiempo);
        Intent i_detalle = new Intent(view.getContext(), MostrarRecords.class);
        //i_detalle.putExtra("cancion", c);
        i_detalle.putExtra("cancion", c);
        view.getContext().startActivity(i_detalle);

    }
}
