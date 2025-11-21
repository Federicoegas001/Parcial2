package entidades;

import java.util.Date;

public class Perro extends Mascota{
    public Perro(String nombre, Date fechaNacieminto, float peso ) {
        super(nombre, fechaNacieminto, peso);
    }

    @Override
    Mascota getEspecie() {
        return this;
    }


}
