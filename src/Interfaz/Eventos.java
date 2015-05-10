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

    public Eventos(final MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;

        menuPrincipal.buttonSaveFiles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.showSaveDialog(menuPrincipal);
                        String url = String.valueOf(jFileChooser.getSelectedFile());
                        if (!url.equals("null")){
                            menuPrincipal.textFieldSaveFiles.setText(url);
                        }
                    }
                }
        );
        menuPrincipal.buttonLoadFiles.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jFileChooser = new JFileChooser();
                        jFileChooser.showOpenDialog(menuPrincipal);
                        String url = String.valueOf(jFileChooser.getSelectedFile());
                        menuPrincipal.textFieldLoadFiles.setText(url);

                    }
                }
        );

        menuPrincipal.buttonGenerate.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        generarPrueba();
                    }
                }
        );

        menuPrincipal.buttonStart.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String url = menuPrincipal.textFieldLoadFiles.getText();
                        if (menuPrincipal.radioButtonComiteExaust.isSelected()){
                            ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(url);
                            menuPrincipal.textAreaNaive.setText(genMonitores(monitors, 1));
                        }else if (menuPrincipal.radioButtonComiteSmart.isSelected()){
                            ArrayList<Monitor> monitors = new CargaArchivos().cargarMonitores(url);
                            menuPrincipal.textAreaSmart.setText(genMonitores(monitors, 2));
                        }else if (menuPrincipal.radioButtonProcExaust.isSelected()){
                            ArrayList<Proceso> procesos = new CargaArchivos().cargaProcesos(url);
                            menuPrincipal.textAreaNaive.setText(genProcesos(procesos, 1));
                        }else if (menuPrincipal.radioButtonProcSmart.isSelected()){
                            ArrayList<Proceso> procesos = new CargaArchivos().cargaProcesos(url);
                            menuPrincipal.textAreaSmart.setText(genProcesos(procesos, 2));
                        }
                    }
                }
        );
    }

    //Metodo encargado de llamar a la clase GeneradorPruebas y hacer las respectivas pruebas
    public void generarPrueba(){
        int type = 2;
        if (menuPrincipal.radioButtonComiteExaust.isSelected() ||
                menuPrincipal.radioButtonComiteSmart.isSelected()){
            type = 1;
        }
        int distribucion = 2;
        if (menuPrincipal.radioButtonDistUni.isSelected()){
            distribucion = 1;
        }
        String url = menuPrincipal.textFieldSaveFiles.getText();
        int tamano = Integer.parseInt(menuPrincipal.spinnerNumDistri.getValue().toString());
        GeneradorPruebas generadorPruebas = new GeneradorPruebas();
        if (type == 1){//Hace referencia a las pruebas de los monitores
            generadorPruebas.pruebasMonitores(distribucion,tamano,url);
        }else {//Hace referencia a las pruebas del procesador
            generadorPruebas.pruebasProcesador(distribucion,tamano,url);
        }
    }

    //Metodo encargado de hace uso de los algoritmos ingenuos y inteligentes del comite de supervision
    public String genMonitores(ArrayList<Monitor> monitors, int type){
        String mensaje = "";
        long start = System.currentTimeMillis();
        ArrayList<Monitor> comite;
        String tipoAlgoritmo;
        if (type == 1){//Hace referencia al algoritmo ingenuo
            comite = new ComiteIngenuo(monitors).generarComiteIngenua();
            tipoAlgoritmo = "Ingenuo";
        }else {//Hace referencia al algoritmo inteligente
            comite = new ComiteInteligente(monitors).generarComiteSmart();
            tipoAlgoritmo = "Inteligente";
        }
        long end = System.currentTimeMillis();
        mensaje += "Numero de personas del comite: " + comite.size() + "\n";

        mensaje += "Tiempo Algoritmo " + tipoAlgoritmo + ": " +  ((end - start) / (double) 1000) + " s\n";
        for (int i = 0; i < comite.size(); i++) {
            mensaje += comite.get(i).getNombre() + "\n";
        }
        return mensaje;
    }

    //Metodo encargado de hace uso de los algoritmos ingenuos y inteligentes del comite de supervision
    public String genProcesos(ArrayList<Proceso> procesos, int type){
        String mensaje = "";
        long start = System.currentTimeMillis();
        ArrayList<Proceso> procesador;
        String tipoAlgoritmo;
        if (type == 1){//Hace referencia al algoritmo ingenuo
            procesador = new ProcesadorIngenuo(procesos).generaProcesosIngenua();
            tipoAlgoritmo = "Ingenuo";
        }else {//Hace referencia al algoritmo inteligente
            procesador = new ProcesadorInteligente(procesos).generarProcesosSmart();
            tipoAlgoritmo = "Inteligente";
        }
        long end = System.currentTimeMillis();
        mensaje += "Numero de Tareas a realizar: " + procesador.size() + "\n";
        mensaje += "Tiempo Algoritmo " + tipoAlgoritmo + ": " + ((end - start) / (double) 1000) + " s\n";
        for (int i = 0; i < procesador.size(); i++) {
            mensaje += procesador.get(i).getTarea() + "\n";
        }
        return mensaje;
    }

}