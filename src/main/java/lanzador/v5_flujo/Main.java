package lanzador.v5_flujo;

import lanzador.v5_flujo.interfaces.*;

import java.util.List;


public class Main {

        /*

    ¿QUÉ HACER?

    1.- Crear lista de enteros
    2.- Filtrar pares
    3a.- Pasar los pares al cuadrado
    3b.- Pasar los números a String
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


        var predicado = new Predicado<Integer>(){
            @Override
            public boolean test(Integer valor) {
                return valor % 2 == 0;
            }
        };

        var funcion = new Funcion<Integer, Integer>(){
            @Override
            public Integer aplicar(Integer valor) {
                return (int) Math.pow(valor, 2);
            }
        };

        /*

        var funcion2 = new Funcion<Integer, String>() {
            @Override
            public String aplicar(Integer valor) {
                return "Valor: " + String.valueOf(valor);
            }
        };

         */

        var consumidor = new Consumidor<Integer>(){
            @Override
            public void aceptar(Integer valor) {
                System.out.println(valor);
            }
        };

        var operadorBinario = new OperadorBinario<Integer>(){
            @Override
            public Integer aplicar(Integer valor1, Integer valor2) {
                return valor1 + valor2;
            }
        };

        System.out.println("El total es: " +
                Flujo.proveer(10, proveedor)
                        .filtrar(predicado)
                        .transformar(funcion)
                        .actuar(consumidor)
                        .reducir(0, operadorBinario));

        new Flujo<>(List.of(1,2,3,4,5,6,7,8,9,10))
                .filtrar(predicado)
                .transformar(funcion)
                .consumir(consumidor);
    }
}
