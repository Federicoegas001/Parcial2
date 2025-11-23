package org.example.implementacionesDAO.h2;

import entidades.Adopcion;
import entidades.Adoptante;
import entidades.Empleado;
import entidades.Mascota;
import org.example.DAO.AdopcionDAO;
import org.example.utlis.config.ConexionH2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdopcionDAOH2impl implements AdopcionDAO {
    @Override
    public Adopcion registrarAdopcion(Mascota mascota, Adoptante adoptante, Empleado empleado) {
        ConexionH2 conexionH2 = new ConexionH2();
        Connection con = conexionH2.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `adopcion` (`id_mascota`, `id_adoptante`, `id_empleado`) VALUES ( ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, 1);
            stmt.setInt(2, 1);
            stmt.setInt(3, 1);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
