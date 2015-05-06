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

import Implementacion.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class Eventos {
    private MenuPrincipal menuPrincipal;
    private ComiteIngenuo comiteIngenuo;

    File file; //Variable que contendra el archivo que se va a tratar
    boolean cargado;

    public Eventos(final MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
        cargado = false;

        menuPrincipal.buttonLoadFiles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Creo un JfileChooser para obtener el fichero
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.showOpenDialog(menuPrincipal);
                        String url = String.valueOf(jFileChooser.getSelectedFile());
                        if (!url.equals("null")){
                            file = jFileChooser.getSelectedFile();
                            menuPrincipal.textFieldLoadFiles.setText(url);
                            cargado = true;
                        }else{
                            cargado = false;
                        }

                    }
                }
        );

        menuPrincipal.buttonStart.addActionListener(
                new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cargado){
                            if (menuPrincipal.radioButtonComiteExaust.isSelected()){
                                ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(file);
                                ArrayList<Monitor> comite = new ComiteIngenuo(monitors).generarComiteIngenua();
                                String mensaje = "Numero de personas en el comite: ";
                                mensaje+= comite.size() + "\n";
                                for (int i = 0; i < comite.size(); i++) {
                                    mensaje += comite.get(i).getNombre() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);

                            }
                            if (menuPrincipal.radioButtonComiteSmart.isSelected()){
                                ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(file);
                                ArrayList<Monitor> comite = new ComiteInteligente(monitors).generarComiteSmart();
                                String mensaje = "Numero de personas en el comite: ";
                                mensaje+= comite.size() + "\n";
                                for (int i = 0; i < comite.size(); i++) {
                                    mensaje += comite.get(i).getNombre() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                            if (menuPrincipal.radioButtonProcExaust.isSelected()){
                                ArrayList<Proceso> procesos = new CargaArchivos().cargaProcesos(file);
                                ArrayList<Proceso> procesador = new ProcesadorIngenuo(procesos).generaProcesosIngenua();
                                String mensaje = "Numero de procesos a ejecutar: ";
                                mensaje+= procesador.size() + "\n";
                                for (int i = 0; i < procesador.size(); i++) {
                                    mensaje += procesador.get(i).getTarea() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                            if (menuPrincipal.radioButtonProcSmart.isSelected()){
                                ArrayList<Proceso> procesos = new CargaArchivos().cargaProcesos(file);
                                ArrayList<Proceso> procesador = new ProcesadorInteligente(procesos).generarComiteSmart();
                                String mensaje = "Numero de procesos a ejecutar: ";
                                mensaje+= procesador.size() + "\n";
                                for (int i = 0; i < procesador.size(); i++) {
                                    mensaje += procesador.get(i).getTarea() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                        }
                    }
                }
        );
    }
}
/*if (!url.equals("null")){// Se comprueba que no sea una url vacia
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
                        }*/
                        /*ArrayList<Proceso> procesos = new ArrayList<Proceso>();
                        procesos.add(new Proceso("tarea1", 1800, 2100));
                        procesos.add(new Proceso("tarea2", 2100, 2400));
                        procesos.add(new Proceso("tarea3", 300, 1400));
                        procesos.add(new Proceso("tarea4", 1300, 1900));
                        ProcesadorIngenuo procesadorIngenuo = new ProcesadorIngenuo();
                        procesadorIngenuo.setProcesos(procesos);
                        ArrayList<Proceso> com = procesadorIngenuo.generaProcesosIngenua();
                        String mensaje = "Numero de personas en el comite";
                        mensaje+= com.size() + "\n";
                        for (int i = 0; i < com.size(); i++) {
                            mensaje += com.get(i).getTarea() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, mensaje);*/