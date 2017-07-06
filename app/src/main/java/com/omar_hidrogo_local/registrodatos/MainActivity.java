package com.omar_hidrogo_local.registrodatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    private EditText etnombre;
    private EditText ettelefono;
    private EditText etemail;
    private EditText etdescripcion;
    private DatePicker dpfecha;
    private Button siguiente;

    private String nombre;
    private String telefono;
    private String email;
    private String descripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recibir los datos
        Bundle parametros = getIntent().getExtras();

        if( getIntent().getExtras() != null)
        {
            //Variables
            String dia,mes,year;

            //Recibo los datos y los paso a su variable
            nombre = parametros.getString("nombre");
            telefono = parametros.getString("telefono");
            email = parametros.getString("email");
            descripcion = parametros.getString("descripcion");
            dia = parametros.getString("dia");
            mes = parametros.getString("mes");
            year = parametros.getString("year");

            //convierto de String a int
            int idia = Integer.parseInt(dia);
            int imes = Integer.parseInt(mes);
            int iyear = Integer.parseInt(year);

            //Es necesario sincronizar los views
            etnombre = (EditText) findViewById(R.id.etNombre);
            ettelefono = (EditText) findViewById(R.id.etTelefono);
            etemail = (EditText) findViewById(R.id.etEmail);
            etdescripcion = (EditText) findViewById(R.id.etDescCont);
            dpfecha = (DatePicker) findViewById(R.id.datePicker1);

            //Se establece el valor a los views
            etnombre.setText(nombre);
            ettelefono.setText(telefono);
            etemail.setText(email);
            etdescripcion.setText(descripcion);
            dpfecha.updateDate(iyear,imes,idia);

            siguiente = (Button) findViewById(R.id.btSiguiente);

            siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int d,m,y;
                    d=dpfecha.getDayOfMonth();
                    m=dpfecha.getMonth()+1;
                    y=dpfecha.getYear();

                    final String sd =String.valueOf(d);
                    final String sm =String.valueOf(m);
                    final String sy =String.valueOf(y);

                   irActivity2(v, etnombre.getText().toString(), ettelefono.getText().toString(), etemail.getText().toString(),
                            etdescripcion.getText().toString(), sd, sm, sy );
                }
            });
        }
        else{

            etnombre = (EditText) findViewById(R.id.etNombre);
            ettelefono = (EditText) findViewById(R.id.etTelefono);
            etemail = (EditText) findViewById(R.id.etEmail);
            etdescripcion = (EditText) findViewById(R.id.etDescCont);
            siguiente = (Button) findViewById(R.id.btSiguiente);
            dpfecha = (DatePicker) findViewById(R.id.datePicker1);

            siguiente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int dia,mes,year;
                    dia=dpfecha.getDayOfMonth();
                    mes=dpfecha.getMonth()+1;
                    year=dpfecha.getYear();

                    final String sdia =String.valueOf(dia);
                    final String smes =String.valueOf(mes);
                    final String syear =String.valueOf(year);
                    irActivity2(v, etnombre.getText().toString(), ettelefono.getText().toString(), etemail.getText().toString(),
                            etdescripcion.getText().toString(), sdia, smes, syear);
                }
            });
        }
    }

    public void irActivity2(View v, String nombre, String telefono, String email, String descripcion, String dia, String mes, String year){
        Intent i = new Intent(MainActivity.this, DetalleDatos.class);
        i.putExtra("nombre", nombre);
        i.putExtra("telefono", telefono);
        i.putExtra("email", email);
        i.putExtra("descripcion", descripcion);
        i.putExtra("dia",dia);
        i.putExtra("mes",mes);
        i.putExtra("year",year);
        startActivity(i);
        finish();
    }
}
