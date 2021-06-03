/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imad.rec1imad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Imad
 */
public class ListaEnteros {
// atributo privado (ArrayList) de números enteros Integer
    private ArrayList<Integer> lista;
//Constructor sin parámetros,
    public ListaEnteros() {
                //crea la lista.
        lista = new ArrayList<>();
    }
  //metodo que contiene una condicion, los numero deben de estar entre [10-100]
  //si cumple la condicion devuelve true si no false
    public boolean insertarElemento(Integer i) {
        if (i > 9 && i < 101) {
            lista.add(i);
            return true;
        } else {
            return false;
        }
    }

   //metodo sobrecargado , que añadirá el elmento i en la posición pos
    public boolean insertarElemento(Integer i, int pos) {
        //controlamos que no se pase del intervalo [10-100]
        //Y que la posicion no pueda ser menor que 0 y mayor que 100
        if (i > 9 && i < 101 && pos >= 0 && pos < lista.size()) {
            lista.add(pos, i);
            return true;
        } else {
            return false;

        }
    }
// metodo que sustituye el elemento que ocupe la posición pos por el elemento que se pasa, i. 
 //Devolverá true en caso de que el cambio se haya realizado, false en el otro caso.
    public boolean cambiarElemento(Integer i, int pos) {
        if (insertarElemento(i)) {
            lista.set(pos, i);
            return true;
        } else {
            return false;

        }
    }

  //metodo que devolverá el elemento Integer que ocupe la posición pos. Si pos es una posición no válida, 
  //se lanzará una excepción de tipo IllegalArgumentException.
    public Integer obtenerElemento(int pos) {
//Se cumple la condicion solo si la posicion es mayor o igual que cero y menor del tamaño de la lista.
        if (pos >= 0 && pos < lista.size()) {
            return lista.get(pos);
        } else {
            throw new IllegalArgumentException("Posicion no valida");
        }

    }

//devolverá la primera posición en la que encuentre un valor igual a i.
    //En caso de no existir devolverá -1.
    // Devuelve la posición que ocupa en el arrayList la primera ocurrencia del objeto o.
    //Si el objeto no existe entonces se devuelve -1. 
    //Hay que tener en cuenta que para poder usar este método es necesario que 
    //la clase del objeto que se pasa como parámetro tenga implementado el método equals().
    public int buscarElemento(Integer i) {
        if (lista.indexOf(i) != -1) {
            return lista.indexOf(i);
        } else {
            return -1;
        }

    }

    //método estático para leer datos numéricos, que leerá por teclado una cadena de texto,
    //y devolverá un entero con la información leída. Cuidado con las excepciones.
    public static int leerEntero() {
        Scanner teclado = new Scanner(System.in);
        Integer numero = 0;
        String texto = "";
        try {
            System.out.println("Introduce un numero");
            texto = teclado.nextLine();
            numero = Integer.parseInt(texto);
        } catch (NumberFormatException ex) {
            System.out.println("No es un número");
        }

        return numero;
    }

    //mostrar(),imprime la lista completa de números.
    public void mostrar() {
        // Uso de bucle foreach
        //lista.forEach(System.out::println);
        //contador lo utilizamos para mostrar la posicion a la hora de imprimir los numeros
        int contador = 0;
        for (Integer numeros : lista) {

            System.out.println(contador + ": " + numeros);
            contador++;
        }
    }

    //Imprime  la suma de los números pares
    public void mostrarSumaPares() {
        int sumaPares = 0;
        for (int i = 0; i < lista.size(); i++) {
            //si la division entre 2 es igual a 0(numero par) se cumple la condicon
            if (lista.get(i) % 2 == 0) {
                sumaPares += lista.get(i);
            }
        }
        System.out.println("La suma de los numeros pares es: " + sumaPares);
    }

    //imprime la suma de los números impares
    public void mostrarSumaImPares() {
        int sumaImPares = 0;
        for (int i = 0; i < lista.size(); i++) {
            //si la division entre 2 es distina a 0(numero impar) se cumple la condicon
            if (lista.get(i) % 2 != 0) {
                sumaImPares += lista.get(i);
            }
        }
        System.out.println("La suma de los numeros impares es: " + sumaImPares);
    }

//devuelve el entero mayor de la lista.
    public int getMayor() {
        int numeroMayor = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) > numeroMayor) {
                numeroMayor = lista.get(i);
            }
        }

        //tambien podriamos utilizar
        //return Collections.max(lista);
        return numeroMayor;
    }

    //devuelve el entero menor de la lista.
    public int getMenor() {
        return Collections.min(lista);
    }
//netodo que devuelve un entero indicando el número de elementos de la lista.
    public int getLongitud() {
        return lista.size();
    }

    //metodo que borra un elemento de la lista, según su posición, devolviendo true. 
    //Si la posición no existe en la lista devolverá false. 
    //Al borrar un elemento el resto se moverá una posición a la izquierda.
    public boolean borrarElemento(int pos) {
        if (pos >= 0 && pos < lista.size()) {
            lista.remove(pos);
            return true;
        } else {
            return false;
        }

    }

    //metodos getters y setters
    public ArrayList<Integer> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Integer> lista) {
        this.lista = lista;
    }
//para poder usar indesxof y contains debemos de llamar al método equals().
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ListaEnteros other = (ListaEnteros) obj;
        if (!Objects.equals(this.lista, other.lista)) {
            return false;
        }
        return true;
    }

}
