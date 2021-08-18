package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.Consumidor;

public class Impresor implements Consumidor {
    @Override
    public void aceptar(Integer valor) {
        System.out.println(valor);
    }
}
