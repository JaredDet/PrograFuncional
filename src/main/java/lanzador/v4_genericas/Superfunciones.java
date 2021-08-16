package lanzador.v4_genericas;

import lanzador.v4_genericas.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Superfunciones {

    public static <T> List<T> proveer(int size, Proveedor<T> proveedor) {
        var numeros = new ArrayList<T>();
        for (int i = 0; i < size; i++) {
            numeros.add(proveedor.obtener());
        }
        return numeros;
    }

    public static <T> List<T> filtrar(List<T> valores, Predicado<T> predicado) {
        var resultado = new ArrayList<T>();

        for(var valor: valores){
            if(predicado.test(valor)){
                resultado.add(valor);
            }
        }
        return resultado;
    }

    public static <T, R> List<R> transformar(List<T> valores, Funcion<T, R> funcion) {

        var resultado = new ArrayList<R>();

        for (var valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }

    public static <T> void consumir(List<T> valores, Consumidor<T> consumidor) {
        for (var valor : valores) {
            consumidor.aceptar(valor);
        }
    }

    public static <T> T reducir(List<T> valores, T identidad, OperadorBinario<T> operadorBinario) {
        var total = identidad;
        for (var valor : valores) {
            total = operadorBinario.aplicar(valor, total);
        }
        return total;
    }
}
