package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.Funcion;

public class AlCuadrado implements Funcion {
    @Override
    public Integer aplicar(Integer valor) {
        return (int) Math.pow(valor, 2);
    }
}
