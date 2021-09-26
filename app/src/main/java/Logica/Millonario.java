package Logica;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Millonario {
    int nivel;
    Cuestionario cuestionario;
    Context context;
    int dinero;
    Pregunta PreguntaActual;
    String preguntaEscojida;
    TextView label_pregunta;
    Button bonton_a;
    Button bonton_b;
    Button bonton_c;
    Button bonton_d;
    String   value_bonton_a;
    String   value_bonton_b;
    String   value_bonton_c;
    String   value_bonton_d;
    String correct_value;
    String Select_value;
    Pregunta[] lista_actual;
    Button reset;
    Button ok;
    TextView level;
    TextView money;


    public  Millonario(Context context,TextView label_pregunta,Button bonton_a,Button bonton_b,Button bonton_c,Button bonton_d,Button reset,Button ok,TextView level, TextView money){
        this.context = context;
        this.cuestionario = new Cuestionario(this.context);
        this.nivel = 1;
        this.dinero = 0;
        this.label_pregunta =  label_pregunta;
        this.bonton_a = bonton_a;
        this.bonton_b = bonton_b;
        this.bonton_c = bonton_c;
        this.bonton_d = bonton_d;
        this.reset = reset;
        this.ok = ok;
        this.level = level;
        this.money = money;
        GenerarNivel();

        bonton_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear_botones();
                bonton_a.setTextColor(Color.parseColor("#240046"));
                Select_value = value_bonton_a;
            }
        });
        bonton_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear_botones();

                bonton_b.setTextColor(Color.parseColor("#240046"));

                Select_value = value_bonton_b;
            }
        });
        bonton_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear_botones();
                bonton_c.setTextColor(Color.parseColor("#240046"));
                Select_value = value_bonton_c;
            }
        });
        bonton_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear_botones();
                bonton_d.setTextColor(Color.parseColor("#240046"));
                Select_value = value_bonton_d;
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jugar();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MakeToast("Reinicio El Juego");
                Reiniciar();
                clear_botones();
                GenerarNivel();
                LeerPuntaje();
            }
        });
    }

    void clear_botones(){

        bonton_a.setTextColor(Color.parseColor("#ff9e00"));

        bonton_b.setTextColor(Color.parseColor("#ff9e00"));

        bonton_c.setTextColor(Color.parseColor("#ff9e00"));

        bonton_d.setTextColor(Color.parseColor("#ff9e00"));

    }

    public void jugar(){
        if(Select_value != null) {
            if (nivel < 5) {
                if (Select_value.equals(correct_value)) {
                    this.nivel++;
                    this.dinero += 100;
                    MakeToast("Acerto");
                } else {
                    MakeToast("Fracaso");
                    Reiniciar();

                }
                Select_value = null;
                correct_value = null;

            } else {
                MakeToast("Gano el Juego");
                Reiniciar();
            }
            clear_botones();
            GenerarNivel();
            LeerPuntaje();
        }
    }

    public void  Reiniciar(){
        this.nivel = 1;
        this.dinero = 0;

    }

    public void LeerPuntaje(){
        this.level.setText(""+this.nivel);
        this.money.setText(""+this.dinero);
    }

    @SuppressLint("SetTextI18n")
    public void  GenerarNivel(){

            lista_actual =  cuestionario.getLista_nivel_1();
            switch (nivel){
                case  1:
                    lista_actual = cuestionario.getLista_nivel_1();
                    break;
                case  2:
                    lista_actual = cuestionario.getLista_nivel_2();
                    break;
                case  3:
                    lista_actual = cuestionario.getLista_nivel_3();
                    break;
                case  4:
                    lista_actual = cuestionario.getLista_nivel_4();
                    break;
                case  5:
                    lista_actual = cuestionario.getLista_nivel_5();
                    break;
            }
            Random r = new Random();

            this.PreguntaActual = lista_actual[r.nextInt(lista_actual.length)];
            System.out.println(PreguntaActual.getPregunta());
            this.label_pregunta.setText(this.PreguntaActual.getPregunta());
            this.correct_value = this.PreguntaActual.getRespuesta();
            String[] values = this.PreguntaActual.getRespuestas_malas();
            List<String> random_values= Arrays.asList(values.clone());
            Collections.shuffle(random_values);


            bonton_a.setText("A. "+random_values.get(0));
             value_bonton_a = random_values.get(0);
            bonton_b.setText("B. "+random_values.get(1));
            value_bonton_b = random_values.get(1);
            bonton_c.setText("C. "+random_values.get(2));
            value_bonton_c = random_values.get(2);
            bonton_d.setText("D. "+random_values.get(3));
            value_bonton_d = random_values.get(3);



    }




    public void MakeToast(String msg) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.show();
    }


}
