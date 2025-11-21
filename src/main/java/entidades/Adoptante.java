package entidades;

public class Adoptante {
    private String nombre;
    private int edad;
    private String direccion;

    public Adoptante(String nombre, int edad, String direccion){
        this.nombre = nombre;
        this.edad = edad;
        this.direccion = direccion;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }
    public String getDireccion(){
        return this.direccion;
  }
}
