package progra_funcional.v12_collect;

import java.util.Objects;

public class Libro implements Comparable<Libro>{

    private final String id;
    private final String titulo;
    private final int anioDePublicacion;
    private final Genero genero;

    public Libro(String id, String titulo, int anioDePublicacion, Genero genero) {
        Objects.requireNonNull(id);
        Objects.requireNonNull(titulo);
        Objects.requireNonNull(genero);
        this.id = id;
        this.titulo = titulo;
        this.anioDePublicacion = anioDePublicacion;
        this.genero = genero;
    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnioDePublicacion() {
        return anioDePublicacion;
    }

    public Genero getGenero() {
        return genero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return anioDePublicacion == libro.anioDePublicacion && id.equals(libro.id) && titulo.equals(libro.titulo) && genero == libro.genero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, anioDePublicacion, genero);
    }

    @Override
    public String toString() {
        return "Identificador: " + id + "\n"
                + "Título: " + titulo + "\n"
                + "Año de publicación: " + anioDePublicacion + "\n"
                + "Género: " + genero + "\n";
    }

    @Override
    public int compareTo(Libro libro) {
        return titulo.compareTo(libro.titulo);
    }
}
