package lanzador.v7_interfaces_funcionales_estandar;

import java.util.List;
import java.util.stream.Stream;


public class Main {

        /*

    ¿QUÉ HACER?

    1.- Crear lista de enteros
    2.- Filtrar pares
    3a.- Pasar los pares al cuadrado
    3b.- Pasar los números a String
    4.- Mostrar los cuadrados
    5.- sumar los cuadrados

    PARA GENÉRICOS

     */

    public static void main(String[] args) {

        System.out.println("El total es: " +
                Flujo.proveer(10, () -> (int) (Math.random() * 1000))
                        .filtrar(x -> x % 2 == 0)
                        .ordenar((x, y) -> {
                            return (x < y) ? -1 : (x.equals(y)) ? 0 : 1;
                        })
                        .transformar(x -> (int) (Math.pow(x, 2)))
                        .actuar(x -> System.out.println(x))
                        .reducir(0, (x, y) -> x + y));

        new Flujo<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .filtrar(x -> x % 2 == 0)
                .transformar(x -> (int) (Math.pow(x, 3)))
                .consumir(x -> System.out.println(x));
    }
}
