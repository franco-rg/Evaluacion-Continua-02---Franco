package com.example.viajaperu.net;
import android.content.res.Resources;
import android.net.Uri; /* gestion de url's */
import android.util.Log;

import com.example.viajaperu.R;
import com.google.gson.Gson; /* lectura de archivos Gson */
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class AgencyEntry {

    /* obtener los nombre de las clases */
    private static final String TAG = AgencyEntry.class.getSimpleName(); /* etiquetar nombre de la clase (data) */
    public final String name_agency;
    public final Uri urlDynamic;
    public final String url;
    public final String description;

    public AgencyEntry(String name_agency, String urlDynamic, String url, String description) {
        this.name_agency = name_agency;
        this.urlDynamic = Uri.parse(urlDynamic);
        this.url = url;
        this.description = description;
    }

    /* method init json */
    public static List<AgencyEntry> agencyDataList(Resources resources){ /* data json (file) de la app como parametro */
        InputStream inputStream = resources.openRawResource(R.raw.agency_data); /* abrimos file json */
        /* buffer --> cargar data para posteriormente convertirla a formato */
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];

        /* lectura de file json */
        try{
            Reader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); /* formato de archivo de lectura */
            int pointer;
            /* mientras ya no haya data que recorrer o leer en el archivo... */
            while ((pointer = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, pointer);
            }
        } catch (IOException e){
            Log.e(TAG,"Error reading json", e);
        } finally {
            try{
                inputStream.close();
            } catch (IOException e){
                Log.e(TAG,"Error to close conexion json file", e);
            }
        }
        String jsonAgencyString = writer.toString();
        Gson gson = new Gson();
        Type type = new TypeToken< ArrayList<AgencyEntry> >(){}.getType();
        return gson.fromJson(jsonAgencyString, type);
    }
}