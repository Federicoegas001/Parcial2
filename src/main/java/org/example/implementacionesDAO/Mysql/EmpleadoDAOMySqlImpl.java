package org.example.implementacionesDAO.Mysql;

import entidades.Empleado;
import org.example.DAO.EmpleadoDAO;
import org.example.utlis.config.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadoDAOMySqlImpl implements EmpleadoDAO {
    Conexion conexion = new Conexion();
    Connection con = conexion.conectar();
    PreparedStatement stmt;


    @Override
    public Empleado registrarEmpleado(Empleado empleado) {
        String sql = "INSERT INTO `empleado` (`nombre`, `cargo`) VALUES (?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getCargo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
