package com.omar_hidrogo_local.registrodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetalleDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;
    private TextView tvfecha;
    private Button editar;

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;
    private String dia,mes,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_datos);

        //Recibir los datos
        Bundle parametros = getIntent().getExtras();

        nombre = parametros.getString("nombre");
        telefono = parametros.getString("telefono");
        email = parametros.getString("email");
        descripcion = parametros.getString("descripcion");
        dia = parametros.getString("dia");
        mes = parametros.getString("mes");
        year = parametros.getString("year");


        //Es necesario sincronizar los textviews
        tvNombre = (TextView) findViewById(R.id.tvnombre);
        tvTelefono = (TextView) findViewById(R.id.tvtelefono);
        tvEmail = (TextView) findViewById(R.id.tvemail);
        tvDescripcion = (TextView) findViewById(R.id.tvdescripcion);
        tvfecha = (TextView) findViewById(R.id.tvfecha);
        editar = (Button) findViewById(R.id.btEditar);




        //asignar el valor de la variable  al android:text
        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);
        tvfecha.setText(dia+"/"+mes+"/"+year);
        int imes = Integer.parseInt(mes);
        int tm = imes-1;
        final String smes =String.valueOf(tm);

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editar(v, nombre, telefono, email, descripcion, dia, smes, year );
            }
        });
    }

    public void editar(View v, String nombre, String telefono, String email, String descripcion, String dia, String mes, String year){
        Intent i = new Intent(DetalleDatos.this, MainActivity.class);
        i.putExtra("nombre", nombre);
        i.putExtra("telefono", telefono);
        i.putExtra("email", email);
        i.putExtra("descripcion", descripcion);
        i.putExtra("dia", dia);
        i.putExtra("mes", mes);
        i.putExtra("year", year);
        startActivity(i);
        finish();
    }
}
