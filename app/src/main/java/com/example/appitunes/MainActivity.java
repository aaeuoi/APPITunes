package com.example.appitunes;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.appitunes.R;
import com.example.appitunes.ResultadoCanciones;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter rwAdapter;
    private ResultadoCanciones cancionesResults;
    private List<Cancion> cancionesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String artista = "JULIO";
        new DescargarCanciones(this).execute(artista);


    }

    // para recibir los resultados esde el thread DescargarCanciones
    public void mostrarResultados(ResultadoCanciones resultadoCanciones)
    {
        findViewById(R.id.progressBar).setVisibility(View.INVISIBLE);

        Toast.makeText(this, "Fin desacarga", Toast.LENGTH_LONG).show();
        //  con lops datos obtenidos que muestre idartista, nombre, nombre canción
        /*
        <RecyclerView>
            layaut usa Adapter, infla los Holder
            con tres atributos: id, nombre cancion (¿foto?)
        */
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        rwAdapter = new RecyclerView.Adapter() {
            @NonNull
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                return null;
            }

            @Override
            public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

            }


            @Override
            public int getItemCount() {
                return 0;
            }
        }
        setContentView(R.layout.activity_main);

        viewManager = LinearLayoutManager(this);
        viewAdapter = MyAdapter(myDataset);
        recyclerView = this.findViewById<RecyclerView>;

    }

    public List<Cancion> getCancionesList() {
        return cancionesList;
    }
}
