package com.example.tarea_1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    Calendar c;
    DatePickerDialog dpd;
    TextView txtDate,txtNombre,txtTelefono;
    RadioButton radMasculino;
    int dia,mes,anio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c= Calendar.getInstance();
        dia=c.get(Calendar.DAY_OF_MONTH);
        mes=c.get(Calendar.MONTH);
        anio=c.get(Calendar.YEAR);
    }
    public void click_Enviar(View view){
        txtNombre=(TextView)findViewById(R.id.txtNombre);
        txtTelefono=(TextView)findViewById(R.id.txtTelefono);
        radMasculino=(RadioButton)findViewById(R.id.rbtMasculino);
        if(txtNombre.getText().length()==0 || txtTelefono.getText().length()==0 || txtDate.getText().length()==0){
            Toast.makeText(this,"Existen campos vacíos",Toast.LENGTH_LONG).show();
        }else{
            Intent intent = new Intent(MainActivity.this, MostrarInfo.class);
            Bundle b = new Bundle();
            b.putString("nombre", txtNombre.getText().toString());
            b.putString("genero",(radMasculino.isChecked())?"Señor":"Señora");
            b.putString("fechaNac",txtDate.getText().toString());
            b.putString("telefono",txtTelefono.getText().toString());
            intent.putExtras(b);
            startActivity(intent);
        }
    }
    public void click_Fecha(View view){
        txtDate=(TextView)findViewById(R.id.txtFechaNace);


        dpd=new DatePickerDialog( MainActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int nanio, int nmes, int ndia) {
                dia=ndia;
                mes=nmes;
                anio=nanio;
                txtDate.setText(dia+"-"+(mes+1)+"-"+anio);
            }
        },dia,mes,anio);
        dpd.updateDate(anio,mes,dia);
        dpd.getDatePicker().setMaxDate(c.getTimeInMillis());
        dpd.show();
    }
}