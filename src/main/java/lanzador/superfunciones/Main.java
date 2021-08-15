package lanzador.superfunciones;

import lanzador.superfunciones.clases.*;

public class Main {

        /*

    ¿QUÉ HACER?

    1.- Crear lista de enteros
    2.- Filtrar pares
    3.- Pasar los pares al cuadrado
    4.- Mostrar los cuadrados
    5.- sumar los cuadrados

    PARA GENÉRICOS

     */

    public static void main(String[] args) {
        var numeros = Superfunciones.proveer(10, new Naturales());
        System.out.println(numeros);
        var pares = Superfunciones.filtrar(numeros, new SoloPares());
        System.out.println(pares);
        var cuadrados = Superfunciones.transformar(pares, new AlCuadrado());
        System.out.println(cuadrados);
        Superfunciones.consumir(cuadrados, new Impresor());
        var reducido = Superfunciones.reducir(cuadrados, 1, new Multiplicador());
        System.out.println("El total es:" + reducido);
    }
}
