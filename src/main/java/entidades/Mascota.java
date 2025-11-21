package entidades;

import java.util.Date;

public abstract class Mascota {
    protected String nombre;
    protected Date fechaNacieminto;
    protected float peso;

    public Mascota(String nombre, Date fechaNacieminto, float peso){
        this.nombre = nombre;
        this.fechaNacieminto = fechaNacieminto;
        this.peso = peso;
    }

    abstract Mascota getEspecie();

}
