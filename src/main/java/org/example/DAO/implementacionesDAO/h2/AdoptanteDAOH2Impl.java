package org.example.DAO.implementacionesDAO.h2;

import org.example.entidades.Adoptante;
import org.example.DAO.AdoptanteDAO;
import org.example.utlis.config.ConexionH2;

import java.sql.*;

public class AdoptanteDAOH2Impl implements AdoptanteDAO {



    @Override
    public Adoptante registrarAdoptante(Adoptante adoptante) {
        ConexionH2 conexionH2 = new ConexionH2();
        Connection con = conexionH2.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `adoptante` (`nombre`, `edad`, `direccion`) VALUES (?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, adoptante.getNombre());
            stmt.setInt(2,adoptante.getEdad());
            stmt.setString(3,adoptante.getDireccion());
            stmt.executeUpdate();
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                int idGenerado = generatedKey.getInt(1);
                adoptante.setId(idGenerado);
            }
            generatedKey.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adoptante;
    }
}
