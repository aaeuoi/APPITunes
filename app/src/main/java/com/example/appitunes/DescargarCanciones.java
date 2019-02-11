package com.example.appitunes;

import android.os.AsyncTask;
import android.util.Log;

import com.example.appitunes.ResultadoCanciones;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class DescargarCanciones extends AsyncTask<String, Void, ResultadoCanciones> {

    private static String URI_ITUNES = "https://itunes.apple.com/search/?media=music&term=";
    //https://itunes.apple.com/search/?media=music&term=chiquetet

    private MainActivity ma;

    // constructor para la otra pantalla (que te ha llamado) que tengo que volver
    public DescargarCanciones (MainActivity ma)
    {
        //almacena en ma una referencia a la pantalla para poder volver a ella
        this.ma = ma;
    }
    //metodo donde hacmos la conexion y recuperamos los datos
    @Override
    protected ResultadoCanciones doInBackground(String... canciones) { // Var args

        HttpURLConnection httpURLConnection = null;
        ResultadoCanciones resultadoCanciones = null;
        URL url = null;
        Gson gson = null;
        InputStreamReader is = null;

        try {
            url = new URL (URI_ITUNES+canciones[0]);
            //  httpURLConnection = (HttpURLConnection) url.openConnection(POST);
            httpURLConnection = (HttpURLConnection)url.openConnection(); // get por defecto
            if (httpURLConnection.getResponseCode()== HttpURLConnection.HTTP_OK)
            {
                //la respuesta fue buena
                String ct = httpURLConnection.getContentType();
                Log.d("MIAPP", "Etiooi mime " + ct); // tipo Json
                is = new InputStreamReader(httpURLConnection.getInputStream()); // accedo al cuerpo del mensaje en Json
                gson = new Gson();
                resultadoCanciones = gson.fromJson(is,ResultadoCanciones.class);  // conversion desde una clase

            }

        } catch (Exception e ) //si falla
        {
            Log.e("MIAPP", "Error al comunicar cin iTunes " + e);

        } finally // falle o no liberar recursos
        {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }

        return resultadoCanciones;
    }
    // metodo cuando acabe doInBackground
    @Override
    protected void onPostExecute(ResultadoCanciones resultadoCanciones) {
        super.onPostExecute(resultadoCanciones);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String stringCanciones= gson.toJson(resultadoCanciones);
        Log.d("MIAPP", "Canciones = "+stringCanciones);
        this.ma.mostrarResultados(resultadoCanciones); //mostrar reultados

    }

}





