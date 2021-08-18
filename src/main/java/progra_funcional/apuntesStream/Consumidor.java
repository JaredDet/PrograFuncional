package progra_funcional.apuntesStream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Consumidor {


    public static void main(String[] args) {

        /*
            La función forEach muestra en pantalla todos
            los elementos que se encuentren en el Stream.
            No obstante, no retorna nada, por lo que es
            una función terminal.
         */

        Stream.of(2, 4, 6)
                .flatMap(x -> new Random().ints(x, 0, 10).boxed())
                .forEach(System.out::println);
        System.out.println();

        /*
            Si se quiere realizar un forEach para elementos
            previamente ordenados, se utiliza forEachOrdered.
            Esta función es muy útil principalmente cuando
            se ejecuta un stream paralelo. Ya que no hay
            garantía de que se ejecute ordenado con forEach.
            La función suele ir después de la función sorted.
         */

        Stream.of(4, 2, 6)
                .parallel()
                .sorted()
                .forEachOrdered(System.out::println);
        System.out.println();

        /*
            La función que realiza lo mismo que un forEach
            pero sí retorna un nuevo Stream para seguir
            encadenando es: peek.
         */

        var resultado =
                Stream.of(2, 4, 6)
                        .flatMap(x -> new Random().ints(x, 0, 10).boxed())
                        .peek(System.out::println)
                        .collect(Collectors.toList());
        System.out.println("\n" + resultado + "\n");

        var resultado2 =
                Stream.of(2, 4, 6, 3, 7, 1)
                        .parallel()
                        .sorted()
                        .peek(System.out::println)
                        .collect(Collectors.toList());
        System.out.println("\n" + resultado2 + "\n");

    }
}
