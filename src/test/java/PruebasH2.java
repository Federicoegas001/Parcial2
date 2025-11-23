import entidades.Adoptante;
import entidades.Empleado;
import entidades.Perro;
import org.example.implementacionesDAO.h2.AdopcionDAOH2impl;
import org.example.implementacionesDAO.h2.AdoptanteDAOH2Impl;
import org.example.implementacionesDAO.h2.EmpleadoDAOH2Impl;
import org.example.implementacionesDAO.h2.MascotaDAOH2Impl;
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
        Empleado empleado = new Empleado("Facundo");
        EmpleadoDAOH2Impl empleadoDAOH2 = new EmpleadoDAOH2Impl();
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
        AdopcionDAOH2impl adopcionDAOH2impl = new AdopcionDAOH2impl();

        adopcionDAOH2impl.registrarAdopcion(null, null, null);
    }
}
