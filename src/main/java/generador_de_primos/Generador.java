package generador_de_primos;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Generador {

    public static void main(String[] args) {
        var resultado = generarPrimos();
        System.out.println(resultado);
    }

    public static List<Integer> generarPrimos() {

        return new Random().ints(100, 1, 1000)
                .filter(x -> x != 1)
                .filter(x -> {
                    if(x == 2) {
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
                .collect(Collectors.toList());
    }
}

