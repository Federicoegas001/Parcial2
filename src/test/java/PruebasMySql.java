import org.example.DAO.implementacionesDAO.Mysql.AdopcionDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.Mysql.AdoptanteDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.Mysql.EmpleadoDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.Mysql.MascotaDAOMySqlImpl;
import org.example.entidades.Adoptante;
import org.example.entidades.Empleado;
import org.example.entidades.Perro;
import org.example.utlis.config.Conexion;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;





public class PruebasMySql {







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
        Perro perro = new Perro("otro ", new Date(2000-12-12), 20, "darle de comer muchas veces");
        MascotaDAOMySqlImpl mascotaDAO = new MascotaDAOMySqlImpl();
        mascotaDAO.registrarMascota(perro);
    }

    @DisplayName("Registrando Adoptante a la base de datos")
    @Test
    public void RegistrandoAdoptanteALaDB(){
        Adoptante adoptante = new Adoptante("hola", 25, "obelisco");
        AdoptanteDAOMySqlImpl adoptanteDAO = new AdoptanteDAOMySqlImpl();
        adoptanteDAO.registrarAdoptante(adoptante);
    }

    @DisplayName("Registrando empleado a la base de datos")
    @Test
    public void RegistrandoEmpleadoALaDB() throws Exception {

        EmpleadoDAOMySqlImpl empleadoDAO = new EmpleadoDAOMySqlImpl();
        empleadoDAO.registrarEmpleado(new Empleado("luis", "usuario", "2131321"));

    }

    @DisplayName("Registrando Adopcion a la base de datos")
    @Test
    public void RegistrandoAdopcionALaDB() throws Exception {
        Perro perro = new Perro("fede", new Date(2000-12-12), 20, "darle de comer muchas veces");
        Adoptante adoptante = new Adoptante("otranose", 25, "obelisco");
        EmpleadoDAOMySqlImpl empleadoDAO = new EmpleadoDAOMySqlImpl();

        AdopcionDAOMySqlImpl AdopcionDao = new AdopcionDAOMySqlImpl();
        AdopcionDao.registrarAdopcion(perro, adoptante, new Empleado("fernando", "user", "root"));


    }

}
