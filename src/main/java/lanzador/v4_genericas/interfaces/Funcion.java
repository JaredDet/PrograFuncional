package lanzador.v4_genericas.interfaces;

public interface Funcion<T, R> {

    R aplicar(T valor);
}
