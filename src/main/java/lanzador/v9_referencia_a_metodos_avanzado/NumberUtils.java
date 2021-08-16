package lanzador.v9_referencia_a_metodos_avanzado;

public class NumberUtils {

    public static int retornarAleatorio(){
        return (int) (Math.random() * 1000);
    }

    public static boolean esPar(int x){
        return x % 2 == 0;
    }

    public static boolean esImpar(int x){
        return !esPar(x);
    }

    public static boolean esPrimo(int x){
        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int elevarAlCuadrado (int x){
        return (int) Math.pow(x, 2);
    }

    public static int elevarAlCubo(int x){
        return (int) Math.pow(x, 3);
    }

    public static int sacarRaiz(int x){
        return (int) Math.pow(x, 1.0/2);
    }
}
