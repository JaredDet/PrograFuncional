package lanzador.v7_interfaces_funcionales_estandar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.*;

public class Flujo<T> {

    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }

    public static <T> Flujo<T> proveer(int size, Supplier<T> proveedor) {
        var resultado = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            resultado.add(proveedor.get());
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> filtrar(Predicate<T> predicado) {
        var resultado = new ArrayList<T>();

        for(var valor: valores){
            if(predicado.test(valor)){
                resultado.add(valor);
            }
        }
        return new Flujo<>(resultado);
    }

    public <R> Flujo<R> transformar(Function<T, R> funcion) {

        var resultado = new ArrayList<R>();

        for (var valor : valores) {
            resultado.add(funcion.apply(valor));
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> actuar(Consumer<T> consumidor) {
        for (var valor : valores) {
            consumidor.accept(valor);
        }
        return new Flujo<>(valores);
    }

    public void consumir(Consumer<T> consumidor){
        for (var valor : valores) {
            consumidor.accept(valor);
        }
    }

    public T reducir(T identidad, BinaryOperator<T> operadorBinario) {
        var total = identidad;
        for (var valor : valores) {
            total = operadorBinario.apply(valor, total);
        }
        return total;
    }

    public List<T> getValores() {
        return valores;
    }

    @Override
    public String toString() {
        return valores.toString();
    }
}
