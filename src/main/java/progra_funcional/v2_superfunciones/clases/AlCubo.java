package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.Funcion;

public class AlCubo implements Funcion {
    @Override
    public Integer aplicar(Integer valor) {
        return (int) Math.pow(valor, 3);
    }
}
