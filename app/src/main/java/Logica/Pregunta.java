package Logica;

import java.util.Arrays;

public class Pregunta  {
    private  String pregunta;
    private String[] respuestas_malas;
    private  String respuesta;

    public Pregunta(String pregunta, String[] respuestas_malas, String respuesta) {
        this.pregunta = pregunta;
        this.respuestas_malas = respuestas_malas;
        this.respuesta = respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String[] getRespuestas_malas() {
        return respuestas_malas;
    }

    public void setRespuestas_malas(String[] respuestas_malas) {
        this.respuestas_malas = respuestas_malas;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "pregunta='" + pregunta + '\'' +
                ", respuestas_malas=" + Arrays.toString(respuestas_malas) +
                ", respuesta='" + respuesta + '\'' +
                '}';
    }
}
