/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cursos;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author imad
 */
public class LecturaEscrituraFichero {
//    @JsonDeserialize(using = LocalDateDeserializer.class)
//    @JsonSerialize(using = LocalDateSerializer.class)
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")

    public static void main(String[] args) throws IOException {

        // Fichero a leer con datos de ejemplo
        String idFichero = "RegActForCep.csv";
        ArrayList<ActividadesFormativas> listaActividadesFormativas = new ArrayList<ActividadesFormativas>();

        leerFicheroCsv(listaActividadesFormativas, idFichero);

        System.out.println("--------------Lista imprimida de todos los cursos--------------");
        for (ActividadesFormativas token : listaActividadesFormativas) {
            System.out.println(token);
        }
//    

        //Lista ordenanda por api stream
        ordenarPorApiStream(listaActividadesFormativas);
        //ESCRITURA
        String idFichero2 = "CursosAcabados.txt";
        escribirFicheroTxt(listaActividadesFormativas, idFichero2);

        //LECTURA FICHERO TXT
        System.out.println("----------------------Leyendo fichero txt-----------------------");
        leerFicheroTxt();

        //GENERAR JSON 
        System.out.println("---------------------------generando fichero JSON-------------------------------");
        generarFicheroJSON(escribirFicheroTxt(listaActividadesFormativas, idFichero2));
        //ArrayList que copia la lista que recibe del metodo JSON, es generada a partir de los datos que hay insertados en 
        //al leer el fichero JSON 
        ArrayList<ActividadesFormativasAcabadas> listaLeerActividades = leerJSON("cursosAcabados.JSON");
//Bucle que imprime la lista y muestra por pantalla el resultado
        for (int i = 0; i < listaLeerActividades.size(); i++) {
            System.out.println(listaLeerActividades.get(i));

        }

    }
//Metodo para leer el fichero CSV, recibe un arrayList de objetos ActividadesFormativas y el nombre del fichero
    public static void leerFicheroCsv(ArrayList<ActividadesFormativas> listaActividadesFormativas, String idFichero) {
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero CSV: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try (Scanner datosFichero = new Scanner(new File(idFichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            //Omitimos las primeras 5 lineas
            for (int i = 0; i < 5; i++) {
                datosFichero.nextLine();

            }
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
    }
//metodo para escribir fichero TXT recibe una lista y el nombre del fichero
    public static ArrayList escribirFicheroTxt(ArrayList<ActividadesFormativas> listaActividadesFormativasAcabadas, String idFichero2) {
        //ArrayList preparado para meter los datos para leer el JSON
        ArrayList<ActividadesFormativasAcabadas> listaActivJsonAcab = new ArrayList<>();
        System.out.println("---------------Escribiendo fichero TXT-------------------------");
        try {
            BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero2));
            String cabecera = ("Titulo Curso\t Fecha fin\t");
            flujo.write(cabecera);
            flujo.newLine();
            String intento = "";
            for (ActividadesFormativas lib : listaActividadesFormativasAcabadas) {
                if ((lib).getFechaFin().isBefore(LocalDate.of(2020, Month.APRIL, 1))) {

                    flujo.write((lib).getTitulo() + "\t" + (lib).getFechaFin());
                    flujo.newLine();
                    //Creamos un obejto de tipo ActividadesFormativasAcabadas, solo contiene dos atributos que son los que necesitamos 
                    ActividadesFormativasAcabadas objeto = new ActividadesFormativasAcabadas((lib).getTitulo(), (lib).getFechaFin());

                    listaActivJsonAcab.add(objeto);
                }

            }

            // Metodo fluh() guarda cambios en disco 
            flujo.flush();

            System.out.println("Fichero " + idFichero2 + " creado correctamente.");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listaActivJsonAcab;
    }

    public static void generarFicheroJSON(ArrayList lista) {

        //Creamos un objeto mapeador para poder configurar el archivo JSON
        //y para llevar a cabo la creación del mismo
        ObjectMapper mapeador = new ObjectMapper();

        //Utilizamos el método configure para que la estructura del JSON
        //este bien tabulada al guardar los objetos de la lista que le pasamos
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true);

        try {
            //llamamos al método writeValue que se le pasa como parametros
            //un constructor new File con el idFichero que pasamos anteriormente
            //y la lista de donde sacará los objetos en cuestión
            System.out.println("------------------generando 1");
            mapeador.writeValue(new File("CursosAcabados.JSON"), lista);
            System.out.println("Archivo JSON creado correctamente");
        } catch (IOException ex) {
            Logger.getLogger(LecturaEscrituraFichero.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error");
        }

    }

    public static void leerFicheroTxt() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String idFichero = "CursosAcabados.txt";
        System.out.println("Leyendo fichero de texto: " + idFichero);
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(idFichero);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }


    public static ArrayList leerJSON(String idFichero) {
        System.out.println("----------------------------Leyendo fichero  JSON---------------------------------------");
        ArrayList<ActividadesFormativasAcabadas> listaActividadesFormativas = new ArrayList<>();

        try {
            ObjectMapper mapeador = new ObjectMapper();
            //vamos guardando en la lista lo que vamos leyendo del archivo llamado idFichero
            listaActividadesFormativas = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, ActividadesFormativasAcabadas.class));

        } catch (IOException ex) {
            Logger.getLogger(ActividadesFormativasAcabadas.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaActividadesFormativas;
    }

    public static void ordenarPorApiStream(ArrayList<ActividadesFormativas> lista) {
        System.out.println("-------------------ORDENACION POR APISTREAM---------------------------------");
        //                  //se ordena la lista por fecha y luego por titulo
//                //se usa el thencompairing
        Comparator<ActividadesFormativas> listaActividadesFormativas
                = Comparator.comparing(ActividadesFormativas::getFechaInicio).thenComparing(Comparator.comparing(ActividadesFormativas::getTitulo));
        lista.stream().sorted(listaActividadesFormativas).forEach(System.out::println);

//
//                  //se ordena la lista por fecha y luego por titulo
//                //se usa el thencompairing
//       Comparator<ActividadesFormativas> porFecha = (c1, c2) -> c1.getFechaInicio().compareTo(c2.getFechaInicio());
//                Comparator<ActividadesFormativas> porTitulo = (d1, d2) -> d1.getTitulo().compareTo(d2.getTitulo());
//                Collections.sort(listaActividadesFormativas, porFecha.thenComparing(porTitulo));
    }

}
