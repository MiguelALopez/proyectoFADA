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
import java.io.File;

public class MenuPrincipal extends JFrame{

    JButton buttonSaveFiles;
    JButton buttonLoadFiles;
    JButton buttonStart;
    JTextField textFieldSaveFiles;
    JTextField textFieldLoadFiles;
    JRadioButton radioButtonComiteExaust;
    JRadioButton radioButtonComiteSmart;
    JRadioButton radioButtonProcExaust;
    JRadioButton radioButtonProcSmart;
    ButtonGroup buttonGroupProblem;
    JRadioButton radioButtonDistUni;
    JRadioButton radioButtonDistNor;
    ButtonGroup buttonGroupDist;

    public MenuPrincipal(){
        super("Mini Proyecto");

        //Inicializo los componentes
        buttonSaveFiles = new JButton("Guardar");
        buttonLoadFiles = new JButton("Examinar");
        buttonStart = new JButton("Comenzar");
        textFieldSaveFiles = new JFormattedTextField(new File("").getAbsolutePath() + "/prueba.txt");
        textFieldSaveFiles.setEditable(false);
        textFieldLoadFiles = new JFormattedTextField(new File("").getAbsolutePath() + "/prueba.txt");
        textFieldLoadFiles.setEditable(false);
        radioButtonComiteExaust = new JRadioButton("Comite de supervision Ingenuo", true);
        radioButtonComiteSmart = new JRadioButton("Comite de Supervision Inteligente");
        radioButtonProcExaust = new JRadioButton("Planeacion de procesador Ingenuo");
        radioButtonProcSmart = new JRadioButton("Planeacion de procesador Inteligente");
        buttonGroupProblem = new ButtonGroup();
        buttonGroupProblem.add(radioButtonComiteExaust);
        buttonGroupProblem.add(radioButtonComiteSmart);
        buttonGroupProblem.add(radioButtonProcExaust);
        buttonGroupProblem.add(radioButtonProcSmart);
        radioButtonDistUni = new JRadioButton("Distribucion Uniforme", true);
        radioButtonDistNor = new JRadioButton("Distribucion Normal");
        buttonGroupDist = new ButtonGroup();
        buttonGroupDist.add(radioButtonDistUni);
        buttonGroupDist.add(radioButtonDistNor);


        //Se crea el JPanel que contendra todos los demas componentes
        JPanel panelPrincipal = new JPanel(new GridBagLayout());


        //Panel contenedor del titulo
        JPanel panelTitle = new JPanel(new GridLayout(1,1));
        GridBagConstraints constraintsTitle = new GridBagConstraints();
        constraintsTitle.gridx = 1;
        constraintsTitle.gridy = 0;
        constraintsTitle.gridwidth = 1;
        constraintsTitle.gridheight = 1;
        constraintsTitle.weighty = 1;
        JLabel labelTitle = new JLabel("Mini Proyecto", JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 60));
        labelTitle.setForeground(Color.decode("#aed581"));
        panelTitle.add(labelTitle);

        //Panel contenedor del label Problemas
        JPanel panelLabelProblema = new JPanel(new GridLayout(1,1));
        GridBagConstraints constraintsLabelProblema = new GridBagConstraints();
        constraintsLabelProblema.gridx = 1;
        constraintsLabelProblema.gridy = 1;
        constraintsLabelProblema.gridwidth = 1;
        constraintsLabelProblema.gridheight = 1;
        JLabel labelTitleProblema = new JLabel("Problemas", JLabel.CENTER);
        labelTitleProblema.setFont(new Font("Arial", Font.BOLD, 20));
        panelLabelProblema.add(labelTitleProblema);

        //Panel contenedor de radioButton y buttonStart
//        JPanel panelOpciones = new JPanel(new GridLayout(2,1));

        //Panel contenedor de radioButton
        JPanel panelRadioButtonProb = new JPanel(new GridLayout(3, 2, 0, 0));
        GridBagConstraints constraintsRadButProb = new GridBagConstraints();
        constraintsRadButProb.gridx = 1;
        constraintsRadButProb.gridy = 2;
        constraintsRadButProb.gridwidth = 1;
        constraintsRadButProb.gridheight = 1;
        panelRadioButtonProb.add(radioButtonComiteExaust);
        panelRadioButtonProb.add(radioButtonProcExaust);
        panelRadioButtonProb.add(radioButtonComiteSmart);
        panelRadioButtonProb.add(radioButtonProcSmart);

        //Panel contenedor del label Problemas
        JPanel panelLabelDistri = new JPanel(new GridLayout(1,1));
        GridBagConstraints constraintsLabelDistri = new GridBagConstraints();
        constraintsLabelDistri.gridx = 1;
        constraintsLabelDistri.gridy = 3;
        constraintsLabelDistri.gridwidth = 1;
        constraintsLabelDistri.gridheight = 1;
        JLabel labelTitleDistri = new JLabel("Distribuciones", JLabel.CENTER);
        labelTitleDistri.setFont(new Font("Arial", Font.BOLD, 17));
        panelLabelDistri.add(labelTitleDistri);

        //Panel contenedor del radioButton de las distribuciones
        JPanel panelRadioButtonDistri = new JPanel(new GridLayout(1, 2, 0, 0));
        GridBagConstraints constraintsRadButDistri = new GridBagConstraints();
        constraintsRadButDistri.gridx = 1;
        constraintsRadButDistri.gridy = 4;
        constraintsRadButDistri.gridwidth = 1;
        constraintsRadButDistri.gridheight = 1;
        constraintsRadButDistri.weightx = 1.0;
        panelRadioButtonDistri.add(radioButtonDistUni);
        panelRadioButtonDistri.add(radioButtonDistNor);

        //Panel contenedor de guardar archivos
        JPanel panelSaveFilesContent = new JPanel(new BorderLayout(20, 20));
        GridBagConstraints constraintsSaveFiles = new GridBagConstraints();
        constraintsSaveFiles.gridx = 1;
        constraintsSaveFiles.gridy = 6;
        constraintsSaveFiles.gridwidth = 1;
        constraintsSaveFiles.gridheight = 1;
        constraintsSaveFiles.weighty = 1;
        constraintsSaveFiles.fill = GridBagConstraints.HORIZONTAL;
//        constraintsSaveFiles.anchor = GridBagConstraints.NORTH;
        panelSaveFilesContent.add(new JLabel("      "), BorderLayout.WEST);
        panelSaveFilesContent.add(textFieldSaveFiles, BorderLayout.CENTER);
        JPanel panelButtonSaveFiles = new JPanel(new BorderLayout());
        panelButtonSaveFiles.add(buttonSaveFiles, BorderLayout.CENTER);
        panelButtonSaveFiles.add(new JLabel("    "), BorderLayout.EAST);
        panelSaveFilesContent.add(panelButtonSaveFiles, BorderLayout.EAST);

        //Panel contenedor de guardar archivos
        JPanel panelLoadFilesContent = new JPanel(new BorderLayout(20, 20));
        GridBagConstraints constraintsLoadFiles = new GridBagConstraints();
        constraintsLoadFiles.gridx = 1;
        constraintsLoadFiles.gridy = 7;
        constraintsLoadFiles.gridwidth = 1;
        constraintsLoadFiles.gridheight = 1;
        constraintsLoadFiles.weighty = 1;
        constraintsLoadFiles.fill = GridBagConstraints.HORIZONTAL;
        constraintsLoadFiles.anchor = GridBagConstraints.NORTH;
        panelLoadFilesContent.add(new JLabel("      "), BorderLayout.WEST);
        panelLoadFilesContent.add(textFieldLoadFiles, BorderLayout.CENTER);
        JPanel panelButtonLoadFiles = new JPanel(new BorderLayout());
        panelButtonLoadFiles.add(buttonLoadFiles, BorderLayout.CENTER);
        panelButtonLoadFiles.add(new JLabel("    "), BorderLayout.EAST);
        panelLoadFilesContent.add(panelButtonLoadFiles, BorderLayout.EAST);

        //Panel contenedor de buttonStart
        JPanel panelButtonStart = new JPanel(new FlowLayout());
        GridBagConstraints constraintsButStart = new GridBagConstraints();
        constraintsButStart.gridx = 1;
        constraintsButStart.gridy = 8;
        constraintsButStart.gridwidth = 1;
        constraintsButStart.gridheight = 1;
        panelButtonStart.add(buttonStart);

        //Añade los radioButton y el buttonStart a el contenedor
//        panelOpciones.add(new JLabel("           "),BorderLayout.WEST);
//        panelOpciones.add(panelRadioButton);
//        panelOpciones.add(panelStart);

        //Añade el buscador de archivos y lao opciones de busqueda al contenedor del centro
//        panelContenidoMedio.add(panelFilesContent, BorderLayout.NORTH);


        //Añade el titulo y las opciones del centro a la ventana principal
        panelPrincipal.add(panelTitle,constraintsTitle);
        panelPrincipal.add(panelLabelProblema, constraintsLabelProblema);
        panelPrincipal.add(panelRadioButtonProb, constraintsRadButProb);
        panelPrincipal.add(panelLabelDistri, constraintsLabelDistri);
        panelPrincipal.add(panelRadioButtonDistri, constraintsRadButDistri);
        panelPrincipal.add(panelSaveFilesContent, constraintsSaveFiles);
        panelPrincipal.add(panelLoadFilesContent, constraintsLoadFiles);
        panelPrincipal.add(panelButtonStart, constraintsButStart);

        add(panelPrincipal);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);
    }
}
