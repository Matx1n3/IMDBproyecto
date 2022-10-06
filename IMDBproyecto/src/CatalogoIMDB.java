import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoIMDB {
    //Hacer singleton
    private ListaPeliculas listaPeliculas;
    private ListaInterpretes listaInterpretes;

    /**
     * Carga las películas del catálogo desde el fichero indicado
     * @param nomF Nombre del fichero que contiene las películas
     */
    public void cargarPeliculas(String nomF){
        try {
            Scanner sc = new Scanner(new FileReader(nomF));
            String linea;
            while (sc.hasNext()){
                linea = sc.nextLine();
                String[] lineaSeparada = linea.split("\t");
                Pelicula peliAñadir = new Pelicula(lineaSeparada[0], Integer.parseInt(lineaSeparada[1]), Integer.parseInt(lineaSeparada[2]), Integer.parseInt(lineaSeparada[3]));
                listaPeliculas.añadirPelicula(peliAñadir);
            }
            sc.close();
        }
        catch (FileNotFoundException e){

        }

    }

    /**
     * Carga los intérpretes del catálogo desde el fichero indicado
     * POST: se han cargado los intérpretes y se han calculado sus ratings
     * @param nomF Nombre del fichero que contiene los intérpretes
     */
    public void cargarInterpretes(String nomF){
        try {
            Scanner sc = new Scanner(new FileReader(nomF));
            String linea;
            while (sc.hasNext()){
                linea = sc.nextLine();
                String[] lineaSeparada = linea.split("->"); //lineaSeparada[0] = nombreInterprete; lineaSeparada[1] = String de pelis separadas por "||"
                String[] pelisSeparadas = lineaSeparada[1].split("||");
                ListaPeliculas listaPelisActor = new ListaPeliculas(new ArrayList<Pelicula>());
                for (int i = 0; i < pelisSeparadas.length; i++){
                    listaPelisActor.añadirPelicula(listaPeliculas.buscarPelicula(pelisSeparadas[i]));   //Tener en cuenta NULL
                }
                Interprete interpreteAñadir = new Interprete(lineaSeparada[0], listaPelisActor);
            }
            sc.close();

        } catch (FileNotFoundException e) {
            System.out.println("El fichero " + nomF + " no ha sido encontrado");
            throw new RuntimeException(e);
        }
    }

    /**
     * Imprime por pantalla el nº de intérpretes de una película y sus nombres
     * @param titulo Título de la película
     */
    public void imprimirInfoPelicula(String titulo){
        System.out.println(listaPeliculas.buscarPelicula(titulo));
    }
}
