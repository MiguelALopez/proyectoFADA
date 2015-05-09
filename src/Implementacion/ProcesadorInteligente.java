
package Implementacion;

import java.util.ArrayList;


public class ProcesadorInteligente {
    private ArrayList<Proceso> procesos;
    private int[][] matrizProcesos;
    private int n;
    private int[] acumula;
    private int[] resultado;

    public ProcesadorInteligente(ArrayList<Proceso> procesos) {
        this.n = procesos.size();
        this.procesos = procesos;
        matrizProcesos = new int[n][n];
        acumula = new int[n];
        resultado = new int[n];
    }

    //Inicializa el arreglo resultado con -1
    public void iniResultado() {
        for (int i = 0; i < n; i++) {
            resultado[i] = -1;
        }
    }

    /*Metodo encargado de crear una matriz la cual simula cuales son los monitores que se cuzan entre ellos
    * cada vez que un monitor se cruce con otro la posicion se llenara con 1 de lo contrario con un 0*/
    public void llenarMatriz() {
        int tam = procesos.size();
        for (int i = 0; i < tam; i++) {
            for (int j = i; j < tam; j++) {
                if (i == j) {
                    matrizProcesos[i][j] = 1;
                    acumula[i]++;
                } else {
                    if (checkNoIntegrante(procesos.get(i), procesos.get(j))) {
                        matrizProcesos[i][j] = 1;
                        matrizProcesos[j][i] = 1;
                        acumula[i]++;
                        acumula[j]++;
                    } else {
                        matrizProcesos[i][j] = 0;
                        matrizProcesos[j][i] = 0;
                    }
                }
            }
        }
    }

    //Metodo encargado de verificar si el horario de dos monitores se cruza
    public boolean checkNoIntegrante(Proceso proceso1, Proceso proceso2) {
        boolean cruza = false;
        //Se compara sus horas se cruzan
        if (proceso1.getHoraInicio() < proceso2.getHoraFin() &&
                proceso1.getHoraFin() > proceso2.getHoraInicio()) {
            cruza = true;
        }
        return cruza;
    }

    //Metodo encargado de retornar la posicion del mayor numero del arreglo acumula
    public int menor() {
        int menor = acumula[0];
        int posicion = 0;
        for (int i = 1; i < n; i++) {
            if (acumula[i] < menor) {
                menor = acumula[i];
                posicion = i;
            }
        }
        return posicion;
    }

    public int encontrarPosicion(int numero) {
        int posicion = -1;
        for (int i = 0; i < n; i++) {
            if (acumula[i] == numero) {
                posicion = i;
                acumula[i] = 0;
                return posicion;
            }
        }
        return posicion;
    }

    /*Metodo encargado de usar un arreglo que simula ser el cruce de cada monitor,
    * en el cual se llena con las posiciones monitores que mas cruces tiene*/
    public boolean llenarResultado(int pos) {
        boolean llenaResultado = true;
        int[] seleccionFila = matrizProcesos[pos];
        boolean valido = true;
        int[] aux = new int[matrizProcesos.length];
        for (int i = 0; i < resultado.length && valido; i++) {
            if (resultado[i] == -1 && seleccionFila[i] != 0) {
                resultado[i] = pos;
                matrizProcesos[i] = aux;
            }
        }
        //En caso de que la matriz resultado este llena se retorna true de lo contrario false
        for (int i = 0; i < n; i++) {
            if (resultado[i] == -1) {
                llenaResultado = false;
            }
        }
        return llenaResultado;
    }

    public void procesosI() {
        //Se almacena la posicion del mayor numero del arreglo acumula
        int menor = menor();
        boolean termina = llenarResultado(menor);
        int indice = acumula[menor];
        int pos = 0;
        acumula[menor] = 0;
        while (!termina) {
            pos = encontrarPosicion(indice);
            while (pos != -1) {
                termina = llenarResultado(pos);
                pos = encontrarPosicion(indice);
            }
            indice++;
        }
    }

    //Metodo encargado de generar los procesos que se van a ejecutar
    public ArrayList<Proceso> generarProcesosSmart() {
        llenarMatriz();
        iniResultado();
        procesosI();
        ArrayList<Integer> posComite = new ArrayList<Integer>();
        for (int i = 0; i < resultado.length; i++) {
            boolean seEncuentra = false;//Variable usada para verificar si ya esta la variable antes
            for (int j = 0; j < posComite.size(); j++) {
                if (resultado[i] == posComite.get(j)) {
                    seEncuentra = true;
                }
            }
            if (!seEncuentra) {
                posComite.add(resultado[i]);
            }
        }
        ArrayList<Proceso> tmpProcesos = new ArrayList<Proceso>();
        for (int i = 0; i < posComite.size(); i++) {
            tmpProcesos.add(procesos.get(posComite.get(i)));
        }
        return tmpProcesos;
    }

    //Getters y Setters
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
}
