package org.example.utlis.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;

    public Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/parcial2";
        String user = "root";
        String password = "";


        try {
            con = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado com sucesso");

        } catch (Exception e) {
            System.out.println("No se pudo establecer conexion");
        }
        return con;
    }
}