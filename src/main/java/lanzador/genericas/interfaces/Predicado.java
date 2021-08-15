package lanzador.genericas.interfaces;

public interface Predicado<T> {

    boolean test(T valor);
}
