/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoLista;

import java.util.Random;

/**
 *
 * @author Imad
 */
public class FichaDomino {
    
    private int parteIzq, parteDer;

    //Constructor por defecto
    public FichaDomino() {
        this.parteIzq = 0;
        this.parteDer = 0;
    }

    //Constructor parametrizado
    public FichaDomino(int a, int b) {
        this.parteIzq = valorValido(a);
        this.parteDer = valorValido(b);
    }

    //metodo para comprobar si a y b son validos y sustituir si no lo son
    private int valorValido(int a) {
        if (a < 0 || a > 6) {
            if (a % 2 == 0) {
                a = 6;
            } else {
                a = 5;
            }
        }
        return a;
    }

    //Setter y getter, teniendo en cuenta la restriccion
    public int getParteIzq() {
        return parteIzq;
    }

    public void setParteIzq(int parteIzq) {
        this.parteIzq = valorValido(parteIzq);
    }

    public int getParteDer() {
        return parteDer;
    }

    public void setParteDer(int parteDer) {
        this.parteDer = valorValido(parteDer);
    }
    
    
    //metodo de suma de ambas partes de a ficha
    public byte getValorTotal() {
        return (byte) (parteIzq + parteDer);
    }
    //metodo de clase que genere fichas aleatorias
    public static FichaDomino aleatoria() {
        Random rd = new Random();
        
        return new FichaDomino(rd.nextInt(7), rd.nextInt(7));
    }
    //uso del método toString(), usando el siguiente formato: [ | ]
     @Override
    public String toString() {
        String salida = "[" + parteIzq + "|" + parteDer + "]";
        return salida.replaceAll("0", " ");
    }
    
    //metodo para comprobar si es seis doble
    public static boolean esRepetida(FichaDomino ficha) {
        return ficha.getParteIzq() == 6 && ficha.getParteDer() == 6;
    }
}
