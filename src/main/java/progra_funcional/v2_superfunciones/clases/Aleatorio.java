package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.Proveedor;

public class Aleatorio implements Proveedor {

    @Override
    public Integer obtener() {
        return (int) (Math.random() * 1000);
    }
}
