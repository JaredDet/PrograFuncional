package progra_funcional.apuntesStream;

import progra_funcional.apuntesStream.clase.Estudiante;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reductor {

    public static void main(String[] args) {

         /*
            La primera función de reducción a mostrar
            es: count; que retorna un long con el número
            de elementos que hay en el stream.
         */

        var resultado =
                Stream.iterate(1, x -> x * 6)
                        .limit(10)
                        .filter(x -> x % 2 != 0)
                        .count();
        System.out.println("La cantidad de elementos es: " + resultado);

        /*
            Las clases de stream numéricos primitivos
            [IntStream, DoubleStream, LongStream]
            poseen las funciones:
            sum: para calcular la suma de los
            elementos en el stream;
            average: para calcular el promedio
            entre los elementos del stream;
            max: para devolver el valor más grande del stream;
            y min: para devolver el valor más pequeño del stream.
        */

        var resultado2 =
                IntStream.rangeClosed(1, 10)
                        .sum();
        System.out.println("El total es: " + resultado2);

        /*
            Si quisiéramos utilizar dichas funciones
            con flujos de boxed, habría que transformar
            dichos flujos a flujos numéricos primitivos.
         */

        var resultado3 =
                Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                        .mapToLong(Integer::longValue)
                        .sum();
        System.out.println("El total es: " + resultado3);

        /*
            Como se podrá apreciar en los siguientes ejemplos,
            dado que la solución puede que no esté en el
            conjunto, el valor de retorno es Optional.
         */

        IntStream.rangeClosed(1, 3)
                .filter(x -> x % 2 != 0)
                .min()
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("El stream está vacío y no hay mínimo")
                );

        IntStream.rangeClosed(1, 4)
                .filter(x -> x >= 5)
                .max()
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("El stream está vacío y no hay máximo")
                );

        IntStream.rangeClosed(1, 10)
                .filter(x -> x % 3 == 0)
                .average()
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("El stream está vacío y no hay promedio")
                );

        /*
            También se puede utilizar max y min con
            Streams de boxed. Sin embargo, se tiene
            que enviar un comparador como argumento.
         */
        Stream.of("Pedro", "Juan", "Ninoska")
                .filter(x -> x.contains("a"))
                .max(Comparator.naturalOrder())
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("El stream está vacío y no hay máximo")
                );

        /*
            Además de las ya mencionadas, también podemos crear nuestras
            propias reducciones con la función sobrescribible reduce.
         */

        /*
            El método puede recibir un operador binario, una identidad
            y una función binaria.
         */
        Stream.of("Pedro", "Juan", "Diego")
                .reduce((x, y) -> x + ", " + y)
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("El stream está vacío y no hay máximo")
                );

        Stream.of(2, 3, 4)
                //.filter(x -> false)
                .reduce((x, y) -> x * y)
                .ifPresentOrElse(System.out::println,
                        () -> System.err.println("El stream está vacío " +
                                "y no se pudo reducir")
                );

        /*
            Si le damos una identidad, el retorno será
            un elemento de tipo boxed y no uno de tipo optional.
            Si no hay elementos en el stream, retorna
            la identidad.
         */

        var resultado4 = Stream.of(2, 3, 4)
                .filter(x -> false)
                .reduce(1, (x, y) -> x * y);
        System.out.println(resultado4);

        /*
            Si se quieren reducir elementos de tipo distinto,
            habrá que enviar un tercer parámetro que especifique
            como se va a llevar a cabo la reducción.
         */

        /*
            La idea es la siguiente:
            El segundo parámetro realiza -en este caso-
            "la suma" y el tercer parámetro realiza
            la suma de lo que se guardó después
            del segundo parámetro.
         */

        var resultado5 =
                Stream.of(
                        new Estudiante("Pablo", 20),
                        new Estudiante("Juan", 21),
                        new Estudiante("Diego", 22)
                ).reduce(0,
                        (acumulador, estudiante) -> acumulador + estudiante.getEdad(),
                        Integer::sum);
        System.out.println(resultado5);
    }
}
