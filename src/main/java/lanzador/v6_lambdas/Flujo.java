package lanzador.v6_lambdas;

import lanzador.v6_lambdas.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Flujo<T> {

    private final List<T> valores;

    public Flujo(List<T> valores) {
        this.valores = valores;
    }

    public static <T> Flujo<T> proveer(int size, Proveedor<T> proveedor) {
        var resultado = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            resultado.add(proveedor.obtener());
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> filtrar(Predicado<T> predicado) {
        var resultado = new ArrayList<T>();

        for(var valor: valores){
            if(predicado.test(valor)){
                resultado.add(valor);
            }
        }
        return new Flujo<>(resultado);
    }

    public <R> Flujo<R> transformar(Funcion<T, R> funcion) {

        var resultado = new ArrayList<R>();

        for (var valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return new Flujo<>(resultado);
    }

    public Flujo<T> actuar(Consumidor<T> consumidor) {
        for (var valor : valores) {
            consumidor.aceptar(valor);
        }
        return new Flujo<>(valores);
    }

    public void consumir(Consumidor<T> consumidor){
        for (var valor : valores) {
            consumidor.aceptar(valor);
        }
    }

    public T reducir(T identidad, OperadorBinario<T> operadorBinario) {
        var total = identidad;
        for (var valor : valores) {
            total = operadorBinario.aplicar(valor, total);
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
