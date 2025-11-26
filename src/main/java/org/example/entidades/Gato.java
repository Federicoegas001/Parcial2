package org.example.entidades;

import java.util.Date;

public class Gato extends Mascota{
    public Gato(String nombre, Date fechaNacieminto, float peso, String recomendaciones) {
        super(nombre, fechaNacieminto, peso, recomendaciones, "gato");
    }
}
