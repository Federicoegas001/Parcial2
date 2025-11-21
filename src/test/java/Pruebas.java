import entidades.Perro;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

public class Pruebas {
    @DisplayName("Creando mascota")
    @Test
    public void main() {
        Perro perro = new Perro("fede", new Date(2000-12-12), 20);
    }


}
