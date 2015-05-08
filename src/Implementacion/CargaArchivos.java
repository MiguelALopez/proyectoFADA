/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 02-may-2015
 * Nombre del Archivo: CargaArchivos.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Implementacion;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/*Esta clase es la encargada de recibir Archivos (File) y convertirlos,
* a un formato que sea reconocido por las clases para poder ejecutar
* operaciones con estos*/
public class CargaArchivos {

    public ArrayList<Monitor> cargarMonitores(String url){
        File file = new File(url);
        ArrayList<Monitor> monitors = new ArrayList<Monitor>();
        String buffer;
        if (file != null){
            try {
                FileReader archivos = new FileReader(file);
                BufferedReader lee = new BufferedReader(archivos);
                //Lee la primera linea de el numero
                lee.readLine();
                //Ciclo para almacenar los datos del texto en el arreglo del mapa positionsMap
                for (int i = 0; (buffer=lee.readLine())!=null; i++) {
                    //Se separa en tokens por espacios y "-"
                    StringTokenizer st = new StringTokenizer(buffer, " -:");
                    String nombre = st.nextToken(); //Se guarda el nombre
                    String dia = st.nextToken().toLowerCase(); //Se guarda el dia en minusculas
                    //Se maneja hora militar para facilitar su uso
                    int horaInicio = Integer.parseInt(st.nextToken() + st.nextToken());
                    int horaFin = Integer.parseInt(st.nextToken() + st.nextToken());
                    monitors.add(new Monitor(nombre, dia, horaInicio, horaFin));
                }
                lee.close();
            }catch (IOException e){
                System.err.println("Error al cargar el Archivo");
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Error en el Formato de entrada");
            }catch (NumberFormatException e){
                System.err.println("Error en el Formato de entrada");
            }catch (NoSuchElementException e){
                System.err.println("Error en el Formato de entrada");
            }
        }
        return monitors;
    }

    public ArrayList<Proceso> cargaProcesos(String url){
        File file = new File(url);
        ArrayList<Proceso> procesos = new ArrayList<Proceso>();
        String buffer;
        if (file != null){
            try {
                FileReader archivos = new FileReader(file);
                BufferedReader lee = new BufferedReader(archivos);
                //Lee la primera linea de el numero
                lee.readLine();
                //Ciclo para almacenar los datos del texto en el arreglo del mapa positionsMap
                for (int i = 0; (buffer=lee.readLine())!=null; i++) {
                    //Se separa en tokens por espacios  "-", "(", ")", ":"
                    StringTokenizer st = new StringTokenizer(buffer, " -():");
                    String nombre = st.nextToken(); //Se guarda el nombre
                    //Se maneja hora militar para facilitar su uso
                    int horaInicio = Integer.parseInt(st.nextToken() + st.nextToken());
                    int horaFin = Integer.parseInt(st.nextToken() + st.nextToken());
                    procesos.add(new Proceso(nombre, horaInicio, horaFin));
                }
                lee.close();
            }catch (IOException e){
                System.err.println("Error al cargar el Archivo");
            }catch (ArrayIndexOutOfBoundsException e){
                System.err.println("Error en el Formato de entrada");
            }catch (NumberFormatException e){
                System.err.println("Error en el Formato de entrada");
            }catch (NoSuchElementException e){
                System.err.println("Error en el Formato de entrada");
            }
        }
        return procesos;
    }
}
