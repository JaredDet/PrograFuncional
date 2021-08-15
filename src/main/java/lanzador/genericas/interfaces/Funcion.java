package lanzador.genericas.interfaces;

public interface Funcion<T, R> {

    R aplicar(T valor);
}
