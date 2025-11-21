package org.example.utlis.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;

    public Connection conectar() {
        String url = "jdbc:mysql://localhost:5432/parcial2";
        String user = "postgres";
        String password = "fede";


        try {
            con = DriverManager.getConnection(url, user, password);

            System.out.println("Conectado com sucesso");

        } catch (Exception e) {
            System.out.println("No se pudo establecer conexion");
        }
        return con;
    }
}