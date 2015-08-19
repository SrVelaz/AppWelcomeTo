package com.example.srvelaz.appwelcometo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by SrVelaz on 8/19/2015.
 */
public class EncuestaActivity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta_layout_2);

        //Instancio los textViews
        TextView nombreTextView2 = (TextView) findViewById(R.id.nombreTextView2ID);
        TextView edadTextView2 = (TextView) findViewById(R.id.edadTextView2ID);
        TextView nacimientoTextView2 = (TextView) findViewById(R.id.nacimientoTextView2ID);
        TextView generoTextView2 = (TextView) findViewById(R.id.generoTextView2ID);


        //Creo el intent para recoger los datos enviados
        Intent intentEncuestaAcitivity2 = getIntent();
        String nombreEncuestaAcitivity2 = intentEncuestaAcitivity2.getExtras().getString("nombre");
        String edadEncuestaAcitivity2 = String.valueOf(intentEncuestaAcitivity2.getExtras().getInt("edad"));
        String nacimientoEncuestaAcitivity2 = intentEncuestaAcitivity2.getExtras().getString("nacimiento");
        String generoEncuestaAcitivity2 = intentEncuestaAcitivity2.getExtras().getString("genero");


        //Añado los valores a los textViews
        nombreTextView2.setText(nombreEncuestaAcitivity2);
        edadTextView2.setText(edadEncuestaAcitivity2);
        nacimientoTextView2.setText(nacimientoEncuestaAcitivity2);
        generoTextView2.setText(generoEncuestaAcitivity2);



        //Establezco la fuente a los textViews
        Typeface type1 = Typeface.createFromAsset(getAssets(),"fonts/planetbe.ttf");
        Typeface type2 = Typeface.createFromAsset(getAssets(),"fonts/Sweetly Broken.ttf");

        nombreTextView2.setTypeface(type2);
        nacimientoTextView2.setTypeface(type2);











    }
}
