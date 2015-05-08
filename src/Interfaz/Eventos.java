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
                            File file = jFileChooser.getSelectedFile();
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
                        if (true){
                            if (menuPrincipal.radioButtonComiteExaust.isSelected()){
                                String urlLoad = menuPrincipal.textFieldLoadFiles.getText();
                                String urlSave = menuPrincipal.textFieldSaveFiles.getText();
                                int distribucion = 2;
                                if (menuPrincipal.radioButtonDistUni.isSelected()){
                                    distribucion = 1;
                                }
                                new GeneradorPruebas().pruebasMonitores(distribucion,20,urlSave);
                                ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(urlLoad);
                                ArrayList<Monitor> comite = new ComiteIngenuo(monitors).generarComiteIngenua();
                                String mensaje = "Numero de personas en el comite: ";
                                mensaje+= comite.size() + "\n";
                                for (int i = 0; i < comite.size(); i++) {
                                    mensaje += comite.get(i).getNombre() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);

                            }
                            if (menuPrincipal.radioButtonComiteSmart.isSelected()){
                                String urlLoad = menuPrincipal.textFieldLoadFiles.getText();
                                String urlSave = menuPrincipal.textFieldSaveFiles.getText();
                                int distribucion = 2;
                                if (menuPrincipal.radioButtonDistUni.isSelected()){
                                    distribucion = 1;
                                }
                                new GeneradorPruebas().pruebasMonitores(distribucion,20,urlSave);
                                ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(urlLoad);
                                ArrayList<Monitor> comite = new ComiteInteligente(monitors).generarComiteSmart();
                                String mensaje = "Numero de personas en el comite: ";
                                mensaje+= comite.size() + "\n";
                                for (int i = 0; i < comite.size(); i++) {
                                    mensaje += comite.get(i).getNombre() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                            if (menuPrincipal.radioButtonProcExaust.isSelected()){
                                String urlLoad = menuPrincipal.textFieldLoadFiles.getText();
                                String urlSave = menuPrincipal.textFieldSaveFiles.getText();
                                int distribucion = 2;
                                if (menuPrincipal.radioButtonDistUni.isSelected()){
                                    distribucion = 1;
                                }
                                new GeneradorPruebas().pruebasProcesador(distribucion, 20,urlSave);
                                ArrayList<Proceso> procesos = new CargaArchivos().cargaProcesos(urlLoad);
                                ArrayList<Proceso> procesador = new ProcesadorIngenuo(procesos).generaProcesosIngenua();
                                String mensaje = "Numero de procesos a ejecutar: ";
                                mensaje+= procesador.size() + "\n";
                                for (int i = 0; i < procesador.size(); i++) {
                                    mensaje += procesador.get(i).getTarea() + "\n";
                                }
                                JOptionPane.showMessageDialog(null, mensaje);
                            }
                            if (menuPrincipal.radioButtonProcSmart.isSelected()){
                                String urlLoad = menuPrincipal.textFieldLoadFiles.getText();
                                String urlSave = menuPrincipal.textFieldSaveFiles.getText();
                                int distribucion = 2;
                                if (menuPrincipal.radioButtonDistUni.isSelected()){
                                    distribucion = 1;
                                }
                                new GeneradorPruebas().pruebasProcesador(distribucion,20,urlSave);
                                ArrayList<Proceso> procesos = new CargaArchivos().cargaProcesos(urlLoad);
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