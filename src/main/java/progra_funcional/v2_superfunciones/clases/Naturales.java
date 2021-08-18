package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.Proveedor;

public class Naturales implements Proveedor {

    private static int next = 1;
    @Override
    public Integer obtener() {
        return next++;
    }
}
