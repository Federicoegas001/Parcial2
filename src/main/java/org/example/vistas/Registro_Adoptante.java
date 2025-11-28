package org.example.vistas;

import org.example.DAO.implementacionesDAO.Mysql.AdopcionDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.Mysql.AdoptanteDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.h2.AdoptanteDAOH2Impl;
import org.example.entidades.Adoptante;
import org.example.utlis.config.CambiarVentana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro_Adoptante {
    private JTextField nombre_registro_adoptante;
    private JTextField edad_registro_adoptante;
    private JTextField direccion_registro_adoptante;
    private JPanel registro_adoptante;
    private JButton registrar_adoptante;
    private JButton volver;

    public Registro_Adoptante() {
        registrar_adoptante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == registrar_adoptante){
                    //con h2
//                    AdoptanteDAOH2Impl adoptanteDAOH2 = new AdoptanteDAOH2Impl();

                    //con Mysql
                    AdoptanteDAOMySqlImpl adoptanteDAOMySql = new AdoptanteDAOMySqlImpl();
                    try {
                        adoptanteDAOMySql.registrarAdoptante(new Adoptante(nombre_registro_adoptante.getText(), Integer.parseInt(edad_registro_adoptante.getText()), direccion_registro_adoptante.getText()));
                        JOptionPane.showMessageDialog(null, "Registro exitoso");
                        CambiarVentana cambiarVentana = new CambiarVentana();
                        cambiarVentana.cambiarVentana(registrar_adoptante, new MenuPrincipal().getMenuPrincipal(), "Menu Principal");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        volver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarVentana cambiarVentana = new CambiarVentana();
                cambiarVentana.cambiarVentana(volver, new MenuPrincipal().getMenuPrincipal(), "Menu Principal");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nueva Vista"); // Título de la ventana
        frame.setContentPane(new Registro_Adoptante().registro_adoptante); // CAMBIA 'MenuPrincipal' por tu clase destino
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getRegistro_adoptante() {
        return registro_adoptante;
    }
}
