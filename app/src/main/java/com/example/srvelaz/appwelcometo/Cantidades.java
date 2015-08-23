package com.example.srvelaz.appwelcometo;

import java.text.DecimalFormat;

/**
 * Created by SrVelaz on 8/20/2015.
 */
public class Cantidades {

      final double valor;
      final Unidad unidad;

    public static enum Unidad {
        m (1.0d), pm (1E12d), nm (1E9d), um (1E6d), mm (1000d),
        cm (100d), dm (10d), dam (0.1d), hm (0.01d), km (0.001d);

        final static Unidad baseUnit = m;
        final double UnidadBase;

        private Unidad (double UnidadBase){
            this.UnidadBase = UnidadBase;
        }

        public double aMetros (double valor){
            return valor / UnidadBase;
        }

        public double desdeMetros (double valor){
            return valor*UnidadBase;
        }
    }
    public Cantidades (double valor, Unidad unidad) {
        super();
        this.valor = valor;
        this.unidad = unidad;
    }
    public Cantidades to(Unidad nuevaUnidad){
        Unidad antiguaUnidad = this.unidad;
        return new Cantidades(nuevaUnidad.desdeMetros(antiguaUnidad.aMetros(valor)), nuevaUnidad);
    }
    public String toString (){
        DecimalFormat df = new DecimalFormat("#.000");
        return df.format(valor) + " " + unidad.name();
    }
}
