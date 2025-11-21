import entidades.Perro;
import org.example.implementacionesDAO.EmpleadoDAOImpl;
import org.example.utlis.config.Conexion;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

public class Pruebas {
    @DisplayName("Creando mascota")
    @Test
    public void main() {
        Perro perro = new Perro("fede", new Date(2000-12-12), 20, "darle de comer muchas veces");
        System.out.print(perro.getEspecie());
    }


    @DisplayName("Conectando a la DB")
    @Test
    public void ConectandoALaDB(){
        Conexion conexion = new Conexion();
        conexion.conectar();
    }


    @DisplayName("Registrando la mascota a la base de datos")
    @Test
    public void RegistrandoMascotaADB(){
        Perro perro = new Perro("fede", new Date(2000-12-12), 20, "darle de comer muchas veces");
        EmpleadoDAOImpl empleadoDAO = new EmpleadoDAOImpl();
        empleadoDAO.registrarMascota(perro);
    }

}
