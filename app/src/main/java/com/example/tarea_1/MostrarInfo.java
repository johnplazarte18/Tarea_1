package com.example.tarea_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MostrarInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_info);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView txtInfo = (TextView)findViewById(R.id.txtInfo);

        Bundle bundle = this.getIntent().getExtras();
        txtInfo.setText("Hola!, Bienvenido " +bundle.getString("genero")+" "+
                bundle.getString("nombre")+" gracias por registrar con fecha de nacimiento: "+
                bundle.getString("fechaNac")+" , nos estaremos comunicando con usted al número: "+
                bundle.getString("telefono"));

    }
}