package org.example.implementacionesDAO.Mysql;

import entidades.Adopcion;
import entidades.Adoptante;
import entidades.Empleado;
import entidades.Mascota;
import org.example.DAO.AdopcionDAO;
import org.example.utlis.config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdopcionDAOMySqlImpl implements AdopcionDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    PreparedStatement stmt;


    @Override
    public Adopcion registrarAdopcion(Mascota mascota, Adoptante adoptante, Empleado empleado) {
        String sql = "INSERT INTO `adopcion` (`adoptante_id`, `mascota_id`, `empleado_id`) VALUES ( ?, ?, ?)";

        try {
            stmt = con.prepareStatement(sql);
//            adoptante.setId(2);
//            stmt.setInt(1,adoptante.getId());
            stmt.setInt(1,2);
            stmt.setInt(2,1);
            stmt.setInt(3,2);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
