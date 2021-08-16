package lanzador.v9_referencia_a_metodos_avanzado;

public class Descripcion {

    private final Integer valor;

    public Descripcion(Integer valor){
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "V(" + valor +")";
    }
}
