/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implementacion;

import java.util.ArrayList;

/**
 *
 * @author kegisan
 */
public class ProcesadorInteligente {
    private ArrayList<Proceso> procesos;
    private int[][] matrizProcesos;
    private int n;
    private int[] acumula;
    private int[] resultado;

    public ProcesadorInteligente(int n, ArrayList<Proceso> procesos){
        this.n = n;
        this.procesos = procesos;
        matrizProcesos = new int[n][n];
        acumula = new int[n];
        resultado = new int[n];
    }

    //Inicializa el arreglo resultado con -1
    public void iniResultado(){
        for (int i=0; i<n; i++){
            resultado[i]=-1;
        }
    }

    /*Metodo encargado de crear una matriz la cual simula cuales son los monitores que se cuzan entre ellos
    * cada vez que un monitor se cruce con otro la posicion se llenara con 1 de lo contrario con un 0*/
    public void llenarMatriz(){
        int tam = procesos.size();
        for(int i=0; i<tam; i++){
//            System.out.println("Indice "+i);
            for(int j=i; j<tam; j++){
                if(i == j){
                    matrizProcesos[i][j] = 1;
                    acumula[i]++;
                }else{
                    if(checkNoIntegrante(procesos.get(i), procesos.get(j))){
                       matrizProcesos[i][j] = 1;
                       matrizProcesos[j][i] = 1;
                       acumula[i]++;
                       acumula[j]++;
//                       System.out.println("Entra "+i);

                    }else{
                        matrizProcesos[i][j] = 0;
                        matrizProcesos[j][i] = 0;
                    }
                }

            }
        }
        for (int i = 0; i < matrizProcesos.length; i++) {
            System.out.print("P: " + i + " | ");
            for (int j = 0; j < matrizProcesos.length; j++) {
                System.out.print(matrizProcesos[i][j] + " ");
            }
            System.out.print(" | " + acumula[i]);
            System.out.println();
        }
    }

    //Metodo encargado de verificar si el horario de dos monitores se cruza
    public boolean checkNoIntegrante(Proceso proceso1, Proceso proceso2){
        boolean cruza = false;

                //Se compara sus horas se cruzan
                if (proceso1.getHoraInicio() < proceso2.getHoraFin() &&
                        proceso1.getHoraFin() > proceso2.getHoraInicio()){
                    cruza = true;
                }

        return cruza;
    }

    //Metodo encargado de retornar la posicion del mayor numero del arreglo acumula
    public int menor(){
        int menor=acumula[0];
        int posicion=0;
        for(int i=1; i<n; i++){
            if(acumula[i]<menor){
                menor=acumula[i];
                posicion=i;
            }
        }

        return posicion;
    }

    public int encontrarPosicion(int numero){
        int posicion = -1;

        for(int i=0; i<n; i++){
            //System.out.println(acumula[i] + " - " + numero);
            if(acumula[i]==numero){
                //System.out.println("hola");
                posicion=i;
                acumula[i] = 0;
                return posicion;
            }
        }

        return posicion;
    }

    /*Metodo encargado de usar un arreglo que simula ser el cruce de cada monitor,
    * en el cual se llena con las posiciones monitores que mas cruces tiene*/
    public boolean llenarResultado(int pos){
        boolean llenaResultado = true;
        int[] seleccionFila = matrizProcesos[pos];
        boolean valido=true;
        int [] aux ={0,0,0,0,0,0};
        
        /*for(int i =0; i< resultado.length; i++){
            if(resultado[i] != -1 && seleccionFila[i] !=0){
                valido = false;
            }
            
        }
        */

            for(int i=0; i<resultado.length && valido; i++){
                if(resultado[i] == -1 && seleccionFila[i] !=0){
                    resultado[i] = pos;
                    System.out.println("posicion " + i + " resultado "+resultado[i]);
                    matrizProcesos[i]=aux;
                    
                }
            }
 
        //En caso de que la matriz resultado este llena se retorna true de lo contrario false
        for(int i=0; i<n; i++){
            if(resultado[i] == -1){
                llenaResultado = false;
            }
        }
        return llenaResultado;
    }

    public void procesosI(){
        //Se almacena la posicion del mayor numero del arreglo acumula
        int menor = menor();

        boolean termina = llenarResultado(menor);

        int indice =acumula[menor];

        int pos=0;
        acumula[menor]=0;
        
            while(!termina){
                
                pos = encontrarPosicion(indice);
                while(pos != -1){
                    termina = llenarResultado(pos);
                    pos = encontrarPosicion(indice);
                }
                indice++;
                
            }

    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public int[][] getMatrizProcesos() {
        return matrizProcesos;
    }

    public void setMatrizProcesos(int[][] matrizProcesos) {
        this.matrizProcesos = matrizProcesos;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int[] getAcumula() {
        return acumula;
    }

    public void setAcumula(int[] acumula) {
        this.acumula = acumula;
    }

    public int[] getResultado() {
        return resultado;
    }

    public void setResultado(int[] resultado) {
        this.resultado = resultado;
    }


    

    public void imprimir(){
        int tam = procesos.size();

        for(int i=0; i<tam; i++){
            System.out.println(acumula[i]);
        }
    }




    public static void main (String[] args){
        ArrayList<Proceso> procesos1 = new ArrayList<Proceso>();

        Proceso tarea1 =  new Proceso("Tarea1", 3, 6);
        Proceso tarea2 =  new Proceso("Tarea2", 4, 8);
        Proceso tarea3 =  new Proceso("Tarea3", 7, 10);
        Proceso tarea4 =  new Proceso("Tarea4", 9, 11);
        Proceso tarea5 =  new Proceso("Tarea5", 7, 10);
        Proceso tarea6 =  new Proceso("Tarea6", 1, 4);
        Proceso tarea7 =  new Proceso("Tarea7", 10, 13);
        Proceso tarea8 =  new Proceso("Tarea8", 5, 7);
        
        
        procesos1.add(tarea1);
        procesos1.add(tarea2);
        procesos1.add(tarea3);
        procesos1.add(tarea4);
        procesos1.add(tarea5);
        procesos1.add(tarea6);
        procesos1.add(tarea7);
        procesos1.add(tarea8);

        ProcesadorInteligente procesa = new ProcesadorInteligente(8, procesos1);

        procesa.llenarMatriz();
//        comite.imprimir();
        procesa.iniResultado();
        procesa.procesosI();

    }
}
