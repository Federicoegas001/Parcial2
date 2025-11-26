package org.example.DAO.implementacionesDAO.h2;

import org.example.entidades.Empleado;
import org.example.DAO.EmpleadoDAO;
import org.example.utlis.config.ConexionH2;

import javax.swing.*;
import java.sql.*;

public class EmpleadoDAOH2Impl implements EmpleadoDAO {
    private static EmpleadoDAOH2Impl instance;

    private EmpleadoDAOH2Impl() {
    }
    public static EmpleadoDAOH2Impl getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAOH2Impl();
        }
        return instance;
    }

    @Override
    public Empleado registrarEmpleado(Empleado empleado) {

        ConexionH2 conexion = new ConexionH2();
        Connection con = conexion.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `empleado` (`nombre`, `usuario`, `clave`, `cargo`) VALUES (?,?,?,?)";
        try {
            Class.forName("org.h2.Driver");
            stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1,empleado.getNombre());
            stmt.setString(2,empleado.getUsuario());
            stmt.setString(3,empleado.getClave());
            stmt.setString(4,empleado.getCargo());
            stmt.executeUpdate();
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                int idGenerado = generatedKey.getInt(1);
                empleado.setId(idGenerado);
            }
            generatedKey.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error crítico: No se encuentra la librería H2");
            throw new RuntimeException(e);
        }
        return empleado;
    }

    public boolean iniciarSesion(Empleado empleado){
        ConexionH2 conexionH2 = new ConexionH2();
        Connection con = conexionH2.conectar();
        PreparedStatement stmt;
        boolean usuarioEncontrado = false;
        String sql = "SELECT * FROM EMPLEADO WHERE USUARIO = ? AND CLAVE = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, empleado.getUsuario());
            stmt.setString(2, empleado.getClave());
            ResultSet resultado = stmt.executeQuery();
            ResultSet generatedKey = stmt.getGeneratedKeys();
            if (generatedKey.next()) {
                int idGenerado = generatedKey.getInt(1);
                empleado.setId(idGenerado);
            }
            generatedKey.close();
            if (resultado.next()){
                usuarioEncontrado = true;
                System.out.print("usuario encontrado");
            }else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarioEncontrado;
    }
}
