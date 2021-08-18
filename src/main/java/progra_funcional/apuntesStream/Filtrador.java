package progra_funcional.apuntesStream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtrador {

    public static void main(String[] args) {

        /*
            Se utiliza la función distinct -al igual que en SQL-
            para filtrar datos repetidos.
         */

        var resultado =
                Stream.of(1, 3, 2, 3, 1)
                        .distinct()
                        .collect(Collectors.toList());
        System.out.println("Los valores son: " + resultado + "\n");
        /*
            Se utiliza la función limit para limitar la cantidad de
            elementos que provengan de la fuente de datos
         */

        var resultado2 =
                Stream.of(1, 3, 2, 3, 1)
                        .limit(2)
                        .collect(Collectors.toList());
        System.out.println("Los valores son: " + resultado2 + "\n");

        /*
            Se utiliza la función filter para filtrar los
            elementos que provengan de la fuente que cumplan
            una determinada condición. Desde la v2 llevamos
            usando esta función.
         */

        var resultado3 =
                Stream.of(1, 3, 2, 3, 1)
                        .distinct()
                        .filter(x -> x % 2 == 0)
                        .collect(Collectors.toList());
        System.out.println("Los valores son: " + resultado3 + "\n");

        /*
            Se utiliza la función skip que recibe un número para
            generar un nuevo stream que no incluye los primeros
            n elementos del stream original.
         */

        var resultado4 =
                Stream.of(1, 3, 8, 5, 2)
                .skip(2)
                .collect(Collectors.toList());
        System.out.println("Los valores son: " + resultado4 + "\n");

        /*
            Otra función que realiza el mismo trabajo que skip es dropwhile
            que recibe un predicado.
         */

        var resultado5 = Stream.of(2, 4, 6, 8, 9, 10, 12)
                .dropWhile(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Los valores son: " + resultado5 + "\n");

        /*
            La función inversa a dropwhile es takewhile. La función
            retorna un stream nuevo obtenido a partir de recorrer
            el stream original, comprobando si para cada uno de los
            elementos se cumple o no el predicado. Cuando se encuentra
            un elemento que no cumpla con el predicado, se devuelve el
            stream nuevo.
         */

        var resultado6 =
                Stream.of(2, 4, 6, 8, 9, 10, 12)
                .takeWhile(x -> x % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Los valores son: " + resultado6 + "\n");
    }
}
