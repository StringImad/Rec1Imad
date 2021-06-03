/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoLista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Imad
 */
public final class Domino {

    private ArrayList<FichaDomino> listaFichas = new ArrayList<>();
//Constructor por defecto 

    public Domino() {

        rellenarListaConFichasAleatorias(this.listaFichas);

    }
//metodo que rellena la lista que recibe con fichas que se van generando en el metodo que tenemos creado
    //en la clase FichaDomino

    public void rellenarListaConFichasAleatorias(ArrayList<FichaDomino> lista) {
    //    FichaDomino fichaNueva;

        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                FichaDomino ficha = new FichaDomino(i, j);
                if (comprobarFichaNoRepetida(ficha)) {
                    lista.add(ficha);
                }

            }
        }
//        int contador = 0;
//        do {
//            fichaNueva = FichaDomino.aleatoria();
//
//            if (comprobarFichaNoRepetida(fichaNueva)) {
//                lista.add(fichaNueva);
//                contador++;
//            }
//        } while (contador != 28);

    }
//metodo que recibe dos valores que corresponden a los numeros de la ficha del domino
    //recorre la lista y comprueba si son iguales y devuelve true en caso de que no sean iguales

    public boolean comprobarFichaNoRepetida(FichaDomino nueva) {
        boolean comprobacion = true;

        for (FichaDomino listaFicha : this.listaFichas) {
            if (listaFicha.getParteIzq() == nueva.getParteIzq()
                    && listaFicha.getParteDer() == nueva.getParteDer()
                    || listaFicha.getParteDer() == nueva.getParteIzq()
                    && listaFicha.getParteIzq() == nueva.getParteDer()) {
                return false;
            }
        }

        return comprobacion;
    }

    //Metodo que devuelve una ficha aleatoria del dominó
    //y la elimina de la estructura. Si no hay fichas por sacar devuelve null.
    public FichaDomino sacarFicha() {

        FichaDomino fichaSacadaAleatoriamente;
        Random aleatorio = new Random();
        int numeroAleatorio;
        //nos guarda en numeroAleatorio un numero aleatorio entero del tamaño de la lista 
        numeroAleatorio = aleatorio.nextInt(this.listaFichas.size());
        //Se cumple la condicion solo si la posicion es mayor o igual que cero
        //y menor del tamaño de la lista.
        if (numeroAleatorio >= 0 && numeroAleatorio < this.listaFichas.size()) {
            //fichaSacada almacena una ficha aleatoria
            fichaSacadaAleatoriamente = this.listaFichas.get(numeroAleatorio);
            //eliminamos la ficha aleatoria
            this.listaFichas.remove(numeroAleatorio);
        } else {
            fichaSacadaAleatoriamente = null;
        }
        return fichaSacadaAleatoriamente;
    }

    public void meterFicha(FichaDomino f) {

        if (this.listaFichas.contains(f)) {
            this.listaFichas.add(f);
        }
    }

    //método para mezclar de maneara aleatoria una lista haciendo uso del metodo
    //Collections.shuffle()
    public void mezclarFichas() {
        Collections.shuffle(this.listaFichas);
    }

    //metodo que genera un nuevo arrayList con el numero de cartas que pide el usuario
    //a su vez va borrando las cartas del otro arraylist
    public FichaDomino[] repartir(int n) {
        FichaDomino[] primeraRonda = new FichaDomino[n];
        for (int i = 0; i < n; i++) {

            primeraRonda[i] = listaFichas.get(i);
            //  primeraRonda.add(listaFichas.get(i));
            listaFichas.remove(i);

        }

        return primeraRonda;
    }

    //metodoparaimprimir
    public void imprimirArray() {
        for (FichaDomino listaFicha : listaFichas) {
            System.out.println(listaFicha);
        }
    }

    //metodos getters y setters
    public ArrayList<FichaDomino> getListaFichas() {
        return this.listaFichas;
    }

    public void setListaFichas(ArrayList<FichaDomino> listaFichas) {
        this.listaFichas = listaFichas;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

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
        final Domino other = (Domino) obj;
        if (!Objects.equals(this.listaFichas, other.listaFichas)) {
            return false;
        }
        return true;
    }
    
    

}
