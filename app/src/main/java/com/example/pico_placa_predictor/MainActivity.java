package com.example.pico_placa_predictor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;

import java.sql.Time;
import java.text.ParseException;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private Button btnPredecir;
    private EditText txtHora;
    private EditText txtMin;
    private CalendarView Calendario;
    private EditText txtPlaca;
    private EditText TxtColor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final int[] dia = new int[1];
        final int[] mes = new int[1];
        final int[] year = new int[1];
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPredecir = findViewById(R.id.btnPredecir);
        txtPlaca = findViewById(R.id.txtPlaca);
        txtHora = findViewById(R.id.txtHora);
        TxtColor= findViewById(R.id.TxtColor);
        Calendario = (CalendarView) findViewById(R.id.Calendario);
        final Validacion valido = new Validacion();
        Calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                valido.setFecha(i2,i1,i);
            }
        });
        btnPredecir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean t=true;
                String hora=txtHora.getText().toString();
                String color=TxtColor.getText().toString();
                String placa= txtPlaca.getText().toString();
                t= valido.PlacaCorrecta(placa);
                if(t){
                    try {
                        boolean PuedeSiNo = valido.CirculaoNo(Integer.parseInt(placa.substring(6)),Integer.parseInt(hora),color);
                        if(PuedeSiNo){
                            startActivity(new Intent(MainActivity.this,CirculaOSi.class));
                        }else{
                            startActivity(new Intent(MainActivity.this,CirculaONo.class));
                        }
                    } catch (ParseException e) {

                        e.printStackTrace();
                    }

                }
            }
        } );

    }

}