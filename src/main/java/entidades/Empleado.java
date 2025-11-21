package entidades;

public class Empleado {
    private static Empleado instancia;
    private String nombre;

    private Empleado(String nombre){
        this.nombre = nombre;
    }

    Empleado getInstancia(String nombre) throws Exception {
        if (this.instancia == null){
            instancia = new Empleado(nombre);
        }
        return instancia;
    }
}
