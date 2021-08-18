package lanzador.v11_streams;

import lanzador.v10_optional.Descripcion;

import java.util.Random;


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

        new Random()
                .ints(5, 1, 11)
                .boxed()
                .filter(x -> x % 2 == 0)
                .sorted()
                .map(x -> (int) Math.pow(x, 2))
                .map(Descripcion::new)
                .peek(x -> System.out.print(x + " "))
                .map(Descripcion::getValor)
                .mapToInt(x -> x)
                .max()
                .ifPresentOrElse(
                        x -> System.out.println("\n" + x),
                        () -> System.err.println("No hay máximo " +
                                "porque el flujo está vacío")
                );
    }
}