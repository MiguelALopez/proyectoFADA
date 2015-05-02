/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 02-may-2015
 * Nombre del Archivo: MenuPrincipal.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Interfaz;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame{

    JButton buttonLoadFiles;
    JButton buttonStart;
    JTextField textFieldLoadFiles;
    JRadioButton radioButtonComiteExaust;
    JRadioButton radioButtonComiteSmart;
    JRadioButton radioButtonProcExaust;
    JRadioButton radioButtonProcSmart;
    ButtonGroup buttonGroupChoice;

    public MenuPrincipal(){
        super("Mini Proyecto");

        //Inicializo los componentes
        buttonLoadFiles = new JButton("Examinar");
        buttonStart = new JButton("Comenzar");
        textFieldLoadFiles = new JFormattedTextField("/");
        textFieldLoadFiles.setEditable(false);
        buttonGroupChoice = new ButtonGroup();
        radioButtonComiteExaust = new JRadioButton("Comite de supervision Ingenuo", true);
        radioButtonComiteExaust.setOpaque(false);
        radioButtonComiteSmart = new JRadioButton("Comite de Supervision Inteligente");
        radioButtonComiteSmart.setOpaque(false);
        radioButtonProcExaust = new JRadioButton("Planeacion de procesador Ingenuo");
        radioButtonProcExaust.setOpaque(false);
        radioButtonProcSmart = new JRadioButton("Planeacion de procesador Inteligente");
        radioButtonProcSmart.setOpaque(false);
        buttonGroupChoice.add(radioButtonComiteExaust);
        buttonGroupChoice.add(radioButtonComiteSmart);
        buttonGroupChoice.add(radioButtonProcExaust);
        buttonGroupChoice.add(radioButtonProcSmart);

        //Se crea el JPanel con el fondo de inicio
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new GridLayout(3, 1));

        //Panel contenedor del titulo
        JPanel panelTitle = new JPanel();
        panelTitle.setOpaque(false);
        panelTitle.setLayout(new GridLayout());
        JLabel labelTitle = new JLabel("Mini Proyecto", JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 80));
        labelTitle.setForeground(Color.decode("#aed581"));
        panelTitle.add(labelTitle);

        //Panel contenedor de elementos de la mitad
        JPanel panelContenidoMedio = new JPanel();
        panelContenidoMedio.setOpaque(false);
        panelContenidoMedio.setLayout(new BorderLayout());

        //Panel contenedor de carga de archivos
        JPanel panelFilesContent = new JPanel(new BorderLayout(20, 20));
        panelFilesContent.setOpaque(false);
        panelFilesContent.add(new JLabel("      "), BorderLayout.WEST);
        panelFilesContent.add(textFieldLoadFiles, BorderLayout.CENTER);
        JPanel panelButton = new JPanel(new BorderLayout());
        panelButton.setOpaque(false);
        panelButton.add(buttonLoadFiles, BorderLayout.CENTER);
        panelButton.add(new JLabel("    "), BorderLayout.EAST);
        panelFilesContent.add(panelButton, BorderLayout.EAST);


        //Panel contenedor de radioButton y buttonStart
        JPanel panelOpciones = new JPanel(new BorderLayout());
        panelOpciones.setOpaque(false);

        //Panel contenedor de radioButton
        JPanel panelRadioButton = new JPanel(new GridLayout(4, 1, 0, 0));
        panelRadioButton.setOpaque(false);
        panelRadioButton.add(radioButtonComiteExaust);
        panelRadioButton.add(radioButtonComiteSmart);
        panelRadioButton.add(radioButtonProcExaust);
        panelRadioButton.add(radioButtonProcSmart);

        //Panel contenedor de buttonStart
        JPanel panelStart = new JPanel(new FlowLayout());
        panelStart.setOpaque(false);
        panelStart.add(buttonStart);

        //Añade los radioButton y el buttonStart a el contenedor
        panelOpciones.add(new JLabel("           "),BorderLayout.WEST);
        panelOpciones.add(panelRadioButton, BorderLayout.CENTER);
        panelOpciones.add(panelStart, BorderLayout.SOUTH);

        //Añade el buscador de archivos y lao opciones de busqueda al contenedor del centro
        panelContenidoMedio.add(panelFilesContent, BorderLayout.NORTH);
        panelContenidoMedio.add(panelOpciones, BorderLayout.WEST);

        //Añade el titulo y las opciones del centro a la ventana principal
        panelPrincipal.add(panelTitle, BorderLayout.NORTH);
        panelPrincipal.add(panelContenidoMedio, BorderLayout.CENTER);
        add(panelPrincipal);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);
    }
}
