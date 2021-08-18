package progra_funcional.v2_superfunciones.clases;

import progra_funcional.v2_superfunciones.interfaces.FuncionBinaria;

public class Sumador implements FuncionBinaria {

    @Override
    public Integer aplicar(Integer valor1, Integer valor2) {
        return valor1 + valor2;
    }
}
