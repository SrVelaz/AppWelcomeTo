package com.example.srvelaz.appwelcometo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
public class EncuestaActivity1 extends Activity {


    Spinner lista;
    String [] datosList = {"Seleccionar", "Hombre" , "Mujer"};
    int edad = 1;
    String genero = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta_layout_1);

        Button botonFecha = (Button) findViewById(R.id.botonSeleccionarEdadID);


        lista = (Spinner) findViewById(R.id.spinnerEncuesta1);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, datosList);
        lista.setAdapter(adaptador);
        lista.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                switch (position) {
                    case 1:
                        //Length_long significa la duración del Toast.
                        genero = datosList[position];
                        String stringToastHombre = "Usted es: " + datosList[position];
                        Toast toastSpinnerHombre = Toast.makeText(getApplicationContext(),
                                stringToastHombre, Toast.LENGTH_SHORT);
                        toastSpinnerHombre.show();
                        break;
                    case 2:
                        genero = datosList[position];
                        String stringToastMujer = "Usted es: " + datosList[position];
                        Toast toastSpinnerMujer = Toast.makeText(getApplicationContext(),
                                stringToastMujer, Toast.LENGTH_SHORT);
                        toastSpinnerMujer.show();
                        break;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void pulsarBotonSeleccionarEdad(View view) {

        // TODO Auto-generated method stub
        new DatePickerDialog(EncuestaActivity1.this, fecha, miCalendario
                .get(Calendar.YEAR), miCalendario.get(Calendar.MONTH),
                miCalendario.get(Calendar.DAY_OF_MONTH)).show();
    };

    Calendar miCalendario = Calendar.getInstance();

    DatePickerDialog.OnDateSetListener fecha = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {

            miCalendario.set(Calendar.YEAR, year);
            miCalendario.set(Calendar.MONTH, monthOfYear);
            miCalendario.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            actualizarLabel();
        }

    };

    private void actualizarLabel () {

        String miFormato = "dd/MM/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(miFormato, Locale.ENGLISH);
        TextView fechaTextView = (TextView) findViewById(R.id.edadTextViewID);
        fechaTextView.setText(sdf.format(miCalendario.getTime()));
        Calendar calendarioHoy = Calendar.getInstance();

        TextView edadTextView = (TextView) findViewById(R.id.edad2TextViewID);
        edad = calendarioHoy.get(Calendar.YEAR) - miCalendario.get(Calendar.YEAR);
        if (calendarioHoy.get(Calendar.MONTH) < miCalendario.get(Calendar.MONTH)){
            edad--;
            edadTextView.setText(String.valueOf(edad) + " años");
            Toast toast = Toast.makeText(this, "¡Fecha establecida!" , Toast.LENGTH_SHORT);
            toast.show();
        } else if (calendarioHoy.get(Calendar.MONTH) == miCalendario.get(Calendar.MONTH)
                && calendarioHoy.get(Calendar.DAY_OF_MONTH) < miCalendario.get(Calendar.DAY_OF_MONTH)
                ) {
            edad--;
            edadTextView.setText(String.valueOf(edad) + " años");
            Toast toast = Toast.makeText(this, "Uiii, falta poquito para tu cumple!" , Toast.LENGTH_SHORT);
            toast.show();
        } else if (calendarioHoy.get(Calendar.DAY_OF_MONTH) == miCalendario.get(Calendar.DAY_OF_MONTH)){

            Toast toast = Toast.makeText(this, "Felicidades recién nacido!" , Toast.LENGTH_SHORT);
            toast.show();
        } else if (calendarioHoy.get(Calendar.MONTH) == miCalendario.get(Calendar.MONTH)
                && calendarioHoy.get(Calendar.DAY_OF_MONTH) > miCalendario.get(Calendar.DAY_OF_MONTH)) {
            edadTextView.setText(String.valueOf(edad) + " años");
            Toast toast = Toast.makeText(this, "¡Qué lástima! Ya pasó tu cumpleee" , Toast.LENGTH_SHORT);
            toast.show();
        }else {

            Toast toast = Toast.makeText(getApplicationContext(), "Hay un pequeño problema..." , Toast.LENGTH_SHORT);
            toast.show();
        }



        /*
        float diff = calendarioHoy.getTimeInMillis() - miCalendario.getTimeInMillis();
        //Esto no sirve. No lo redondea al minimo.
        int diffround = Math.round((diff/31536000000L)*10)/10;
        edad = diffround;


        if (edadTextView.getText()== null) {
            edadTextView.append(" " + String.valueOf(diffround) + " años");
        }else{

        }*/
    }


    //Este es el botón final
    public void pulsarBotonEncuesta_0(View view) {

        EditText nombreEditText = (EditText) findViewById(R.id.nombreEditTextID);
        EditText nacimientoEditText = (EditText) findViewById(R.id.nacimientoEditTextID);

        Intent intentEncuesta = new Intent(this, EncuestaActivity2.class);
        intentEncuesta.putExtra("nombre", String.valueOf(nombreEditText.getText()));
        intentEncuesta.putExtra("edad", edad);
        //TODO La variable Edad llega a este momento con valor 0. No se a que se debe
        //Idea es crear el Intent en los "if" de antes. PEro es muy sucio.
        intentEncuesta.putExtra("nacimiento" , String.valueOf(nacimientoEditText.getText()));
        intentEncuesta.putExtra("genero", genero);
        startActivity(intentEncuesta);
    }
}
