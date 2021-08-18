package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.Predicado;

public class SoloPares implements Predicado {
    @Override
    public boolean test(Integer valor) {
        return valor % 2 == 0;
    }
}
