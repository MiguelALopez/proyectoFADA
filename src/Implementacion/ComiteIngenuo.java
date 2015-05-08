/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 02-may-2015
 * Nombre del Archivo: Comite.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Implementacion;

import java.util.ArrayList;

public class ComiteIngenuo {
    private ArrayList<Monitor> monitors;//Esta lista contiene a todos los monitores
    private ArrayList<Monitor> comite;//Conjunto de todos los comites posibles
    private int numComite;//Variable encargada de llevar registro de cual es menor comite

    public ComiteIngenuo(ArrayList<Monitor> monitors){
        this.monitors = monitors;
        comite = new ArrayList<Monitor>();
        numComite = monitors.size() ;
    }

    //Metodo encargado de generar el menor comite
    public ArrayList<Monitor> generarComiteIngenua(){
        comite = new ArrayList<Monitor>();
        permutacion(new ArrayList<Monitor>(), monitors);
        return comite;
    }

    //Este metodo se encarga de hacer una combinatoria de todos los posibles comites
    public void permutacion(ArrayList<Monitor> comite, ArrayList<Monitor> monitors){
        int n = monitors.size();
        if (n == 0){
            addComite(comite);
            /*for (int i = 0; i < comite.size(); i++) {
                System.out.print(comite.get(i).getNombre() + " ");
            }
            System.out.println();*/
        }else {
            //for que va hasta el tamano del arreglo y se ejecuta si el comite que va a generar es menor al que hay
            for (int i = 0; i < n; i++) {
//                System.out.println(comite.size() +  " - " + numComite);
                if (comite.size() < numComite){
                    ArrayList<Monitor> tmp = new ArrayList<Monitor>();
                    tmp.addAll(comite);
                    tmp.add(monitors.get(i));
                    permutacion(tmp, excludeMonitor(monitors, i));
                    //Esta condicion verifica si el monitor puede no ser integrante del comite
                    if (checkNoIntegrante(comite, monitors.get(i))){
                        permutacion(comite, excludeMonitor(monitors, i));
                    }
                }

            }
        }
    }

    //Metodo encargado de verificar si el nuevo comite es menor que el que hay y si es asi lo añade
    public void addComite(ArrayList<Monitor> newComite){
        if (comite.size() == 0){
            comite = newComite;
            numComite = comite.size();
        }else if (comite.size() > newComite.size()){
            comite = newComite;
            numComite = comite.size();
        }
    }

    //Metodo encargado de verificar si un monitor puede no ser parte del comite
    public boolean checkNoIntegrante(ArrayList<Monitor> comite, Monitor monitor){
        boolean noIntegrante = false;
        for (int i = 0; i < comite.size(); i++) {
            //Se compara que este en el mismo dia
            if (monitor.getDia().equals(comite.get(i).getDia())){
                //Se compara si la hora de inicio del monitor esta entre una de las horas del comite
                if (monitor.getHoraInicio() < comite.get(i).getHoraFin() &&
                        monitor.getHoraFin() > comite.get(i).getHoraInicio()){
                    noIntegrante = true;
                }

            }
        }
        return noIntegrante;
    }

    //Funcion auxiliar que retorna un array list sin el monitor de la posicion que se le pasa
    public ArrayList<Monitor> excludeMonitor(ArrayList<Monitor> monitors, int posExclude){
        ArrayList<Monitor> tmp = new ArrayList<Monitor>(monitors); //Se crea una copia de los monitores
        tmp.remove(posExclude);//Se elimina el monitor de la posicion que se ingresa
        return tmp; //Se retorna la lista de monitores sin el monitor eliminado
    }

    //Getters y Setters
    public ArrayList<Monitor> getMonitors() {
        return monitors;
    }

    public void setMonitors(ArrayList<Monitor> monitors) {
        this.monitors = monitors;
    }
}
