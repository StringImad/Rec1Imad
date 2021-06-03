/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.rec1imad;


/**
 *
 * @author Imad
 */
public class Test {

    public static void main(String[] args) {
        //Crea un objeto ListaEnteros.
        ListaEnteros primeraPrueba = new ListaEnteros();

        for (int i = 0; i < 15; i++) {
            //Rellena la lista con 15 objetos Integer. 
            //uso el método estático leerEntero().
            primeraPrueba.insertarElemento(ListaEnteros.leerEntero());
        }
        //metodo que nos imprime la lista
        primeraPrueba.mostrar();
        //insertamos el numero 12 en la posicion 4
        primeraPrueba.insertarElemento(12, 4);
        System.out.println("Insertamos el numero 12 en la posicion 4 ");
        primeraPrueba.mostrar();
        //Nos mustra el numero de la posicion 2
        System.out.println("El numero en la posicion 2 es: " + primeraPrueba.obtenerElemento(2));
        //Si encuentra un numero nos pone su posicion en la lista si no lo encuentra -1
        System.out.println(primeraPrueba.buscarElemento(100));
  
        System.out.println("El numero mayor es: " + primeraPrueba.getMayor());
        System.out.println("El numero menor es: " + primeraPrueba.getMenor());

        primeraPrueba.mostrarSumaImPares();
        primeraPrueba.mostrarSumaPares();

        primeraPrueba.borrarElemento(12);
        primeraPrueba.mostrar();

    }
}
