package lanzador.superfunciones.clases;

import lanzador.superfunciones.interfaces.Consumidor;

public class Impresor implements Consumidor {
    @Override
    public void aceptar(Integer valor) {
        System.out.println(valor);
    }
}
