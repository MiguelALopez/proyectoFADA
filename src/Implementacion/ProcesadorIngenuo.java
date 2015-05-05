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
    //Lista que contiene los procesos que se desean ejecutar
    private ArrayList<Proceso> procesos;
    //Conjuto de todos los procesos posibles que puede hacer el procesador
    private ArrayList<ArrayList<Proceso>> conjProcesos;

    public ProcesadorIngenuo() {
        procesos = new ArrayList<Proceso>();
        conjProcesos = new ArrayList<ArrayList<Proceso>>();
    }

    public ArrayList<Proceso> generaProcesosIngenua(){
        conjProcesos = new ArrayList<ArrayList<Proceso>>();
        permutacion(new ArrayList<Proceso>(), procesos);
        return conjProcesos.get(mayorNumProcesos(conjProcesos));
//        return null;
    }

    //Este metodo se encarga de hacer una combinatoria de todos los posibles comites
    public void permutacion(ArrayList<Proceso> procesador, ArrayList<Proceso> procesos){
        int n = procesos.size();
        System.out.println(n);
        if (n == 0){
//            System.out.println("jajaja");
            conjProcesos.add(procesador);
            /*for (int i = 0; i < procesador.size(); i++) {
                System.out.print(procesador.get(i).getTarea() + " ");
            }
            System.out.println();*/
        }else {
            for (int i = 0; i < n; i++) {

                //Esta condicion verifica si el monitor puede no ser integrante del comite
                if (checkPosibleProceso(procesador, procesos.get(i))){
//                    System.out.println("hola");
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

    //Metodo encargado de retornar la posicion del mayor numero de procesos del conjunto de procesos que se ingrese
    public int mayorNumProcesos(ArrayList<ArrayList<Proceso>> conjProcesos){
        int posMenor = 0;
        int mayor = conjProcesos.get(0).size();
        for (int i = 0; i < conjProcesos.size(); i++) {
            if (conjProcesos.get(i).size() > mayor){
                mayor = conjProcesos.get(i).size();
                posMenor = i;
            }
        }
        return posMenor;
    }

    //Getters y Setters

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public ArrayList<ArrayList<Proceso>> getConjProcesos() {
        return conjProcesos;
    }

    public void setConjProcesos(ArrayList<ArrayList<Proceso>> conjProcesos) {
        this.conjProcesos = conjProcesos;
    }
}
