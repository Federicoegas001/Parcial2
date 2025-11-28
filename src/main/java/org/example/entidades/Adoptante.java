package org.example.entidades;

public class Adoptante {
    private int id;
    private String nombre;
    private int edad;
    private String direccion;

    public Adoptante(String nombre, int edad, String direccion){
        this.id = 0;
        this.nombre = nombre;
        setEdad(edad);
        this.direccion = direccion;
    }

    public Adoptante(){}

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getEdad(){
        return this.edad;
    }

    public void setEdad(int edad){
        if (this.edad > 80 || this.edad < 18){
            throw new RuntimeException("La edad debe ser entre 18 y 80");
        }
        this.edad = edad;
    }
    public String getDireccion(){
        return this.direccion;
  }
}
