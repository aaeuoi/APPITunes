package com.example.appitunes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import android.widget.EditText;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.example.appitunes.DescargarCanciones;
import com.example.appitunes.R;
import com.example.appitunes.Cancion;
import com.example.appitunes.CancionesHolder;
import com.example.appitunes.AdapterCanciones;

public class MostrarRecords extends AppCompatActivity {

    private boolean volver;

    private RecyclerView recView;

    private List<Cancion> datos;

    private AdapterCanciones adaptador;

    private void mostrarFlechaMenuNav ()
    {
        //así dibujo la flecha de navegación estandar atrás
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_records);

            datos = CancionesHolder.cargarDatos(this);

                // if datos.size() == 0 { visualiza sin records } else { como está }
                adaptador = new AdapterCanciones(datos);
                recView = (RecyclerView) findViewById(R.id.my_recycler_view);
                //recView.setHasFixedSize(true);//opcional, si sé que el tamaño no va a cambiar



                recView.setAdapter(adaptador);//mostrando la lista



                Collections.sort(datos);
                adaptador = new AdapterCanciones(datos);
                recView = (RecyclerView) findViewById(R.id.my_recycler_view);
                recView.setHasFixedSize(true);//opcional, si sé que el tamaño no va a cambiar
                recView.setAdapter(adaptador);//mostrando la lista
                recView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                recView.addItemDecoration(
                        new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            }
            //mostrarFlechaMenuNav();


        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            switch (item.getItemId())
            {
                case android.R.id.home:
                    Log.d("MIAPP", "Tocó ir hacia atrás");
                    super.onBackPressed();
                    break;
            }

            return super.onOptionsItemSelected(item);
        }
/*
        public void ordenarPorNombreYTiempo (View v)
        {
            Collections.sort(datos, new ComparadorPuntuaciones());
            adaptador = new AdapterPuntuaciones(datos);
            recView.setAdapter(adaptador);
        }
        */
    }
