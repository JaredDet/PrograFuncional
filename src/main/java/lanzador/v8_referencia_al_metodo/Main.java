package lanzador.v8_referencia_al_metodo;

import java.util.List;


public class Main {

        /*

    ¿QUÉ HACER?

    1.- Crear lista de enteros
    2.- Filtrar primos
    3.- Pasar los pares al cuadrado
    4.- Mostrar los cuadrados
    5.- sumar los cuadrados

    PARA GENÉRICOS

     */

    public static void main(String[] args) {

        System.out.println("El total es: " +
                Flujo.proveer(10, NumberUtils::retornarAleatorio).
                        filtrar(NumberUtils::esPrimo).
                        transformar(NumberUtils::elevarAlCuadrado).
                        actuar(System.out::println).
                        reducir(0, Integer::sum));

        new Flujo<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)).
                filtrar(NumberUtils::esPar).
                transformar(NumberUtils::elevarAlCubo).
                consumir(System.out::println);
    }
}
