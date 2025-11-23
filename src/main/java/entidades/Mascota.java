package entidades;

import java.util.Date;

public abstract class Mascota {
    protected int id;
    protected String nombre;
    protected Date fechaNacieminto;
    protected float peso;
    protected String recomendaciones;
    protected String especie;

    public Mascota(String nombre, Date fechaNacieminto, float peso, String recomendaciones, String especie){
        this.id = 0;
        this.nombre = nombre;
        this.fechaNacieminto = fechaNacieminto;
        this.peso = peso;
        this.recomendaciones = recomendaciones;
        this.especie = especie;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getEspecie(){
        return this.especie;
    }

    public String getRecomendaciones(){
        return this.recomendaciones;
    }

    public Date getFechaNacimiento(){
        return this.fechaNacieminto;
    }

    public String getNombre(){
        return this.nombre;
    }

    public float getPeso(){
        return this.peso;
    }
}
