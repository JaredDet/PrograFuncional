package lanzador.superfunciones.clases;

import lanzador.superfunciones.interfaces.FuncionBinaria;

public class Multiplicador implements FuncionBinaria {
    @Override
    public Integer aplicar(Integer valor1, Integer valor2) {
        return valor1 * valor2;
    }
}
