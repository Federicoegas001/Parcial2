package org.example.vistas;

import org.example.utlis.config.CambiarVentana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal {
    private JButton Registrar_adoptante_MenuPrincipal;
    private JButton registrar_mascota_MenuPrincipal;
    private JButton registrar_adopcion_MenuPrincipal;
    private JPanel MenuPrincipal;

    public MenuPrincipal() {
        Registrar_adoptante_MenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == Registrar_adoptante_MenuPrincipal){
                    CambiarVentana cambiarVentana = new CambiarVentana();
                    cambiarVentana.cambiarVentana(Registrar_adoptante_MenuPrincipal, new Registro_Adoptante().getRegistro_adoptante(), "Registro Adoptante");
                }
            }
        });
        registrar_mascota_MenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarVentana cambiarVentana = new CambiarVentana();
                cambiarVentana.cambiarVentana(registrar_mascota_MenuPrincipal, new Registrar_Mascota().getRegistrar_Mascota(), "Registrar Mascota");
            }
        });
        registrar_adopcion_MenuPrincipal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CambiarVentana cambiarVentana = new CambiarVentana();
                cambiarVentana.cambiarVentana(registrar_mascota_MenuPrincipal, new Registrar_adopcion().getRegistro_adopcion(), "Registrar Mascota");
            }
        });

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Nueva Vista"); // Título de la ventana
        frame.setContentPane(new MenuPrincipal().MenuPrincipal); // CAMBIA 'MenuPrincipal' por tu clase destino
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public JPanel getMenuPrincipal() {
        return MenuPrincipal;
    }
}
