package org.example.vistas;

import org.example.DAO.implementacionesDAO.Mysql.EmpleadoDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.h2.EmpleadoDAOH2Impl;
import org.example.entidades.Empleado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {
    private JLabel registrarse;
    private JTextField usuario;
    private JPasswordField clave;
    private JButton button1;
    private JPanel Login;

    public Login() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == button1){

                    //h2
//                    EmpleadoDAOH2Impl empleadoDAOH2 = EmpleadoDAOH2Impl.getInstance();

                    //mysql
                    EmpleadoDAOMySqlImpl empleadoDAOMySql = EmpleadoDAOMySqlImpl.getInstance();
                    try {
                        String usuariotxt = usuario.getText();
                        String clavetxt = clave.getText();


                        boolean usuarioEncontrado = empleadoDAOMySql.iniciarSesion(new Empleado(usuariotxt, clavetxt));
                        if (usuarioEncontrado){
                            JFrame frame = new JFrame("Login");
                            // Asegúrate que el método getLogin() o el campo Login sean públicos en tu clase Login
                            frame.setContentPane(new MenuPrincipal().getMenuPrincipal());
                            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame.pack();
                            frame.setLocationRelativeTo(null);
                            frame.setVisible(true);
                            SwingUtilities.getWindowAncestor((java.awt.Component) e.getSource()).dispose();
                        }else {
                            JOptionPane.showMessageDialog(null,
                                    "Usuario o contraseña incorrectos.",
                                    "Error de Login",
                                    JOptionPane.ERROR_MESSAGE);

                            // Opcional: Limpiar el campo de contraseña
                            clave.setText("");
                        }



                    } catch (Exception ex) {
                        throw new RuntimeException(ex.getMessage());
                    }
                }
            }
        });
        registrarse.setForeground(Color.blue);
        registrarse.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        registrarse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFrame frame = new JFrame("Nueva Vista"); // Título de la ventana
                frame.setContentPane(new Registro().getRegistro()); // CAMBIA 'MenuPrincipal' por tu clase destino
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                // --- PARTE B: CERRAR EL LOGIN ACTUAL ---
                // Obtenemos el componente que fue clickeado (el label)
                java.awt.Component componente = e.getComponent();
                // Buscamos la ventana padre de ese componente y la cerramos
                SwingUtilities.getWindowAncestor(componente).dispose();
            }
        });


    }

    public static void main(String[] args) {
        // 1. Creamos la ventana (el marco)
        JFrame frame = new JFrame("Login");

        // 2. Conectamos tu diseño al marco
        // "new Login()" crea tu clase, y ".panelPrincipal" agarra todo el diseño
        frame.setContentPane(new Login().Login);

        // 3. Configuración básica de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack(); // Ajusta el tamaño a tus componentes
        frame.setResizable(false);
        frame.setLocationRelativeTo(null); // Centra en la pantalla
        frame.setVisible(true); // ¡Muestra la ventana!

        }

    public JPanel getLogin() {
        return Login;
    }
}
