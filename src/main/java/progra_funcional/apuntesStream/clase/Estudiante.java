package progra_funcional.apuntesStream.clase;

public class Estudiante {

    private final String nombre;
    private final int edad;

    public Estudiante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
}
