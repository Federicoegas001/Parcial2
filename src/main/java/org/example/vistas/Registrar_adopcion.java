package org.example.vistas;

import org.example.DAO.implementacionesDAO.h2.AdopcionDAOH2impl;
import org.example.entidades.Adoptante;
import org.example.entidades.Empleado;
import org.example.entidades.Mascota;
import org.example.utlis.config.CambiarVentana;
import org.example.utlis.config.ConexionH2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Registrar_adopcion {
    private JButton boton_adopcion;
    private  JTable mascotas;
    private JTable adoptantes;
    private JTable empleados;
    private JPanel registro_adopcion;
    private JButton volverButton;

    public Registrar_adopcion() {
        boton_adopcion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaMascota = mascotas.getSelectedRow();
                int filaAdoptante = adoptantes.getSelectedRow();
                int filaEmpleado = empleados.getSelectedRow();
                if (filaMascota == -1 || filaAdoptante == -1 || filaEmpleado == -1) {
                    JOptionPane.showMessageDialog(null, "Por favor, selecciona una Mascota, un Adoptante y un Empleado.");
                    return; // Cortamos la ejecución aquí
                }


                try {
                    int idMascota = Integer.parseInt(mascotas.getValueAt(filaMascota, 0).toString());
                    int idAdoptante = Integer.parseInt(adoptantes.getValueAt(filaAdoptante, 0).toString());
                    int idEmpleado = Integer.parseInt(empleados.getValueAt(filaEmpleado, 0).toString());

                    Mascota mascota = new Mascota();
                    mascota.setId(idMascota);

                    Adoptante adoptante = new Adoptante();
                    adoptante.setId(idAdoptante);

                    Empleado empleado = new Empleado();
                    empleado.setId(idEmpleado);

                    // 3. LLAMAR AL DAO
                    AdopcionDAOH2impl adopcionDAOH2impl = new AdopcionDAOH2impl();
                    adopcionDAOH2impl.registrarAdopcion(mascota, adoptante, empleado);

                    JOptionPane.showMessageDialog(null, "Adopcion registrada con exito");
                } catch (HeadlessException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });
        volverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarVentana cambiarVentana = new CambiarVentana();
                cambiarVentana.cambiarVentana(volverButton, new MenuPrincipal().getMenuPrincipal(), "Menu Principal");
            }
        });
        llenarTabla(mascotas, "SELECT * FROM mascota");
        llenarTabla(adoptantes, "SELECT * FROM adoptante");
        llenarTabla(empleados, "SELECT * FROM empleado");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nueva Vista"); // Título de la ventana
        Registrar_adopcion pantalla = new Registrar_adopcion();
        frame.setContentPane(pantalla.registro_adopcion); // CAMBIA 'MenuPrincipal' por tu clase destino
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
        }

    public JPanel getRegistro_adopcion() {
        return registro_adopcion;
    }

    private void llenarTabla(JTable jtable, String sql){
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };



        try {
            jtable.setModel(modelo);
            ConexionH2 conexionH2 = new ConexionH2();
            Connection con = conexionH2.conectar();
            PreparedStatement stmt;
            stmt = con.prepareStatement(sql);
            java.sql.ResultSet rs = stmt.executeQuery();
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();

                for ( int i = 1; i <= columnCount; i++ ) {
                    modelo.addColumn(metaData.getColumnName(i));
                }


            while (rs.next()) {
                Object[] fila = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    fila[i - 1] = rs.getObject(i);
                }
                modelo.addRow(fila);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
