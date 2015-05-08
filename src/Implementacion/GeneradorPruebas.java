/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 06-may-2015
 * Nombre del Archivo: GeneradorPruebas.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
package Implementacion;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class GeneradorPruebas {

    //Variable que contiene un banco de nombres para generar nombres de los monitores al azar
    private String diasSemana[] = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
    private String bancoNombres[] = {"Isabella", "Daniel", "Olivia", "David", "Alexis", "Gabriel", "Sofía", "Benjamín",
            "Victoria", "Samuel", "Amelia", "Lucas", "Alexa", "Ángel", "Julia", "José", "Camila", "Adrián", "Alexandra", "Sebastián",
            "Maya", "Xavier", "Andrea", "Juan", "Ariana", "Luis", "María", "Diego", "Eva", "Óliver", "Angelina", "Carlos", "Valeria",
            "Jesús", "Natalia", "Alex", "Isabel", "Max", "Sara", "Alejandro", "Liliana", "Antonio", "Adriana", "Miguel", "Juliana",
            "Víctor", "Gabriela", "Joel", "Daniela", "Santiago", "Valentina", "Elías", "Lila", "Iván", "Vivian", "Óscar", "Nora",
            "Leonardo", "Ángela", "Eduardo", "Elena", "Alan", "Clara", "Nicolás", "Eliana", "Jorge", "Alana", "Omar", "Miranda",
            "Paúl", "Amanda", "Andrés", "Diana", "Julián", "Ana", "Josué", "Penélope", "Román", "Aurora", "Fernando", "Alexandría",
            "Javier", "Lola", "Abraham", "Alicia", "Ricardo", "Amaya", "Francisco", "Alexia", "César", "Jazmín", "Mario",
            "Mariana", "Manuel", "Alina", "Édgar", "Lucía", "Alexis", "Fátima", "Israel", "Ximena", "Mateo", "Laura", "Héctor",
            "Cecilia", "Sergio", "Alejandra", "Emiliano", "Esmeralda", "Simón", "Verónica", "Rafael", "Daniella", "Martín",
            "Miriam", "Marco", "Carmen", "Roberto", "Iris", "Pedro", "Guadalupe", "Emanuel", "Selena", "Abel", "Fernanda",
            "Rubén", "Angélica", "Fabián", "Emilia", "Emilio", "Lía", "Joaquín", "Tatiana", "Marcos", "Mónica", "Lorenzo",
            "Carolina", "Armando", "Jimena", "Adán", "Dulce", "Raúl", "Talía", "Julio", "Estrella", "Enrique", "Brenda",
            "Gerardo", "Lilian", "Pablo", "Paola", "Jaime", "Serena", "Saúl", "Celeste", "Esteban", "Viviana", "Gustavo",
            "Elisa", "Rodrigo", "Melina", "Arturo", "Gloria", "Mauricio", "Claudia", "Orlando", "Sandra", "Hugo", "Marisol",
            "Salvador", "Asia", "Alfredo", "Ada", "Maximiliano", "Rosa", "Ramón", "Isabela", "Ernesto", "Regina", "Tobías",
            "Elsa", "Abram", "Perla", "Noé", "Raquel", "Guillermo", "Virginia", "Ezequiel", "Patricia", "Lucián", "Linda",
            "Alonzo", "Marina", "Felipe", "Leila", "Matías", "América", "Tomás", "Mercedes", "Jairo"};

    //Clase encargada de generar nombres al azar
    public String genNombres() {
        int random = (int) (Math.random() * 200);
        return bancoNombres[random];
    }

    public String genDiaSemana(int distribucion) {
        double probabilidad = Math.random();
        int random;

        //Probabilidad del 80% de que sea entre semana
        if (0.8 <= probabilidad && distribucion == 2) {
            random = (int) (Math.random() * 5);
        } else {
            random = (int) (Math.random() * 7);
        }
        return diasSemana[random];
    }

    public String genHorarioMonitor(int distribucion) {
        String hora = "";
        double probabilidad = Math.random();
        //Probabilidad del 80% que sea horario de oficina
        if (probabilidad <= 0.8 && distribucion == 2) {
            int horaInicio = (int) ((Math.random() * 8) + 8);
            int horaFin = horaInicio + (int) ((Math.random() * 8) + 1);
            if (horaFin > 19) {
                horaFin = 18;
            }
            hora += horaInicio + ":00 - " + horaFin + ":00";
        } else {
            int horaInicio = (int) (Math.random() * 22);
            int horaFin = horaInicio + (int) ((Math.random() * 8) + 1);
            if (horaFin > 24) {
                horaFin = 23;
            }
            hora += horaInicio + ":00 - " + horaFin + ":00";
        }
        return hora;
    }
    public String genHorarioProcesador(int distribucion){
        String hora = "";
        double probabilidad = Math.random();
        //Probabilidad del 90% que sea horario de 8 a 16
        if (probabilidad > 0.9 && distribucion == 2) {
            int horaInicio = (int) ((Math.random() * 8) + 8);
            int horaFin = horaInicio + (int) ((Math.random() * 12) + 1);
            if (horaFin > 17) {
                horaFin = 16;
            }
            hora += horaInicio + ":00 - " + horaFin + ":00";
        } else {
            int horaInicio = (int) (Math.random() * 22);
            int horaFin = horaInicio + 1;
            if (horaFin > 24) {
                horaFin = 23;
            }
            hora += horaInicio + ":00 - " + horaFin + ":00";
        }
        return hora;
    }

    /*Clase encargada de generar las pruebas de los procesos recibe como entrada la Distribucion,
    * el numero de procesos que se va a generar y la url donde generara el archivo. Distribucion
    * normal sera referanciada con el numero 1 y distribucion uniforme con el numero 2*/
    public void pruebasMonitores(int distribucion, int numeroMonitores, String url) {
        File archivo = new File(url);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(numeroMonitores + "\n");
            for (int i = 0; i < numeroMonitores; i++) {
                bw.write(genNombres() + " " + genDiaSemana(distribucion) + " " + genHorarioMonitor(distribucion) + "\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void pruebasProcesador(int distribucion, int numeroProcesos, String url){
        File archivo = new File(url);
        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(numeroProcesos + "\n");
            for (int i = 0; i < numeroProcesos; i++) {
                bw.write("Tarea" + (i+1) + " (" + genHorarioProcesador(distribucion) + ")\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new GeneradorPruebas().pruebasMonitores(1, 50, "/afs/eisc.univalle.edu.co/user/pregrado/2013/miguelalf/prueba1.txt");


        new GeneradorPruebas().pruebasMonitores(2, 50, "/afs/eisc.univalle.edu.co/user/pregrado/2013/miguelalf/prueba2.txt");
        new GeneradorPruebas().pruebasProcesador(1, 50, "/afs/eisc.univalle.edu.co/user/pregrado/2013/miguelalf/prueba3.txt");
        new GeneradorPruebas().pruebasProcesador(2, 50, "/afs/eisc.univalle.edu.co/user/pregrado/2013/miguelalf/prueba4.txt");
        long end = System.currentTimeMillis();

        System.out.println("Took : " + ((end - start) / 1000));
    }
}
