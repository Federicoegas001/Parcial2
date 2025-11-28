package org.example.vistas;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import org.example.DAO.implementacionesDAO.Mysql.MascotaDAOMySqlImpl;
import org.example.DAO.implementacionesDAO.h2.MascotaDAOH2Impl;
import org.example.entidades.Mascota;
import org.example.utlis.config.CambiarVentana;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registrar_Mascota {
    private JTextField nombre_registro_mascota;
    private JTextField peso_registro_mascota;
    private JTextField especie_registro_mascota;
    private JTextField recomendaciones_registro_mascota;
    private JButton boton_registrar_mascotas;
    private JPanel registrar_mascota;
    private JPanel panelFecha;
    private JButton volverButton;

    // Declaramos el calendario como propiedad de la clase
    private JDateChooser dateChooser;

    public Registrar_Mascota() {
        crearSelectorDeFecha();

        boton_registrar_mascotas.addActionListener(e -> {
            guardarMascota();
        });
        boton_registrar_mascotas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == boton_registrar_mascotas){
                    //con H2
//                    MascotaDAOH2Impl mascotaDAOH2 = new MascotaDAOH2Impl();

                    //Con Mysql
                    MascotaDAOMySqlImpl mascotaDAOMySql = new MascotaDAOMySqlImpl();
                    try {
                        mascotaDAOMySql.registrarMascota(new Mascota(nombre_registro_mascota.getText(), dateChooser.getDate(), Float.parseFloat(peso_registro_mascota.getText()), recomendaciones_registro_mascota.getText(), especie_registro_mascota.getText()));
                        JOptionPane.showMessageDialog(null,"Mascota registrada con exito");
                        CambiarVentana cambiarVentana = new CambiarVentana();
                        cambiarVentana.cambiarVentana(boton_registrar_mascotas, new MenuPrincipal().getMenuPrincipal(), "Menu Principal");
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
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
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Nueva Vista"); // Título de la ventana
        frame.setContentPane(new Registrar_Mascota().registrar_mascota); // CAMBIA 'MenuPrincipal' por tu clase destino
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    private void crearSelectorDeFecha() {
        // 1. Instanciamos el calendario
        dateChooser = new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd"); // Formato visual

        // 2. Configuramos el panelFecha para que el calendario ocupe todo el espacio
        panelFecha.setLayout(new BorderLayout());

        // 3. Agregamos el calendario al panel
        panelFecha.add(dateChooser, BorderLayout.CENTER);

        // 4. Refrescamos el panel para que se vea
        panelFecha.validate();
    }

    private void guardarMascota() {
        // Cómo obtener la fecha:
        Date fechaSeleccionada = dateChooser.getDate();

        if (fechaSeleccionada == null) {
            JOptionPane.showMessageDialog(null, "Por favor selecciona una fecha de nacimiento.");
            return;
        }


        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String fechaTexto = sdf.format(fechaSeleccionada);




    }

    // Método para exponer el panel principal (necesario para el frame)
    public JPanel getPanelPrincipal() {
        return registrar_mascota;
    }

    public JPanel getRegistrar_Mascota() {
        return registrar_mascota;
    }
}
