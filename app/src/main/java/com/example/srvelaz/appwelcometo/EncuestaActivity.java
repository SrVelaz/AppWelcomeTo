package com.example.srvelaz.appwelcometo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by SrVelaz on 8/17/2015.
 */
public class EncuestaActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.encuesta_layout_0);
    }

    public void pulsarBotonEncuesta_0(View view) {

        Intent intentEncuesta1 = new Intent(this, EncuestaActivity1.class);
        startActivity(intentEncuesta1);
    }
}
