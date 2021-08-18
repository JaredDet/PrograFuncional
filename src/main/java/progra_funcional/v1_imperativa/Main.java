package progra_funcional.v1_imperativa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    /*

    ¿QUÉ HACER?

    1.- Crear lista de enteros
    2.- Filtrar pares
    3.- Pasar los pares al cuadrado
    4.- Mostrar los cuadrados
    5.- sumar los cuadrados

     */

    public static void main(String[] args) {
        var numeros = crearLista();
        System.out.println(numeros);
        var pares = filtrarPares(numeros);
        System.out.println(pares);
        var cuadrados = elevarAlCuadrado(pares);
        System.out.println(cuadrados);

        //mostrarLista(cuadrados);

        var total = sumarLista(cuadrados);
        System.out.println("La suma de los cuadrados es: " + total);
    }

    public static List<Integer> crearLista(){
        //return Arrays.asList(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
        return List.of(1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144);
    }

    public static List<Integer> filtrarPares(List<Integer> lista){
        var resultado = new ArrayList<Integer>();
        for (var numero : lista) {
            if (numero % 2 == 0) {
                resultado.add(numero);
            }
        }
        return resultado;
    }

    public static List<Integer> elevarAlCuadrado(List<Integer> lista){
        for(int i = 0; i < lista.size(); i++){
            lista.set(i, (int) Math.pow(lista.get(i), 2));
        }
        return lista;
    }

    public static void mostrarLista(List<Integer> lista){
        for (var numero : lista) {
            System.out.println(numero);
        }
    }

    public static Integer sumarLista(List<Integer> lista){
        var total = 0;
        for (var numero: lista){
            total += numero;
        }
        return total;
    }
}
