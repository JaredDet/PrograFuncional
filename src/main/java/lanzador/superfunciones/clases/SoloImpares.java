package lanzador.superfunciones.clases;

import lanzador.superfunciones.interfaces.Predicado;

public class SoloImpares implements Predicado {

    @Override
    public boolean test(Integer valor) {
        return valor % 2 != 0;
    }
}
