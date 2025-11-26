package org.example.vistas;

import org.example.DAO.implementacionesDAO.h2.EmpleadoDAOH2Impl;
import org.example.entidades.Empleado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    private JTextField name_registro;
    private JTextField user_registro;
    private JPasswordField pass_registro;
    private JPasswordField pass2_registro;
    private JButton button1;
    private JPanel registro;
    private JLabel nombre_registro;
    private JLabel usuario_registro;
    private JLabel clave_registro;
    private JLabel repetir_clave_registro;

    public Registro() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EmpleadoDAOH2Impl empleadoDAOH2 = EmpleadoDAOH2Impl.getInstance();
                try {
                    empleadoDAOH2.registrarEmpleado(new Empleado(name_registro.getText(), user_registro.getText(), pass_registro.getText()));
                    JOptionPane.showMessageDialog(null, "Registro exitoso");
                    JFrame frame = new JFrame("Login");
                    // Asegúrate que el método getLogin() o el campo Login sean públicos en tu clase Login
                    frame.setContentPane(new Login().getLogin());
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                    SwingUtilities.getWindowAncestor((java.awt.Component) e.getSource()).dispose();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }



            }
        });


    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nueva Vista"); // Título de la ventana
        frame.setContentPane(new Registro().registro); // CAMBIA 'MenuPrincipal' por tu clase destino
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getRegistro() {
        return registro;
    }
}
