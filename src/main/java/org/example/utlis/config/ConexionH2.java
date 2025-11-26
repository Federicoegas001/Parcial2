package org.example.utlis.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionH2 {
    Connection con;

    public Connection conectar() {
         String url = "jdbc:h2:./parcial2";


        String user = "sa";
        String password = "";

        try {
            con = DriverManager.getConnection(url, user, password);
            Class.forName("org.h2.Driver");
            crearTodasLasTablas(con);
            System.out.println("Conectado con éxito a H2");

        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexión: " + e.getMessage());
            e.printStackTrace(); // Buena práctica para ver el error exacto
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    private void crearTodasLasTablas(Connection conn) {
        try {
            Statement stmt = conn.createStatement();

            // 1. TABLA MASCOTA (Independiente)
            String sqlMascota = "CREATE TABLE IF NOT EXISTS mascota (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(255), " +
                    "fecha_nacimiento DATE, " +
                    "peso DOUBLE PRECISION, " + // Cambiado a DOUBLE por lo que hablamos antes
                    "especie VARCHAR(255), " +
                    "recomendaciones VARCHAR(255)" +
                    ");";
            stmt.execute(sqlMascota);

            // 2. TABLA EMPLEADO (Independiente)
            String sqlEmpleado = "CREATE TABLE IF NOT EXISTS empleado (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(255), " +
                    "usuario VARCHAR(50), " +
                    "clave VARCHAR(50), " +
                    "cargo VARCHAR(50) " +
                    ");";
            stmt.execute(sqlEmpleado);

            // 3. TABLA ADOPTANTE (Independiente)
            String sqlAdoptante = "CREATE TABLE IF NOT EXISTS adoptante (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "nombre VARCHAR(255), " +
                    "edad INT, " +
                    "direccion VARCHAR(50)" +
                    ");";
            stmt.execute(sqlAdoptante);

            // 4. TABLA ADOPCION (Dependiente - ¡El orden importa!)
            // Esta tabla une a las otras, así que se crea AL FINAL.
            // Incluye Foreign Keys (FK) para relacionar los datos.
            String sqlAdopcion = "CREATE TABLE IF NOT EXISTS adopcion (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "id_mascota INT, " +
                    "id_adoptante INT, " +
                    "id_empleado INT, " +

                    // Definimos las relaciones (Foreign Keys)
                    "FOREIGN KEY (id_mascota) REFERENCES mascota(id), " +
                    "FOREIGN KEY (id_adoptante) REFERENCES adoptante(id), " +
                    "FOREIGN KEY (id_empleado) REFERENCES empleado(id)" +
                    ");";
            stmt.execute(sqlAdopcion);

            stmt.close();
            System.out.println("Todas las tablas verificadas/creadas correctamente.");

        } catch (SQLException e) {
            System.out.println("Error creando tablas: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
