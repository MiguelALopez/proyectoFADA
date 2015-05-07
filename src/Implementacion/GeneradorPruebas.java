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

public class GeneradorPruebas {

    //Variable que contiene un banco de nombres para generar nombres de los monitores al azar
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

    public String genHorarioMonitor(int distribucion){
        String hora = "";
        switch (distribucion){
            case 1:{
                int horaInicio = (int) (Math.random() * 22);
                int horaFin = horaInicio + (int)((Math.random() * 8) + 1);
                if (horaFin > 24){
                    horaFin = 23;
                }
                hora+= horaInicio + ":00 - " + horaFin + ":00";
            }break;
            case 2:{
                /*------------------------------ Apenas implementando esta parte ------------------------*/
                double probabilidad = Math.random();
                //Probabilidad del 80% que sea horario de oficina
                if (probabilidad <= 0.8){
                    int horaInicio = (int) (Math.random() * 8);
                    int horaFin = horaInicio + (int)((Math.random() * 8) + 1);
                    if (horaFin > 24){
                        horaFin = 23;
                    }
                    hora+= horaInicio + ":00 - " + horaFin + ":00";
                }
            }break;
        }
        return hora;
    }

    /*Clase encargada de generar las pruebas de los procesos recibe como entrada la distribucion,
    * el numero de procesos que se va a generar y la url donde generara el archivo. Distribucion
    * normal sera referanciada con el numero 1 y distribucion uniforme con el numero 2*/
    public void pruebasMonitores(int distribucion, int numeroPocesos, String url) {
        double probabilidad = Math.random();
//        if (distrubucion == 1) {
//            for (int i = 0; i < numeroPocesos; i++) {
//
//            }
//        }
    }

    public static void main(String[] args) {
        System.out.println(new GeneradorPruebas().genHorarioMonitor(1));

    }
}
