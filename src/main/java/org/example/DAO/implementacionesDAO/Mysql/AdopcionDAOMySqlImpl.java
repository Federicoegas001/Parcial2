package org.example.DAO.implementacionesDAO.Mysql;

import org.example.entidades.Adopcion;
import org.example.entidades.Adoptante;
import org.example.entidades.Empleado;
import org.example.entidades.Mascota;
import org.example.DAO.AdopcionDAO;
import org.example.utlis.config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdopcionDAOMySqlImpl implements AdopcionDAO {



    @Override
    public Adopcion registrarAdopcion(Mascota mascota, Adoptante adoptante, Empleado empleado) {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `adopcion` (`adoptante_id`, `mascota_id`, `empleado_id`) VALUES ( ?, ?, ?)";

        try {
            stmt = con.prepareStatement(sql);
//            adoptante.setId(2);
//            stmt.setInt(1,adoptante.getId());
            stmt.setInt(2,mascota.getId());
            stmt.setInt(1,adoptante.getId());
            stmt.setInt(3,empleado.getId());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
