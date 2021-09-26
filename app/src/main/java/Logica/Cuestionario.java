package Logica;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.InputStream;

public class Cuestionario {
    private Pregunta[] Lista_nivel_1;
    private Pregunta[] Lista_nivel_2;
    private Pregunta[] Lista_nivel_3;
    private Pregunta[] Lista_nivel_4;
    private Pregunta[] Lista_nivel_5;
    Context context;

    public Cuestionario(Context context) {
        this.context = context;
        this.Lista_nivel_1 = LeerLista("preguntas_1.json");
        this.Lista_nivel_2 = LeerLista("preguntas_2.json");
        this.Lista_nivel_3 = LeerLista("preguntas_3.json");
        this.Lista_nivel_4 = LeerLista("preguntas_4.json");
        this.Lista_nivel_5 = LeerLista("preguntas_5.json");
    }

    public Pregunta[] LeerLista(String dir){
        try (InputStream is = this.context.getAssets().open(dir)) {
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            String json = new String(buffer, "UTF-8");
            System.out.println(json);
            Gson gson = new Gson();
            return  gson.fromJson(json,Pregunta[].class);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return  null;
    }

    public Pregunta[] getLista_nivel_1() {
        return Lista_nivel_1;
    }

    public void setLista_nivel_1(Pregunta[] lista_nivel_1) {
        Lista_nivel_1 = lista_nivel_1;
    }

    public Pregunta[] getLista_nivel_2() {
        return Lista_nivel_2;
    }

    public void setLista_nivel_2(Pregunta[] lista_nivel_2) {
        Lista_nivel_2 = lista_nivel_2;
    }

    public Pregunta[] getLista_nivel_3() {
        return Lista_nivel_3;
    }

    public void setLista_nivel_3(Pregunta[] lista_nivel_3) {
        Lista_nivel_3 = lista_nivel_3;
    }

    public Pregunta[] getLista_nivel_4() {
        return Lista_nivel_4;
    }

    public void setLista_nivel_4(Pregunta[] lista_nivel_4) {
        Lista_nivel_4 = lista_nivel_4;
    }

    public Pregunta[] getLista_nivel_5() {
        return Lista_nivel_5;
    }

    public void setLista_nivel_5(Pregunta[] lista_nivel_5) {
        Lista_nivel_5 = lista_nivel_5;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
