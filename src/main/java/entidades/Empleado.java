package entidades;

public class Empleado {
    private int id;
    private static Empleado instancia;
    private String nombre;
    private String cargo = "empleado";

    public Empleado(String nombre){
        this.id = 0;
        this.nombre = nombre;
    }

    public static Empleado getInstancia(String nombre) throws Exception {
        if (instancia == null){
            instancia = new Empleado(nombre);
        }
        return instancia;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCargo(){
        return this.cargo;
    }
}
