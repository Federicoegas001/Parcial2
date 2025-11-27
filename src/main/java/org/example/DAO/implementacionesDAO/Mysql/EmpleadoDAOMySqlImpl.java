package org.example.DAO.implementacionesDAO.Mysql;

import org.example.DAO.implementacionesDAO.h2.EmpleadoDAOH2Impl;
import org.example.entidades.Empleado;
import org.example.DAO.EmpleadoDAO;
import org.example.utlis.config.Conexion;
import org.example.utlis.config.ConexionH2;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAOMySqlImpl implements EmpleadoDAO {
    private static EmpleadoDAOMySqlImpl instance;

    private EmpleadoDAOMySqlImpl() {
    }
    public static EmpleadoDAOMySqlImpl getInstance() {
        if (instance == null) {
            instance = new EmpleadoDAOMySqlImpl();
        }
        return instance;
    }



    @Override
    public Empleado registrarEmpleado(Empleado empleado) {
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        PreparedStatement stmt;
        String sql = "INSERT INTO `empleado` (`nombre` , `usuario`, `clave`, `cargo`) VALUES (?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, empleado.getNombre());
            stmt.setString(2, empleado.getUsuario());
            stmt.setString(3, empleado.getClave());
            stmt.setString(4, empleado.getCargo());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public boolean iniciarSesion(Empleado empleado){
        Conexion conexion = new Conexion();
        Connection con = conexion.conectar();
        PreparedStatement stmt;
        boolean usuarioEncontrado = false;
        String sql = "SELECT * FROM EMPLEADO WHERE USUARIO = ? AND CLAVE = ?";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, empleado.getUsuario());
            stmt.setString(2, empleado.getClave());
            ResultSet resultado = stmt.executeQuery();
//            ResultSet generatedKey = stmt.getGeneratedKeys();
//            if (generatedKey.next()) {
//                int idGenerado = generatedKey.getInt(1);
//                empleado.setId(idGenerado);
//            }
            if (resultado.next()){
                usuarioEncontrado = true;
                int idReal = resultado.getInt("id");
                if (usuarioEncontrado){
                    JOptionPane.showMessageDialog(null, "Inicio de sesion exitoso");
                }
                empleado.setId(idReal);
            }
//            generatedKey.close();

            else {
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuarioEncontrado;
    }
}
