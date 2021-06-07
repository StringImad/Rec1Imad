/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author imad
 */
public class EscrituraFichero {
    public static void main(String[] args) {
                ArrayList<ActividadesFormativas> listaActividadesFormativas = new ArrayList<ActividadesFormativas>();

        String idFichero2 = "CursosAcabados.txt";
          try {
            BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2));

            flujo.write("Titulo Curso\t Fecha fin\t");
            flujo.newLine();

            for (ActividadesFormativas lib : listaActividadesFormativas) {
                
                    flujo.write(( lib).toString());

                

            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero2 + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
