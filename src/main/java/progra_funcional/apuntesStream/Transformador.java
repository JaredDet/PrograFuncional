package progra_funcional.apuntesStream;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Transformador {

    public Transformador() {

        /*
            La función principal de transformación es la
            función map; la cual retorna un stream nuevo
            a partir de aplicar la función de
            transformación mapFunction a cada uno de
            los elementos del stream original.
         */

        var resultado =
                Stream.of(1, 2, 3)
                        .map(n -> "V(" + n + ")")
                        .collect(Collectors.toList());
        System.out.println(resultado + "\n");

        var resultado2 =
                IntStream.range(0, 10)
                        .boxed()
                        .map(x -> x * 2)
                        .collect(Collectors.toList());
        System.out.println(resultado2 + "\n");

        /*
            Para pasar de un tipo boxed a uno primitivo
            basta con usar la función map de dicho tipo.
            Pero, para pasar de un tipo primitivo a un
            tipo boxed, se utiliza la función boxed.
         */

        var resultado3 =
                IntStream.range(0, 10)
                        .mapToDouble(x -> x)
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println(resultado3 + "\n");

        var resultado4 =
                Stream.of("1", "2", "3", "4", "5", "6")
                        .mapToInt(Integer::parseInt)
                        .boxed()
                        .collect(Collectors.toList());
        System.out.println(resultado4 + "\n");

        /*
            Cuando el retorno de la función lambda sea un Stream
            de un boxed, entonces tendremos que utilizar la función
            flatMap, en lugar de la función map.
         */

        var resultado5 =
                Stream.of(2, 4, 6)
                        .flatMap(this::obtenerNumerosAleatorios)
                        .collect(Collectors.toList());
        System.out.println(resultado5 + "\n");

    }

    public Stream<Integer> obtenerNumerosAleatorios(int size) {
        return new Random().ints(size, 0, 10).boxed();
    }

    public static void main(String[] args) {
        new Transformador();
    }
}

