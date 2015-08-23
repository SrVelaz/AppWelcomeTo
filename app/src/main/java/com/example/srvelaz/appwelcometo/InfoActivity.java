package com.example.srvelaz.appwelcometo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by SrVelaz on 8/23/2015.
 */
public class InfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_layout_0);




    }

    public void pulsarBotonInfo_volver(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
