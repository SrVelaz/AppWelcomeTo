package com.example.srvelaz.appwelcometo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class UnidadesActivity extends Activity {

    private Spinner miSpinner;
    private EditText miEditText;
    TextView picometroTV, nanometroTV, micrometroTV, milimetroTV, centimetroTV,
            decimetroTV, metroTV, decametroTV, hectometroTV, kilometroTV;
    //Con este método defino el string que contendrá la dirección de la clase para poder
    //hacer debug
    private static final String TAG = UnidadesActivity.class.getSimpleName();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.unidades_layout_0);


        addAlSpinner();
        addListenerAlSpinner();
        inicializarTextViews();
        comienzoClickEditText();
        //Códigos de debug
        Log.d(TAG, "Ha terminado todo el OnCreate (3/8)");
    }


    public void comienzoClickEditText () {

        miEditText = (EditText) findViewById(R.id.editText);
        miEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                        (keyCode == KeyEvent.KEYCODE_ENTER)){


                    addAlSpinner();
                    addListenerAlSpinner();
                    inicializarTextViews();

                    return true;
                }

                return false;
            }
        });

    }

    public void inicializarTextViews () {

        picometroTV = (TextView) findViewById(R.id.picometro_id);
        nanometroTV = (TextView) findViewById(R.id.nanometro_id);
        micrometroTV = (TextView) findViewById(R.id.micrometro_id);
        milimetroTV = (TextView) findViewById(R.id.milimetro_id);
        centimetroTV = (TextView) findViewById(R.id.centimetro_id);
        decimetroTV = (TextView) findViewById(R.id.decimetro_id);
        metroTV = (TextView) findViewById(R.id.metro_id);
        decametroTV = (TextView) findViewById(R.id.decametro_id);
        hectometroTV = (TextView) findViewById(R.id.hectometro_id);
        kilometroTV = (TextView) findViewById(R.id.kilometro_id);

        //Códigos de debug
        Log.d (TAG, "se han inicializado los TextViews (1/8)");
    }

    public void addAlSpinner () {
        miSpinner = (Spinner) findViewById(R.id.miSpinner_ID);
        //Creo el arrayAdapter (Recordar el ListAdapter)
        ArrayAdapter<CharSequence> adaptadorSpinner = ArrayAdapter.createFromResource(this,
                R.array.modelos_de_conversion, android.R.layout.simple_spinner_item);
        //Además, defino el diseño del desplegable.
        adaptadorSpinner.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Añado el adaptador al spinner.
        miSpinner.setAdapter(adaptadorSpinner);

        //Códigos de debug
        Log.d(TAG, "se ha añadido el contenido al Spinner (2/8)");
    }

    public void addListenerAlSpinner () {
        miSpinner = (Spinner) findViewById(R.id.miSpinner_ID);
        //Creo el listener y directamente se lo asigno al Spinner. El listener no es
        //OnClickListener, es OnSelectedListener.
        miSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String itemSeleccionado = parent.getItemAtPosition(position).toString();
                comprobarConversionDesdeMetros(itemSeleccionado);


            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void comprobarConversionDesdeMetros(String unidadActual) {

        if (unidadActual.equals("metro")){
            actualizarUnidadDesdeMetros (Cantidades.Unidad.m);
        } else {

            if (unidadActual.equals("decimetro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.dm);
            } else if (unidadActual.equals("centimetro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.cm);
            }else if (unidadActual.equals("milimetro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.mm);
            }else if (unidadActual.equals("micrometro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.um);
            }else if (unidadActual.equals("nanometro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.nm);
            }else if (unidadActual.equals("picometro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.pm);
            }else if (unidadActual.equals("decametro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.dam);
            }else if (unidadActual.equals("centimetro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.cm);
            }else if (unidadActual.equals("hectometro")){
                actualizarTextoDesdeOtra(Cantidades.Unidad.hm);
            }else {
                actualizarTextoDesdeOtra(Cantidades.Unidad.km);
            }

        }

    }

    public void actualizarUnidadDesdeMetros (Cantidades.Unidad unidadActual){

        miEditText = (EditText) findViewById(R.id.editText);
        //Extraigo el valor numérico del EditText
        double valorAConvertir = Double.parseDouble(miEditText.getText().toString());
        //Creo el string que contiene el valor y la unidad en metros.
        String valorYUnidad = valorAConvertir + " metros";
        //Introduzco este valor en la etiqueta de metros
        metroTV.setText(valorYUnidad);

        //Actualizamos el resto de los textViews
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.dm, decimetroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.cm, centimetroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.mm, milimetroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.um, micrometroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.nm, nanometroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.pm, picometroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.dam, decametroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.hm, hectometroTV);
        actualizarTextoDesdeMetros(valorAConvertir, Cantidades.Unidad.km, kilometroTV);
    }

    public void actualizarTextoDesdeMetros (double doubleAConvertir,
                                            Cantidades.Unidad unidadAConvertir,
                                            TextView elTextView){

        Cantidades cantidad = new Cantidades(doubleAConvertir, Cantidades.Unidad.m);
        String unidadTemporal = cantidad.to(unidadAConvertir).toString();
        elTextView.setText(unidadTemporal);
    }

    public void actualizarTextoDesdeOtra (Cantidades.Unidad unidadAConvertir) {

        miEditText = (EditText) findViewById(R.id.editText);

        //Códigos de debug
        Log.d(TAG, "Se ha instanciado miEditText en  actualizarTextoDesdeOtra(4/8)");


        String stringAuxiliar = miEditText.getText().toString();
        double valorExtraido = Double.parseDouble(stringAuxiliar);

        //Códigos de debug
        Log.d(TAG, "Se a creado la variable double valorExtraido (5/8)");

        Cantidades cantidadSeleccionada = new Cantidades(valorExtraido, unidadAConvertir);
        String valorEnMetro = cantidadSeleccionada.to(Cantidades.Unidad.m).toString();

        metroTV.setText(valorEnMetro);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.dm, decimetroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.cm, centimetroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.mm, milimetroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.um, micrometroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.nm, nanometroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.pm, picometroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.dam, decametroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.hm, hectometroTV);
        actualizarTextoDesdeMetros(valorExtraido, unidadAConvertir, Cantidades.Unidad.km, kilometroTV);

        if (unidadAConvertir.name().equals(cantidadSeleccionada.unidad.name())){

            String textoActualDelTextView = valorExtraido + " " + cantidadSeleccionada.unidad.name();

            //Códigos de debug
            Log.d(TAG, "Se ha creado el String textoActualDelTextView (6/8)");

            String nombreActualDelTextView = cantidadSeleccionada.unidad.name() + "_text_view";

            int idActual = getResources().getIdentifier(nombreActualDelTextView, "id" , UnidadesActivity.this.getPackageName());

            //Códigos de debug
            Log.d(TAG, "Se ha creado el int idActual con valor " + idActual + " (7/8)");

            //El problema estaba causado por esta variable.
            if (idActual != 0) {

                TextView textViewActual = (TextView) findViewById(idActual);

                textViewActual.setText(textoActualDelTextView);

            }


        }
    }

    public void actualizarTextoDesdeMetros (double doubleAConvertir, Cantidades.Unidad unidadAConvertir,
                                            Cantidades.Unidad unidadElegida, TextView elTextView ){
        Cantidades cantidadSeleccionada = new Cantidades(doubleAConvertir, unidadAConvertir);
        String textoTemporalTV = cantidadSeleccionada.to(Cantidades.Unidad.m).
                to(unidadElegida).toString();
        elTextView.setText(textoTemporalTV);
    }
}
