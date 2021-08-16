package lanzador.v2_superfunciones.clases;

import lanzador.v2_superfunciones.interfaces.Predicado;

public class SoloImpares implements Predicado {

    @Override
    public boolean test(Integer valor) {
        return valor % 2 != 0;
    }
}
