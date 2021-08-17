package lanzador.v10_optional;

import java.util.Comparator;


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

        Flujo.proveer(10, NumberUtils::retornarAleatorio)
                .ordenar(Integer::compareTo)
                .filtrar(NumberUtils::esPar)
                .transformar(NumberUtils::elevarAlCuadrado)
                .transformar(Descripcion::new)
                .actuar(System.out::println)
                .transformar(Descripcion::getValor)
                .max(Comparator.naturalOrder())
                .ifPresentOrElse(
                        x -> System.out.println("Máximo: " + x.doubleValue()),
                        () -> System.err.println("No hay máximo " +
                                "porque el flujo está vacío")
                );
    }
}
