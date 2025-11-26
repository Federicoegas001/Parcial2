package org.example.entidades;

public class Adoptante {
    private int id;
    private String nombre;
    private int edad;
    private String direccion;

    public Adoptante(String nombre, int edad, String direccion){
        this.id = 0;
        this.nombre = nombre;
        this.edad = edad;
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
    public String getDireccion(){
        return this.direccion;
  }
}
