/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominoLista;

import java.util.ArrayList;

/**
 *
 * @author Imad
 */
public class PruebaDomino {

    public static void main(String[] args) {
        Domino conjuntoFichas = new Domino();

        conjuntoFichas.imprimirArray();

        conjuntoFichas.sacarFicha();
        if (conjuntoFichas.sacarFicha() == null) {
            System.out.println("-------------No hay fichas que sacar-----------------");
        } else {
            System.out.println("La ficha sacada es: " + conjuntoFichas.sacarFicha().toString());
        }

        System.out.println("-----------Imprimiendo la lista despues de eliminar----------");
        conjuntoFichas.imprimirArray();

        FichaDomino fichaNueva = new FichaDomino(4, 4);

        conjuntoFichas.meterFicha(fichaNueva);
        System.out.println("--------------Imprimiendo ficha nueva [4|4]-----------------");
        conjuntoFichas.imprimirArray();

        System.out.println("-------------mezclando todas las fichas---------------");
        conjuntoFichas.mezclarFichas();
        conjuntoFichas.imprimirArray();

        System.out.println("------------------------Lista con las 5 fichas repartidas----------------");

        //ArrayList<FichaDomino> ronda = conjuntoFichas.repartir(5);
        FichaDomino[] ronda = conjuntoFichas.repartir(5);
        for (FichaDomino lista : ronda) {
            System.out.println(lista);

        }

        System.out.println("----------------Lista con las fichas sacadas-------------------");
        conjuntoFichas.imprimirArray();

    }
}
