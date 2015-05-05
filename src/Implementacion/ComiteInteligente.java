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
public class ComiteInteligente {
    private ArrayList<Monitor> monitores;
    private int[][] matrizMonitores;
    private int n;  
    private int[] acumula;
    private int[] resultado;
    
    public ComiteInteligente(int n, ArrayList<Monitor> monitores){
        this.n = n;
        this.monitores = monitores;
        matrizMonitores = new int[n][n];
        acumula = new int[n];
        resultado = new int[n];
    }
    
    public void iniResultado(){
        
        for (int i=0; i<n; i++){
            resultado[i]=-1;
        }
    }
    
    public void llenarMatriz(){
        int tam = monitores.size();
        for(int i=0; i<tam; i++){
            System.out.println("Indice "+i);
            for(int j=i; j<tam; j++){
                if(i == j){
                    matrizMonitores[i][j] = 1;
                    acumula[i]++;
                    
                    
                }else{
                    if(checkNoIntegrante(monitores.get(i), monitores.get(j))){
                       matrizMonitores[i][j] = 1;
                       matrizMonitores[j][i] = 1;
                       acumula[i]++;
                       acumula[j]++;
                       System.out.println("Entra "+i);
                       
                    }else{
                        matrizMonitores[i][j] = 0;
                        matrizMonitores[j][i] = 0;
                    }
                }
                
            }
        }
        
    }
    
    public boolean checkNoIntegrante(Monitor monitor1, Monitor monitor2){
        boolean cruza = false;
            //Se compara que este en el mismo dia
            if (monitor1.getDia().equals(monitor2.getDia())){
                //Se compara si la hora de inicio del monitor esta entre una de las horas del comite
                if (monitor1.getHoraInicio() < monitor2.getHoraFin() &&
                        monitor1.getHoraFin() > monitor2.getHoraInicio()){
                    cruza = true;
                }

            }
        
        return cruza;
    }
    
    public int mayor(){
        int mayor=0;
        int posicion=0;
        for(int i=0; i<n; i++){
            if(acumula[i]>mayor){
            mayor=acumula[i];
            posicion=i;}
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
    
    public boolean llenarResultado(int pos){
        boolean llenaResultado=true;
        int[] seleccionFila = matrizMonitores[pos];
         
       for(int i=0; i<resultado.length; i++){

           if(resultado[i] == -1 && seleccionFila[i] !=0){
               resultado[i] = pos;
               System.out.println("posicion "+i+" resultado "+resultado[i]);
           }
       } 
       
       for(int i=0; i<n; i++){
           if(resultado[i] == -1){
               llenaResultado = false;
           }
       }
       
       
        return llenaResultado;
    }
    
    public void comite(){
        int mayor=mayor();
        
        boolean termina = llenarResultado(mayor);
        
        int indice = n-acumula[mayor];
        int indice2= acumula[mayor];
        
        
        int pos=0;
        
        if(indice<acumula[mayor]){
            acumula[mayor]=0;
            while(!termina){
                 // System.out.println("indiceeeeeeeeeeee "+ indice);  
                pos = encontrarPosicion(indice);
                //System.out.println("posicionnnnnnnnnnn "+ pos); 
                while(pos != -1){
                    //System.out.println("hola que hace");
                    termina = llenarResultado(pos);
                    pos = encontrarPosicion(indice);

                }


                indice--;
                if(indice==0){
                    indice=indice2;
                }
            }
        }else{
           acumula[mayor]=0;  
           
           while(!termina){
                       
            pos = encontrarPosicion(indice2);
            
                while(pos != -1){
                    termina = llenarResultado(pos);
                    pos = encontrarPosicion(indice2);
                    
                }
                indice2--;
            } 
        }
    }

    
    public ArrayList<Monitor> getMonitores() {
        return monitores;
    }

    public void setMonitores(ArrayList<Monitor> monitores) {
        this.monitores = monitores;
    }

    public int[][] getMatrizMonitores() {
        return matrizMonitores;
    }

    public void setMatrizMonitores(int[][] matrizMonitores) {
        this.matrizMonitores = matrizMonitores;
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
    
    public void imprimir(){
        int tam = monitores.size();
        
        for(int i=0; i<tam; i++){
            System.out.println(acumula[i]);
        }
    }
    

    
    
    public static void main (String[] args){
        ArrayList<Monitor> monitores1 = new ArrayList<Monitor>();
        
        Monitor mon =  new Monitor("Julian", "Lunes", 1, 6);
        Monitor mon2 =  new Monitor("Andres", "Lunes", 2, 3);
        Monitor mon3 =  new Monitor("Concobu", "Lunes", 3, 4);
        Monitor mon4 =  new Monitor("Filson", "Lunes", 4, 5);
        Monitor mon5 =  new Monitor("Emilio", "Lunes", 5, 7);
        Monitor mon6 =  new Monitor("Samanta", "Lunes", 6, 7);
        Monitor mon7 =  new Monitor("Samanta", "Lunes", 4, 9);
        //Monitor mon8 =  new Monitor("Samanta", "Lunes", 6, 7);
        monitores1.add(mon);
        monitores1.add(mon2);
        monitores1.add(mon3);
        monitores1.add(mon4);
        monitores1.add(mon5);
        monitores1.add(mon6);
        monitores1.add(mon7);
        //monitores1.add(mon8);

        
        ComiteInteligente comite = new ComiteInteligente(7, monitores1);
        
        comite.llenarMatriz();
        comite.imprimir();
        comite.iniResultado();
        comite.comite();

    }

}