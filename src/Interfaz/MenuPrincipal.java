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
    JButton buttonGenerate;
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
    JSpinner spinnerNumDistri;
    JTextArea textAreaNaive;
    JTextArea textAreaSmart;

    public MenuPrincipal(){
        super("Mini Proyecto");

        //Inicializo los componentes
        buttonSaveFiles = new JButton("Guardar");
        buttonLoadFiles = new JButton("Examinar");
        buttonStart = new JButton("Comenzar");
        buttonGenerate = new JButton("Generar");
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
        spinnerNumDistri = new JSpinner(new SpinnerNumberModel(5,1,50000,1));
        textAreaNaive = new JTextArea();
        textAreaSmart = new JTextArea();

        //Se crea el JPanel que contendra todos los demas componentes
        JPanel panelPrincipal = new JPanel(new GridBagLayout());

        //Panel contenedor del titulo
        JPanel panelTitle = new JPanel(new GridLayout(1,1));
        GridBagConstraints constraintsTitle = new GridBagConstraints();
        constraintsTitle.gridx = 1;
        constraintsTitle.gridy = 0;
        constraintsTitle.gridwidth = 3;
        constraintsTitle.gridheight = 1;
        constraintsTitle.insets = new Insets(20,20,20,20);
        JLabel labelTitle = new JLabel("Mini Proyecto", JLabel.CENTER);
        labelTitle.setFont(new Font("Arial", Font.BOLD, 60));
        labelTitle.setForeground(Color.decode("#aed581"));
        panelTitle.add(labelTitle);
        panelPrincipal.add(panelTitle,constraintsTitle);

        //Panel contenedor del label Problemas
        JPanel panelLabelProblema = new JPanel(new GridLayout(1,1));
        GridBagConstraints constraintsLabelProblema = new GridBagConstraints();
        constraintsLabelProblema.gridx = 1;
        constraintsLabelProblema.gridy = 1;
        constraintsLabelProblema.gridwidth = 3;
        constraintsLabelProblema.gridheight = 1;
        constraintsLabelProblema.insets = new Insets(10,10,10,10);
        JLabel labelTitleProblema = new JLabel("Problemas", JLabel.CENTER);
        labelTitleProblema.setFont(new Font("Arial", Font.BOLD, 20));
        panelLabelProblema.add(labelTitleProblema);
        panelPrincipal.add(panelLabelProblema, constraintsLabelProblema);

        //Panel contenedor de radioButton
        GridBagConstraints constraintsRadButProb = new GridBagConstraints();
        constraintsRadButProb.gridx = 1;
        constraintsRadButProb.gridy = 2;
        constraintsRadButProb.gridwidth = 1;
        constraintsRadButProb.gridheight = 1;
        constraintsRadButProb.anchor = GridBagConstraints.WEST;
        panelPrincipal.add(radioButtonComiteExaust, constraintsRadButProb);
        constraintsRadButProb.gridx = 2;
        constraintsRadButProb.gridy = 2;
        constraintsRadButProb.gridwidth = 2;
        constraintsRadButProb.gridheight = 1;
        panelPrincipal.add(radioButtonProcExaust, constraintsRadButProb);
        constraintsRadButProb.gridx = 1;
        constraintsRadButProb.gridy = 3;
        constraintsRadButProb.gridwidth = 1;
        constraintsRadButProb.gridheight = 1;
        panelPrincipal.add(radioButtonComiteSmart, constraintsRadButProb);
        constraintsRadButProb.gridx = 2;
        constraintsRadButProb.gridy = 3;
        constraintsRadButProb.gridwidth = 2;
        constraintsRadButProb.gridheight = 1;
        panelPrincipal.add(radioButtonProcSmart, constraintsRadButProb);

        //Panel contenedor del label Problemas
        JPanel panelLabelDistri = new JPanel(new GridLayout(1,1));
        GridBagConstraints constraintsLabelDistri = new GridBagConstraints();
        constraintsLabelDistri.gridx = 1;
        constraintsLabelDistri.gridy = 4;
        constraintsLabelDistri.gridwidth = 3;
        constraintsLabelDistri.gridheight = 1;
        constraintsLabelDistri.insets = new Insets(10,10,10,10);
        JLabel labelTitleDistri = new JLabel("Distribuciones", JLabel.CENTER);
        labelTitleDistri.setFont(new Font("Arial", Font.BOLD, 17));
        panelLabelDistri.add(labelTitleDistri);
        panelPrincipal.add(panelLabelDistri, constraintsLabelDistri);

        //Panel contenedor del radioButton de las distribuciones
        GridBagConstraints constraintsRadButDistri = new GridBagConstraints();
        constraintsRadButDistri.gridx = 1;
        constraintsRadButDistri.gridy = 5;
        constraintsRadButDistri.gridwidth = 1;
        constraintsRadButDistri.gridheight = 1;
        panelPrincipal.add(radioButtonDistUni, constraintsRadButDistri);
        constraintsRadButDistri.gridx = 2;
        constraintsRadButDistri.gridy = 5;
        constraintsRadButDistri.gridwidth = 1;
        constraintsRadButDistri.gridheight = 1;
        panelPrincipal.add(radioButtonDistNor, constraintsRadButDistri);
        constraintsRadButDistri.gridx = 3;
        constraintsRadButDistri.gridy = 5;
        constraintsRadButDistri.gridwidth = 1;
        constraintsRadButDistri.gridheight = 1;
        constraintsRadButDistri.anchor = GridBagConstraints.WEST;
        constraintsRadButDistri.fill = GridBagConstraints.HORIZONTAL;
        constraintsRadButDistri.insets = new Insets(0,10,0,10);
        panelPrincipal.add(spinnerNumDistri, constraintsRadButDistri);

        //Panel contenedor de guardar archivos
        GridBagConstraints constraintsSaveFiles = new GridBagConstraints();
        constraintsSaveFiles.gridx = 1;
        constraintsSaveFiles.gridy = 6;
        constraintsSaveFiles.gridwidth = 2;
        constraintsSaveFiles.gridheight = 1;
        constraintsSaveFiles.insets = new Insets(10,10,10,10);
        constraintsSaveFiles.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(textFieldSaveFiles, constraintsSaveFiles);
        constraintsSaveFiles.gridx = 3;
        constraintsSaveFiles.gridy = 6;
        constraintsSaveFiles.gridwidth = 1;
        constraintsSaveFiles.gridheight = 1;
        panelPrincipal.add(buttonSaveFiles, constraintsSaveFiles);

        //Panel contenedor de guardar archivos
        GridBagConstraints constraintsLoadFiles = new GridBagConstraints();
        constraintsLoadFiles.gridx = 1;
        constraintsLoadFiles.gridy = 7;
        constraintsLoadFiles.gridwidth = 2;
        constraintsLoadFiles.gridheight = 1;
        constraintsLoadFiles.insets = new Insets(10,10,10,10);
        constraintsLoadFiles.fill = GridBagConstraints.BOTH;
        panelPrincipal.add(textFieldLoadFiles, constraintsLoadFiles);
        constraintsLoadFiles.gridx = 3;
        constraintsLoadFiles.gridy = 7;
        constraintsLoadFiles.gridwidth = 1;
        constraintsLoadFiles.gridheight = 1;
        panelPrincipal.add(buttonLoadFiles, constraintsLoadFiles);

        //Panel contenedor de buttonStart
        GridBagConstraints constraintsButStart = new GridBagConstraints();
        constraintsButStart.gridx = 1;
        constraintsButStart.gridy = 8;
        constraintsButStart.gridwidth = 1;
        constraintsButStart.gridheight = 1;
        constraintsButStart.insets = new Insets(10,10,10,10);
        panelPrincipal.add(buttonGenerate, constraintsButStart);
        constraintsButStart.gridx = 2;
        constraintsButStart.gridy = 8;
        constraintsButStart.gridwidth = 1;
        constraintsButStart.gridheight = 1;
        panelPrincipal.add(buttonStart, constraintsButStart);

        GridBagConstraints constraintsLabelTexDistri = new GridBagConstraints();
        constraintsLabelTexDistri.gridx = 1;
        constraintsLabelTexDistri.gridy = 9;
        constraintsLabelTexDistri.gridwidth = 1;
        constraintsLabelTexDistri.gridheight = 1;
        constraintsLabelTexDistri.insets = new Insets(10,10,10,10);
        panelPrincipal.add(new JLabel("Algoritmo Ingenuo"), constraintsLabelTexDistri);
        constraintsLabelTexDistri.gridx = 2;
        constraintsLabelTexDistri.gridy = 9;
        constraintsLabelTexDistri.gridwidth = 1;
        constraintsLabelTexDistri.gridheight = 1;
        constraintsLabelTexDistri.insets = new Insets(10,10,10,10);
        panelPrincipal.add(new JLabel("Algoritmo Inteligente"), constraintsLabelTexDistri);

        GridBagConstraints constraintsTextAlgorithms = new GridBagConstraints();
        constraintsTextAlgorithms.gridx = 1;
        constraintsTextAlgorithms.gridy = 10;
        constraintsTextAlgorithms.gridwidth = 1;
        constraintsTextAlgorithms.gridheight = 1;
        constraintsTextAlgorithms.insets = new Insets(10,10,10,10);
        constraintsTextAlgorithms.fill = GridBagConstraints.BOTH;
        constraintsTextAlgorithms.weighty = 1;
        panelPrincipal.add(new JScrollPane(textAreaNaive), constraintsTextAlgorithms);
        constraintsTextAlgorithms.gridx = 2;
        constraintsTextAlgorithms.gridy = 10;
        constraintsTextAlgorithms.gridwidth = 1;
        constraintsTextAlgorithms.gridheight = 1;
        constraintsTextAlgorithms.insets = new Insets(10,10,10,10);
        panelPrincipal.add(new JScrollPane(textAreaSmart), constraintsTextAlgorithms);


        add(panelPrincipal);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(800, 700);
        setVisible(true);
    }
}
