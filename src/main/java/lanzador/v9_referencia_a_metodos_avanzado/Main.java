package lanzador.v9_referencia_a_metodos_avanzado;

import java.util.List;


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

        System.out.println("El total es: " +
                Flujo.proveer(10, NumberUtils::retornarAleatorio)
                         //.ordenar((x, y) -> x.compareTo(y)).
                        .ordenar(Integer::compareTo)
                        .filtrar(NumberUtils::esPar)
                        .transformar(NumberUtils::elevarAlCuadrado)
                         //.transformar(x -> new Descripcion(x))
                        .transformar(Descripcion::new)
                        .actuar(System.out::println)
                        .transformar(Descripcion::getValor)
                        .reducir(0, Integer::sum));

        new Flujo<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
                .filtrar(NumberUtils::esPrimo)
                .ordenar(Integer::compareTo)
                .transformar(NumberUtils::elevarAlCubo)
                .consumir(System.out::println);
    }
}
