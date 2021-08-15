package lanzador.superfunciones.clases;

import lanzador.superfunciones.interfaces.Funcion;

public class AlCubo implements Funcion {
    @Override
    public Integer aplicar(Integer valor) {
        return (int) Math.pow(valor, 3);
    }
}
