package org.example.DAO.implementacionesDAO.h2;

import org.example.entidades.Mascota;
import org.example.DAO.MascotaDAO;
import org.example.utlis.config.ConexionH2;

import java.sql.*;

public class MascotaDAOH2Impl implements MascotaDAO {

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        ConexionH2 conexionH2 = new ConexionH2();
        Connection con = conexionH2.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `mascota` (`nombre`, `fecha_nacimiento`, `peso`, `especie`, `recomendaciones`) VALUES (?, ?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            java.sql.Date fechaSql = new java.sql.Date(mascota.getFechaNacimiento().getTime());
            stmt.setString(1, mascota.getNombre());
            stmt.setDate(2, fechaSql);
            stmt.setFloat(3,mascota.getPeso());
            stmt.setString(4,mascota.getEspecie());
            stmt.setString(5,mascota.getRecomendaciones());
            stmt.executeUpdate();
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                int idGenerado = generatedKey.getInt(1);
                mascota.setId(idGenerado);
            }
            generatedKey.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return mascota;
    }
}
