package com.example.quienquieresermilllonario;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.InputStream;
import java.util.List;

import Logica.Cuestionario;
import Logica.Millonario;
import Logica.Pregunta;


public class MainActivity extends AppCompatActivity {

    TextView pregunta;
    Button bonton_a;
    Button bonton_b;
    Button bonton_c;
    Button bonton_d;
    Button reset;
    Button ok;
    TextView level;
    TextView money;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reset = (Button) findViewById(R.id.reset);
        ok = (Button) findViewById(R.id.ok);
        level = (TextView) findViewById(R.id.level);
        money = (TextView) findViewById(R.id.money);
        pregunta = (TextView) findViewById(R.id.text_pregunta);
        bonton_a = (Button) findViewById(R.id.pregunta_a);
        bonton_b = (Button) findViewById(R.id.pregunta_b);
        bonton_c = (Button) findViewById(R.id.pregunta_c);
        bonton_d = (Button) findViewById(R.id.pregunta_d);
        Millonario millo = new Millonario(this,pregunta,bonton_a,bonton_b,bonton_c,bonton_d,reset,ok,level,money);
    }
}



