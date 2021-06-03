/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrizLetras;

/**
 *
 * @author MSI
 */
public class PruebaMatriz {
    public static void main(String[] args) {
            MatrizLetras prueba = new MatrizLetras();
            
            prueba.llenarAleatoriamente();
            
            prueba.imprimir();
            System.out.println("Array ordenado");
            prueba.ordenar();
            prueba.imprimir();
            
            System.out.println("La letra x se repite en: "+prueba.contarCaracteres('x')+" ocasiones");

    }
}
