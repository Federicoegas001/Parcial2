package org.example.implementacionesDAO.Mysql;

import entidades.Adoptante;
import org.example.DAO.AdoptanteDAO;
import org.example.utlis.config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdoptanteDAOMySqlImpl implements AdoptanteDAO {

    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    PreparedStatement stmt;

    @Override
    public Adoptante registrarAdoptante(Adoptante adoptante) {
        String sql = "INSERT INTO `adoptante` (`nombre`, `edad`, `direccion`) VALUES (?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,adoptante.getNombre());
            stmt.setInt(2,adoptante.getEdad());
            stmt.setString(3,adoptante.getDireccion());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
