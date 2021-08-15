package lanzador.superfunciones.clases;

import lanzador.superfunciones.interfaces.Proveedor;

public class Aleatorio implements Proveedor {

    @Override
    public Integer obtener() {
        return (int) (Math.random() * 1000);
    }
}
