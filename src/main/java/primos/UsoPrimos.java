package primos;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class UsoPrimos {

    public static void main(String[] args) {
        var resultado = generarPrimos();
        System.out.println(resultado);
        System.out.println(descomponerEnFactoresPrimos(3000));
    }

    public static List<Integer> descomponerEnFactoresPrimos(int numero) {

        var resultado = construirFactoresPrimos(numero);
        var identidad = 1;

        for (var x : resultado) {
            identidad *= x;
        }

        if (identidad != numero) {
            var respuesta = descomponerEnFactoresPrimos(numero / identidad);
            resultado.addAll(respuesta);
        }
        return resultado.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> construirFactoresPrimos(int numero) {

        return generarPrimos()
                .stream()
                .filter(x -> numero % x == 0)
                .sorted()
                .collect(Collectors.toList());
    }

    public static List<Integer> generarPrimos() {

        return new Random().ints(100, 1, 50)
                .filter(x -> x != 1)
                .filter(x -> {
                    if (x == 2) {
                        return true;
                    }
                    return x % 2 != 0;
                })
                .filter(x -> {
                    for (int i = 3; i <= (int) Math.sqrt(x); i = i + 2) {
                        if (x % i == 0) {
                            return false;
                        }
                    }
                    return true;
                })
                .boxed()
                .sorted()
                .distinct()
                .collect(Collectors.toList());
    }
}

