package progra_funcional.v6_lambdas;

import java.util.List;


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

        System.out.println("\nEl total es: " +
                Flujo.proveer(10, () -> (int) (Math.random() * 1000)).
                        filtrar(x -> x % 2 == 0).
                        transformar(x -> (int) (Math.pow(x, 2))).
                        actuar(x -> System.out.print(x + " ")).
                        reducir(0, Integer::sum));

        new Flujo<>(List.of(1,2,3,4,5,6,7,8,9,10)).
                filtrar(x -> x % 2 == 0).
                transformar(x -> (int) (Math.pow(x, 3))).
                consumir(x -> System.out.print(x + " "));
    }
}
