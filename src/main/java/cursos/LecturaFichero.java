/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author imad
 */
public class LecturaFichero {

    public static void main(String[] args) {
        // Fichero a leer con datos de ejemplo
        String idFichero = "RegActForCep.csv";
        ArrayList<ActividadesFormativas> listaActividadesFormativas = new ArrayList<ActividadesFormativas>();

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer

            //Omitimos las primeras 5 lineas
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            datosFichero.nextLine();
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un Stringç

                linea = datosFichero.nextLine();

                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split(";");
                ActividadesFormativas tmp = new ActividadesFormativas();

                for (String string : tokens) {
                    tmp.setCentro(tokens[0]);
                    tmp.setCodigo(tokens[1]);
                    tmp.setTitulo(tokens[2]);
                    tmp.setModalidad(tokens[3]);
                    tmp.setEstado(tokens[4]);
                    //cadena original tokens[5]
                    //convirtiendolo a java.time.LocalDate
                    LocalDate fechaIni = LocalDate.parse(tokens[5], DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate fechaFin = LocalDate.parse(tokens[6], DateTimeFormatter.ofPattern("dd/MM/yyyy"));

                    tmp.setFechaInicio(fechaIni);
                    tmp.setFechaFin(fechaFin);
                    tmp.setDirigidoA(tokens[7]);
                }
                listaActividadesFormativas.add(tmp);

            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Collections.sort(listaActividadesFormativas);

        Comparator<ActividadesFormativas> criterio = (p1, p2) -> p1.getTitulo().compareTo(p2.getTitulo());
        Collections.sort(listaActividadesFormativas, criterio);
        for (ActividadesFormativas token : listaActividadesFormativas) {
            System.out.println(token);
        }
//    
        //ESCRITURA
        String idFichero2 = "CursosAcabados.txt";

        try {
            BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2));

            flujo.write("Titulo Curso\t Fecha fin\t");
            flujo.newLine();

            for (ActividadesFormativas lib : listaActividadesFormativas) {
                if ((lib).getFechaFin().isBefore(LocalDate.of(2020, Month.APRIL, 1))) {
                    flujo.write((lib).getTitulo() + "\t" + (lib).getFechaFin());
                    flujo.newLine();
                }

            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero2 + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
