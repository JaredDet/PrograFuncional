package lanzador.v2_superfunciones.clases;

import lanzador.v2_superfunciones.interfaces.Proveedor;

public class Aleatorio implements Proveedor {

    @Override
    public Integer obtener() {
        return (int) (Math.random() * 1000);
    }
}
