package progra_funcional.apuntesStream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Generarador {

    public static void main(String[] args) {

        //Función generadora
        var resultado =
                Stream.of("Pedro", "Juan", "Diego")
                        //0 o más operaciones intermedias
                        .filter(x -> x.contains("o"))
                        //Operación terminal
                        .collect(Collectors.toList());
        System.out.println(resultado + "\n");

        /*
            Cuando se genera un Stream infinito, es necesario usar
            la función limit para no generar un Stackover flow
        */

        /*
            En el siguiente ejemplo se verá que la función limit limita el generador
            y no las funciones siguientes
        */

        var resultado2 =
                Stream.generate(() -> {
                    var next = new Random()
                            .ints()
                            .boxed()
                            .limit(1)
                            .collect(Collectors.toList());
                    System.out.println("Se ha generado el: " + next);
                    return next;
                }).limit(5)
                        .collect(Collectors.toList());
        System.out.println("\n" + resultado2 + "\n");

        var resultado3 =
                IntStream
                        .rangeClosed(1, 8)
                        .filter(x -> x % 2 == 0)
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println(resultado3 + "\n");

        /*
            Se utiliza iterate para generar un Stream infinito donde
            los valores, a partir del segundo, son el resultado de aplicar una
            operación unaria al anterior. Se puede detener el generador con la
            función limit o colocando un predicado como 2do argumento.
        */

        var resultado4 = Stream.iterate(1, x -> x * 5)
                .limit(5)
                .collect(Collectors.toList());
        System.out.println(resultado4 + "\n");

        var resultado5 = Stream.iterate(1, x -> x < 1000, x -> x * 5)
                .collect(Collectors.toList());
        System.out.println(resultado5 + "\n");
    }
}
