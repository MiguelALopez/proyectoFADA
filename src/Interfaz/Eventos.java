/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 02-may-2015
 * Nombre del Archivo: Eventos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Interfaz;

import Implementacion.CargaArchivos;
import Implementacion.Comite;
import Implementacion.Monitor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Eventos {
    private MenuPrincipal menuPrincipal;
    private Comite comite;

    public Eventos(final MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
//        this.comite = comite;

        menuPrincipal.buttonLoadFiles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //Creo un JfileChooser para obtener el fichero
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.showOpenDialog(menuPrincipal);
                        String url = String.valueOf(jFileChooser.getSelectedFile());
                        if (!url.equals("null")){// Se comprueba que no sea una url vacia
                            ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(jFileChooser.getSelectedFile());
                            for (Monitor monitor : monitors) {
                                System.out.println(monitor.getNombre() + " " +
                                        monitor.getDia() + " " +
                                        monitor.getHoraInicio() + " " +
                                        monitor.getHoraFin());
                            }
                            comite = new Comite();
                            comite.setMonitors(monitors);
                            ArrayList<Monitor> com = comite.generarComiteIngenua();
                            String mensaje = "Numero de personas en el comite";
                            mensaje+= com.size() + "\n";
                            for (int i = 0; i < com.size(); i++) {
                                mensaje += com.get(i).getNombre() + "\n";
                            }
                            JOptionPane.showMessageDialog(null, mensaje);
                        }
                    }
                }
        );
    }
}
