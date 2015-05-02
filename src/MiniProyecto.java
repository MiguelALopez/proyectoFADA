/**
 * ********************************************
 * Autor: Miguel Angel Lopez Fernandez
 * Correo: miguel.angel.lopez@correounivalle.edu.co
 * Código: 1326691
 * Fecha: 02-may-2015
 * Nombre del Archivo: MiniProyecto.java
 * Plan: Ingeniería de Sistemas - 3743
 * Institución Educativa: Universidad del Valle (Cali - Colombia)
 * *********************************************
 */
import Interfaz.Eventos;
import Interfaz.MenuPrincipal;

public class MiniProyecto {
    public static void main(String[] args) {
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        new Eventos(menuPrincipal);
    }
}
