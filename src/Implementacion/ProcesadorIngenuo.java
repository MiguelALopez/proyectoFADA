/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 05-may-2015
 * Nombre del Archivo: ProcesadorIngenuo.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Implementacion;

import java.util.ArrayList;

public class ProcesadorIngenuo {
    private ArrayList<Proceso> procesos;//Lista que contiene los procesos que se desean ejecutar
    private ArrayList<Proceso> procesador;//Conjuto de todos los procesos posibles que puede hacer el procesador

    public ProcesadorIngenuo(ArrayList<Proceso> procesos){
        this.procesos = procesos;
        procesador = new ArrayList<Proceso>();
    }

    public ArrayList<Proceso> generaProcesosIngenua(){
        procesador = new ArrayList<Proceso>();
        permutacion(new ArrayList<Proceso>(), procesos);
        return procesador;
    }

    //Este metodo se encarga de hacer una combinatoria de todos los posibles comites
    public void permutacion(ArrayList<Proceso> procesador, ArrayList<Proceso> procesos){
        int n = procesos.size();
        if (n == 0){
            addProcesador(procesador);
        }else {
            for (int i = 0; i < n; i++) {
                //Esta condicion verifica si puede ser un proceso
                if (checkPosibleProceso(procesador, procesos.get(i))){
                    ArrayList<Proceso> tmp = new ArrayList<Proceso>();
                    tmp.addAll(procesador);
                    tmp.add(procesos.get(i));
                    permutacion(tmp, excludeProceso(procesos, i));
                }else {
                    permutacion(procesador, excludeProceso(procesos, i));
                }
            }
        }
    }

    //Metodo encargado de verificar si la nueva lista de procesos es mayor que la que hay y si es asi la añade
    public void addProcesador(ArrayList<Proceso> newProcesador){
        if (procesador.size() == 0){
            procesador = newProcesador;
        }else if (procesador.size() < newProcesador.size()){
            procesador = newProcesador;
        }
    }

    //Metodo encargado de verificar si un proceso se cruza en el horario de una lista de procesos
    public boolean checkPosibleProceso(ArrayList<Proceso> procesos, Proceso proceso){
        boolean posibleProceso = true;
        for (int i = 0; i < procesos.size(); i++) {
                //Se compara si la hora de inicio del monitor esta entre una de las horas del comite
                if (proceso.getHoraInicio() < procesos.get(i).getHoraFin() &&
                        proceso.getHoraFin() > procesos.get(i).getHoraInicio()){
                    posibleProceso = false;
                }
        }
        return posibleProceso;
    }

    //Funcion auxiliar que retorna un array list sin el monitor de la posicion que se le pasa
    public ArrayList<Proceso> excludeProceso(ArrayList<Proceso> procesos, int posExclude){
        ArrayList<Proceso> tmp = new ArrayList<Proceso>(procesos); //Se crea una copia de los monitores
        tmp.remove(posExclude);//Se elimina el monitor de la posicion que se ingresa
        return tmp; //Se retorna la lista de monitores sin el monitor eliminado
    }

    //Getters y Setters
    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public ArrayList<Proceso> getProcesador() {
        return procesador;
    }

    public void setProcesador(ArrayList<Proceso> procesador) {
        this.procesador = procesador;
    }
}
