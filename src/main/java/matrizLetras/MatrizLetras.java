/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizLetras;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author MSI
 */
public class MatrizLetras {

    private int[][] matriz = new int[10][10];

    public MatrizLetras() {
    }
//metodo que rellena el array multi con numeros enteros aleatorios

    public void llenarAleatoriamente() {
        Random aleatorio = new Random();
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                //Generamos numeros aleatorios del 97 +26 que equivalen al abecedario en la tabla ASCII
                int letra = (int) (aleatorio.nextInt(26) + 97);
                matriz[i][j] = letra;
            }
        }
    }

    public void imprimir() {
        for (int i = 0; i < matriz.length; i++) {

            for (int j = 0; j < matriz[i].length; j++) {
                //Hacemos una convercion explicita para pasar de int a char
                //y asi imprimimos correctamente las letras
                char letra = (char) matriz[i][j];
                System.out.print(letra + "|");
            }
            System.out.println("");
        }
    }
//Este metodo utiliza  el método sort de la clase Arrays, que está en el paquete 
    //java.util que se encargará de ordenar cualquier tipo de array que le pasemos como argumento.
    //El modo de ordenación por defecto responde a la posición del valor de acuerdo a su valor Unicode
    public void ordenar() {
        for (int i = 0; i < matriz.length; i++) {
            Arrays.sort(matriz[i]);

        }
    }
//Metodo que ordena haciendo uso del algoritmo HeapSort
    public void ordenar2() {
        for (int i = 0; i < matriz.length; i++) {

            ordenacionMonticulosHeapSort(matriz[i]);
        }
    }
//metodo que sirve para contar las veces que se repite la letra que se le pasa cmo parametro
    public int contarCaracteres(char x) {
        // int conversionEntero = Character.getNumericValue(x);
        int contador = 0;
        //conversion de char a int 
        int letraX = x;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                //si la letra que esta almacenada en la fila [i][j] es igual a letra que hemos pasado por parametro
                if (matriz[i][j] == letraX) {
                    //el contador suma 
                    contador++;
                }
            }
        }
        //devolvemos el contador despúes de todas las interacciones 
        return contador;
    }

    //El algorito Heap Sort lo que hace es divide el conjunto de elementos y 
    //los recorre desde la mitad a la primera posicion 
    //despues  inicia el proceso de ordenación intercambiando el primer elemento por el último 
    //de la matriz y reorganizando el montículo a partir de la primera posición.
    private  void ordenacionMonticulosHeapSort(int[] arrayRecibido) {
        int numero = matriz.length;
        //nodo es la longitud de la matriz dividida en dos
        for (int nodo = numero / 2; nodo >= 0; nodo--) {
            //en cada interaccion del bucle se va restando una posicion del array
            hacerMonticulo(arrayRecibido, nodo, numero - 1);
        }
        
        //nodo es la ultima posicion del array 
        for (int nodo = numero - 1; nodo >= 0; nodo--) {
            //Se almacena en la variable temporal la posicion 0 del array recibido 
            int tmp = arrayRecibido[0];
            //en el array 0 recibimos el array con la ultima posicion 
            arrayRecibido[0] = arrayRecibido[nodo];
          //  el array con la ultima posicion es igual a la poscion 0 
            arrayRecibido[nodo] = tmp;
            //
            hacerMonticulo(arrayRecibido, 0, nodo - 1);
        }
    }

    //metodo que recibe un array, la longitud de la mitad y la ultima posicion del array
    private static void hacerMonticulo(int[] matrizRecibida, int nodo, int fin) {
        //variable izquierda se refiere a la primera mitad del array
        int izq = 2 * nodo + 1;
        //variable derecha  se refiere a la segunda mitad del array
        int der = izq + 1;
        int mayor;
        //Si la parte izquierda es mayor
        if (izq > fin) {
            return;
        }
        if (der > fin) {
            mayor = izq;
        } else {
            // la variable mayor recibirá el valor izq en el caso de que la condición sea true
            //o bien el valor der en el caso de que la condición sea false.
            mayor = (matrizRecibida[izq] > matrizRecibida[der]) ? izq : der;
        }
       
        if (matrizRecibida[nodo] < matrizRecibida[mayor]) {
            int tmp = matrizRecibida[nodo];
            matrizRecibida[nodo] = matrizRecibida[mayor];
            matrizRecibida[mayor] = tmp;
            hacerMonticulo(matrizRecibida, mayor, fin);
        }
    }
}
