package lanzador.superfunciones.clases;

import lanzador.superfunciones.interfaces.Proveedor;

public class Naturales implements Proveedor {

    private static int next = 1;
    @Override
    public Integer obtener() {
        return next++;
    }
}
