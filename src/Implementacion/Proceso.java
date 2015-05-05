/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 05-may-2015
 * Nombre del Archivo: Proceso.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Implementacion;

public class Proceso {
    private String tarea; //Nombre de la tarea
    private int horaInicio;
    private int horaFin;

    public Proceso(String tarea, int horaInicio, int horaFin) {
        this.tarea = tarea;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    //Getters y Setters

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(int horaFin) {
        this.horaFin = horaFin;
    }
}
