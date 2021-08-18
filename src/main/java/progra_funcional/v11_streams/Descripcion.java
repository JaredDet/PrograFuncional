package progra_funcional.v11_streams;

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
