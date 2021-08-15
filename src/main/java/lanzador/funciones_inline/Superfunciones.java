package lanzador.funciones_inline;

import lanzador.funciones_inline.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class Superfunciones {

    public static List<Integer> proveer(int size, Proveedor proveedor) {
        var numeros = new ArrayList<Integer>();
        for (int i = 0; i < size; i++) {
            numeros.add(proveedor.obtener());
        }
        return numeros;
    }

    public static List<Integer> filtrar(List<Integer> valores, Predicado predicado) {
        var resultado = new ArrayList<Integer>();

        for (var valor : valores) {
            if (predicado.test(valor)) {
                resultado.add(valor);
            }
        }
        return resultado;
    }

    public static List<Integer> transformar(List<Integer> valores, Funcion funcion) {

        var resultado = new ArrayList<Integer>();

        for (var valor : valores) {
            resultado.add(funcion.aplicar(valor));
        }
        return resultado;
    }

    public static void consumir(List<Integer> valores, Consumidor consumidor){
        for (var valor: valores){
            consumidor.aceptar(valor);
        }
    }
    public static int reducir(List<Integer> valores, Integer identidad, FuncionBinaria funcionBinaria){
        var total = identidad;
        for (var valor: valores){
            total = funcionBinaria.aplicar(total, valor);
        }
        return total;
    }
}
