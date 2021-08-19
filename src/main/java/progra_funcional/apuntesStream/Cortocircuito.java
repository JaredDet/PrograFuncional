package progra_funcional.apuntesStream;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

public class Cortocircuito {

     /*
        Las funciones de cortocircuito son aquellas que
        terminan el proceso si se puede determinar el
        resultado con los elementos que ya
        han sido procesados.
     */

    public static void main(String[] args) {

     /*
        Algunas de las funciones de cortocircuito
        de stream son: allMatch, noneMatch
        y anyMatch que
        tienen de parámetro un predicado.
     */

     /*
        allMatch: retorna un valor booleano dependendiendo
        de si todos los elementos del Stream cumplen una
        determinada condición. Si alguno no la cumple,
        se interrumpe el flujo.
     */

        boolean todosImpares =
                new Random()
                        .ints(5, 1, 10)
                        .allMatch(x -> x % 2 != 0);
        System.out.println(todosImpares);

     /*
        noneMatch: retorna un valor booleano dependendiendo
        de si ningún elemento del Stream cumple una
        determinada condición. Si alguno cumple la
        condición se interrumpe el flujo.
     */

        boolean todosPares =
                new Random()
                        .ints(5, 1, 10)
                        .noneMatch(x -> x % 2 != 0);
        System.out.println(todosImpares);

     /*
        anyMatch: retorna un valor booleano dependendiendo
        de si, al menos, un valor del Stream cumple una
        determinada condición. Si algún valor cumple la
        condición, se interrumpe el flujo.
     */

        boolean algunImpar =
                new Random()
                        .ints(5, 1, 10)
                        .anyMatch(x -> x % 2 != 0);
        System.out.println(algunImpar);

        /*
            Otros métodos cortocircuitos son:
            findFirst y findAny que retornan
            un Optional<T>. Los métodos no
            reciben un predicado, por lo que
            se usan encadenados con filter.
         */

        /*
            La función findFirst devuelve el primer
            elemento que cumpla la condición indicada
            en el filter.
         */
        new Random()
                .ints(5, 1, 10)
                .filter(x -> x > 5)
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of(5, 8, 6, 7)
                .filter(x -> x > 5)
                .findAny()
                .ifPresent(System.out::println);

        Stream.of(2, 4, 8, 9, 11)
                .sorted(Comparator.reverseOrder())
                .filter(x -> x % 2 != 0)
                .findFirst()
                .ifPresent(System.out::println);
    }
}

