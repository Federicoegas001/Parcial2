import org.example.entidades.Adoptante;
import org.example.entidades.Empleado;
import org.example.entidades.Mascota;
import org.example.entidades.Perro;
import org.example.DAO.implementacionesDAO.h2.AdopcionDAOH2impl;
import org.example.DAO.implementacionesDAO.h2.AdoptanteDAOH2Impl;
import org.example.DAO.implementacionesDAO.h2.EmpleadoDAOH2Impl;
import org.example.DAO.implementacionesDAO.h2.MascotaDAOH2Impl;
import org.example.utlis.config.ConexionH2;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Date;

public class PruebasH2 {
    @DisplayName("Creando base h2")
    @Test
    public void creandoBaseH2(){
        ConexionH2 conexionH2 = new ConexionH2();
        conexionH2.conectar();
    }

    @DisplayName("Registrando mascota en DB h2")
    @Test
    public void registrandoMascotaEnDBH2(){
        Perro perro = new Perro("otra perro", new Date(2000-12-12), 50, "Darle de comer");
        MascotaDAOH2Impl mascotaDAO = new MascotaDAOH2Impl();
        mascotaDAO.registrarMascota(perro);

    }

    @DisplayName("Registrando Empleado en DB h2")
    @Test
    public void registrandoEmpleandoEnDBh2(){
        ConexionH2 conexionH2 = new ConexionH2();
        conexionH2.conectar();
        Empleado empleado = new Empleado("fede" , "dsadsadsa","12314515");
        EmpleadoDAOH2Impl empleadoDAOH2 = EmpleadoDAOH2Impl.getInstance();
        empleadoDAOH2.registrarEmpleado(empleado);
    }

    @DisplayName("Registrando Adoptante en DB h2")
    @Test
    public void registrandoAdoptanteEnDBh2(){
        Adoptante adoptante = new Adoptante("adoptante1", 22, "san telmo" );
        AdoptanteDAOH2Impl adoptanteDAOH2 = new AdoptanteDAOH2Impl();
        adoptanteDAOH2.registrarAdoptante(adoptante);
    }

    @DisplayName("Registrando Adopcion en DB h2")
    @Test
    public void registrandoAdopcionEnDBh2(){
        Mascota mascota = new Mascota();
        Adoptante adoptante = new Adoptante();
        Empleado empleado = new Empleado();


        mascota.setId(10);
        adoptante.setId(10);
        empleado.setId(16);



        AdopcionDAOH2impl adopcionDAOH2impl = new AdopcionDAOH2impl();
        adopcionDAOH2impl.registrarAdopcion(mascota, adoptante, empleado);
    }

    @DisplayName("Iniciando sesion")
    @Test
    public void iniciandoSesionH2() throws Exception {
        EmpleadoDAOH2Impl empleadoDAOH2 = EmpleadoDAOH2Impl.getInstance();
        Empleado empleado = new Empleado("dsadsa", "dsadsada");
        empleadoDAOH2.iniciarSesion(empleado);
    }

    @DisplayName("Iniciando sesion ")
    @Test
    public void iniciandoSesion(){
        EmpleadoDAOH2Impl empleadoDAOH2 = EmpleadoDAOH2Impl.getInstance();
        empleadoDAOH2.iniciarSesion(new Empleado("user", "root"));
    }
}
