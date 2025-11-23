package org.example.implementacionesDAO.h2;

import entidades.Empleado;
import org.example.DAO.EmpleadoDAO;
import org.example.utlis.config.ConexionH2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadoDAOH2Impl implements EmpleadoDAO {

    @Override
    public Empleado registrarEmpleado(Empleado empleado) {
        ConexionH2 conexion = new ConexionH2();
        Connection con = conexion.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `empleado` (`nombre`, `cargo`) VALUES (?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1,empleado.getNombre());
            stmt.setString(2,empleado.getCargo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return new Empleado(empleado.getNombre());
    }
}
