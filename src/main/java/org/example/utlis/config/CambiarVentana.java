package org.example.utlis.config;

import javax.swing.*;
import java.awt.*;

public class CambiarVentana {
    public void cambiarVentana(Component botonPresionado, JPanel panelNuevo, String titulo) {
        JFrame frame = new JFrame(titulo);
        frame.setContentPane(panelNuevo);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Centrar
        frame.setVisible(true);

        // Cierra la ventana actual usando el botón que disparó el evento como referencia
        SwingUtilities.getWindowAncestor(botonPresionado).dispose();
    }
}
