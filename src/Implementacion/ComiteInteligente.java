
package Implementacion;

import java.util.ArrayList;


public class ComiteInteligente {
    private ArrayList<Monitor> monitores;
    private int[][] matrizMonitores;
    private int n;
    private int[] acumula;
    private int[] resultado;

    public ComiteInteligente(ArrayList<Monitor> monitores){
        this.n = monitores.size();
        this.monitores = monitores;
        matrizMonitores = new int[n][n];
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
        int tam = monitores.size();
        for(int i=0; i<tam; i++){
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
                    }else{
                        matrizMonitores[i][j] = 0;
                        matrizMonitores[j][i] = 0;
                    }
                }
            }
        }
        /*for (int i = 0; i < matrizMonitores.length; i++) {
            System.out.print("P: " + i + " | ");
            for (int j = 0; j < matrizMonitores.length; j++) {
                System.out.print(matrizMonitores[i][j] + " ");
            }
            System.out.print(" | " + acumula[i]);
            System.out.println();
        }*/
    }

    //Metodo encargado de verificar si el horario de dos monitores se cruza
    public boolean checkNoIntegrante(Monitor monitor1, Monitor monitor2){
        boolean cruza = false;
            //Se compara que este en el mismo dia
            if (monitor1.getDia().equals(monitor2.getDia())){
                //Se compara sus horas se cruzan
                if (monitor1.getHoraInicio() < monitor2.getHoraFin() &&
                        monitor1.getHoraFin() > monitor2.getHoraInicio()){
                    cruza = true;
                }

            }

        return cruza;
    }

    //Metodo encargado de retornar la posicion del mayor numero del arreglo acumula
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
            if(acumula[i]==numero){
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
        int[] seleccionFila = matrizMonitores[pos];

        for(int i=0; i<resultado.length; i++){
            if(resultado[i] == -1 && seleccionFila[i] !=0){
                resultado[i] = pos;
//                System.out.println("posicion " + i + " resultado "+resultado[i]);
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

    public void comite(){
        //Se almacena la posicion del mayor numero del arreglo acumula
        int mayor = mayor();

        boolean termina = llenarResultado(mayor);

        int indice = n - acumula[mayor];
        int indice2 = acumula[mayor];

        int pos=0;

        if(indice<acumula[mayor]){
            acumula[mayor]=0;
            while(!termina){
                pos = encontrarPosicion(indice);
                while(pos != -1){
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
    //Metodo encargado de generar el comite
    public ArrayList<Monitor> generarComiteSmart(){
        llenarMatriz();
        iniResultado();
        comite();
        ArrayList<Integer> posComite = new ArrayList<Integer>();
        for (int i = 0; i < resultado.length; i++) {
            boolean seEncuentra = false;//Variable usada para verificar si ya esta la variable antes
            for (int j = 0; j < posComite.size(); j++) {
                if (resultado[i] == posComite.get(j)){
                    seEncuentra = true;
                }
            }
            if (!seEncuentra){
                posComite.add(resultado[i]);
            }
        }
        ArrayList<Monitor> comite = new ArrayList<Monitor>();
        for (int i = 0; i < posComite.size(); i++) {
            comite.add(monitores.get(posComite.get(i)));
        }

        return comite;
    }

    //Getters y Setters
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
}