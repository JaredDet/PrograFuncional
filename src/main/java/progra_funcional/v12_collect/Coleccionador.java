package progra_funcional.v12_collect;

import com.sun.source.tree.Tree;

import java.awt.print.Book;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Coleccionador {

     /*
        La función de recolección collect es una
        operación terminal que permite crear una
        estructura de datos con los resultados
        del procesamiento de datos
        asociados a un stream.
        La función recibe como parámetro
        un objeto que implemente la
        interfaz Collector.
     */

     /*
        En Java, la clase de utilidad que se suele
        utilizar es: Collectors.
     */

    public Coleccionador() {

         /*
            La clase Collectors tiene varios métodos
            de recolección; alguno de ellos son:
            toList, toUnmodifiableList, toSet
         */

         /*
            La función toList retorna una lista con
            los elementos del stream.
         */

        List<Libro> misLibros = Arrays.asList(
                new Libro("345-89", "Sufriendo a Pedro", 2018, Genero.TERROR),
                new Libro("923-45", "Los papeles por delante", 1998, Genero.THRILLER),
                new Libro("978-25", "La vida de Baldomero", 2007, Genero.COMEDIA),
                new Libro("923-45", "Los papeles por delante", 1998, Genero.THRILLER),
                new Libro("978-25", "La vida de Baldomero", 2007, Genero.COMEDIA)
        );

         /*
            La función toList nos devuelve una lista modificable;
            en cambio, la función toUnmodifiableList devuelve una
            lista inmodificable.
         */

        var resultado =
                misLibros.stream()
                        .filter(x -> x.getAnioDePublicacion() < 2010)
                        .collect(Collectors.toList());
        System.out.println(resultado + "\n");

         /*
            La función toSet devuelve un conjunto.
            Los conjuntos no tienen ni orden ni
            tampoco elementos repetidos.
            Al igual que con toList, existe:
            toUnmodifiableSet.
         */

        var resultado2 =
                misLibros.stream()
                        .filter(x -> x.getAnioDePublicacion() < 2000)
                        .collect(Collectors.toSet());
        System.out.println(resultado2 + "\n");

        /*
            La función toCollection retorna un
            objeto que implementa toSet o toList.
            toCollection recibe como parámetro un objeto que
            implemente la interfaz collectionSupplier.
        */

        var resultado3 =
                misLibros.stream()
                        .filter(x -> x.getTitulo().contains("Los"))
                        .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(resultado3 + "\n");

         /*
            La función toMap retorna un objeto mapa.
            La misma tiene 3 distintas versiones:
            La primera tiene de parámetros: Function, Function, U;
            la segunda tiene de parámetros: Function, Function, BinaryOperator;
            y, la tercera tiene de parámetros:
            Function, Function, BinaryOperator y Supplier.
         */

         /*
            Para el primer método se le indica
            una llave y un valor que guardará
            dicha llave. (Para este caso,
            la llave será el id del libro y
            el valor será el libro).
         */

        var resultado4 =
                misLibros.stream()
                        .distinct()
                        //Function.identity() = x -> x
                        .collect(Collectors.toMap(Libro::getId, Function.identity()));
        System.out.println(resultado4.get("345-89") + "\n");

         /*
            Otra posible solución para los libros con
            una id repetida es la siguiente.
         */

        var resultado5 =
                misLibros.stream()
                        .collect(Collectors.toMap(Libro::getId, Function.identity(), (x, y) -> x));
        System.out.println(resultado5.get("978-25") + "\n");

        var resultado6 =
                misLibros.stream()
                        .collect(Collectors.toMap(Libro::getId, Function.identity(), (x, y) -> x, TreeMap::new));
        System.out.println(resultado6.get("345-89") + "\n");

         /*
            No existe ningún método en Collects
            Para la recolección hacia un Array;
            en su lugar, se utiliza el método
            toArray de la clase Object.
         */

        var resultado7 =
                misLibros.stream()
                        .filter(x -> x.getAnioDePublicacion() > 2000)
                        .distinct()
                        .toArray(Libro[]::new);
        Arrays.stream(resultado7)
                .forEach(System.out::print);

        /*
            La función joining permite
            recolectar hacia un String.
         */

        var resultado8 =
                misLibros.stream()
                .distinct()
                .map(Libro::getTitulo)
                .collect(Collectors.joining(", "));
        System.out.println(resultado8 + "\n");

         /*
            La clase Collectors también dispone de una
            serie de métodos estáticos que retornan
            recolectores parecidos a la operación
            de reducción.
         */

    }

    public static void main(String[] args) {
        new Coleccionador();
    }
}
