package org.example.implementacionesDAO.h2;

import entidades.Mascota;
import org.example.DAO.MascotaDAO;
import org.example.utlis.config.ConexionH2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MascotaDAOH2Impl implements MascotaDAO {
    ConexionH2 conexionH2 = new ConexionH2();
    Connection con = conexionH2.conectar();
    PreparedStatement stmt;
    @Override
    public Mascota registrarMascota(Mascota mascota) {
        String sql = "INSERT INTO `mascota` (`nombre`, `fecha_nacimiento`, `peso`, `especie`, `recomendaciones`) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            java.sql.Date fechaSql = new java.sql.Date(mascota.getFechaNacimiento().getTime());
            stmt.setString(1, mascota.getNombre());
            stmt.setDate(2, fechaSql);
            stmt.setFloat(3,mascota.getPeso());
            stmt.setString(4,mascota.getEspecie());
            stmt.setString(5,mascota.getRecomendaciones());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mascota;
    }
}
