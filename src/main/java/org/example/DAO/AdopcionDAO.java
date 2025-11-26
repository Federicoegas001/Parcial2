package org.example.DAO;

import org.example.entidades.Adopcion;
import org.example.entidades.Adoptante;
import org.example.entidades.Empleado;
import org.example.entidades.Mascota;

public interface AdopcionDAO {
    Adopcion registrarAdopcion(Mascota mascota, Adoptante adoptante, Empleado empleado);
}
