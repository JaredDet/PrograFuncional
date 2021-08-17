package lanzador.apuntesStream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ordenador {

    public static void main(String[] args) {

        /*
            Para ordenar se utiliza el método sorted;
            el cual se puede usar el cual viene por
            defecto o pasarle una interfaz Comparable
            como el argumento.
         */

        var resultado =
                Stream.of("Baldomero", "Germán", "Ambrosio")
                        .sorted()
                        .limit(2)
                        .peek(System.out::println)
                        .collect(Collectors.toList());

        System.out.println(resultado + "\n");

        var resultado2 =
                Stream.of("Baldomero", "Germán", "Ambrosio")
                        .sorted(Comparator.reverseOrder())
                        .limit(2)
                        .peek(System.out::println)
                        .collect(Collectors.toList());

        System.out.println(resultado2 + "\n");
    }
}
