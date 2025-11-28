package org.example.entidades;

public class Empleado {
    private int id;
    private static Empleado instancia;
    private String nombre;
    private String usuario;
    private String clave;
    private String cargo = "empleado";

    public Empleado(String nombre, String usuario, String clave){
        this.id = 0;
        this.nombre = nombre;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Empleado(String usuario, String clave){
        this.id = 0;
        this.usuario = usuario;
        this.clave = clave;
    }

    public Empleado(){}


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public String getCargo(){
        return this.cargo;
    }

    public String getUsuario(){
        return this.usuario;
    }

    public String getClave(){
        return this.clave;
    }
}
