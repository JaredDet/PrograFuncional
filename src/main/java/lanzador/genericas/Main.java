package lanzador.genericas;

import lanzador.genericas.interfaces.*;

public class Main {

        /*

    ¿QUÉ HACER?

    1.- Crear lista de enteros
    2.- Filtrar pares
    3.- Pasar los pares al cuadrado
    4.- Mostrar los cuadrados
    5.- sumar los cuadrados

    PARA GENÉRICOS

     */

    public static void main(String[] args) {

        var proveedor = new Proveedor<Integer>(){
            @Override
            public Integer obtener() {
                return (int) (Math.random() * 1000);
            }
        };

        var numeros = Superfunciones.proveer(10, proveedor);
        System.out.println(numeros);

        var predicado = new Predicado<Integer>(){
            @Override
            public boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        };
        var pares = Superfunciones.filtrar(numeros, predicado);
        System.out.println(pares);

        var funcion = new Funcion<Integer, Integer>(){
            @Override
            public Integer aplicar(Integer valor) {
                return (int) Math.pow(valor, 2);
            }
        };
        var cuadrados = Superfunciones.transformar(pares, funcion);
        System.out.println(cuadrados);

        var consumidor = new Consumidor<Integer>(){
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };
        Superfunciones.consumir(cuadrados, consumidor);

        var operadorBinario = new OperadorBinario<Integer>(){
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        };

        var reducido = Superfunciones.reducir(cuadrados, 1, operadorBinario);
        System.out.println("El total es:" + reducido);
    }
}
