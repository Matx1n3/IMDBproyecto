import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class CatalogoIMDB {
    //Hacer singleton
    private ListaPeliculas listaPeliculas;
    private ListaInterpretes listaInterpretes;

    //Constructor----------------------
    public CatalogoIMDB(){
        listaPeliculas = new ListaPeliculas(new ArrayList<Pelicula>());
        listaInterpretes = new ListaInterpretes(new ArrayList<Interprete>());
    }
    //---------------------------------

    //Getters--------------------------
    public int cantidadDePelisEnCatalogo(){
        return listaPeliculas.cantidadDePeliculas();
    }
    //---------------------------------

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
                Pelicula peliAnadir = new Pelicula(lineaSeparada[0], Integer.parseInt(lineaSeparada[1]), Float.parseFloat(lineaSeparada[2]), Integer.parseInt(lineaSeparada[3]));
                listaPeliculas.añadirPelicula(peliAnadir);
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
    public void cargarInterpretes(String nomF) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(new FileReader(nomF));
            String linea;
            while (sc.hasNext()){
                linea = sc.nextLine();
                String[] lineaSeparada = linea.split("->"); //lineaSeparada[0] = nombreInterprete; lineaSeparada[1] = String de pelis separadas por "||"
                String[] pelisSeparadas = lineaSeparada[1].split("\\|\\|");
                listaInterpretes.anadirInterprete(new Interprete(lineaSeparada[0], new ListaPeliculas()));
                for (int i = 0; i < pelisSeparadas.length; i++){
                    if (listaPeliculas.buscarPelicula(pelisSeparadas[i]) != null) { //If peli is in database
                        listaInterpretes.getInterprete(listaInterpretes.getNumDeInterpretes()-1).anadirPelicula(listaPeliculas.buscarPelicula(pelisSeparadas[i]));  //Añadir peli a interprete
                        listaInterpretes.getInterprete(listaInterpretes.getNumDeInterpretes()-1).getPelicula(i).anadirInterprete(listaInterpretes.getInterprete(listaInterpretes.getNumDeInterpretes()-1)); //Añadir interprete a peli
                    }
                }
            }
            sc.close();

        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    /**
     * Imprime por pantalla el nº de intérpretes de una película y sus nombres
     * @param titulo Título de la película
     */
    public void imprimirInfoPelicula(String titulo){
        System.out.println(listaPeliculas.buscarPelicula(titulo));
    }

    /**
     * Imprime por pantalla el nombre del intérprete, su rating y los títulos
     * de sus películas.
     * @param nombre Nombre del intérprete
     */
    public void imprimirInfoInterprete(String nombre){
        System.out.println(listaInterpretes.buscarInterprete(nombre));
    }

    /**
     * Añade un nuevo voto a una película
     * PRE: el valor del voto está entre 0.0 y 10.0.
     * @param titulo Título de la película
     * @param voto Valor del voto
     */
    public void anadirVoto(String titulo, float voto){
        Pelicula peli = listaPeliculas.buscarPelicula(titulo);
        peli.setRating(((peli.getRating() * peli.getNumvotos())+1)/(peli.getNumvotos()+1));
        peli.actualizarRatingsInterpretes();
    }

    public void imprimirListaPeliculas(){   //Solo para probar, ELIMINAR luego
        for (int i = 0; i < listaPeliculas.cantidadDePeliculas(); i++){
            System.out.println("Peli " + i + " =    " + listaPeliculas.getPelicula(i).getTitulo());
        }
    }

    public void buscarPeli(String titulo_in){   //Solo para probar, ELIMINAR luego
        System.out.println("Buscando " + titulo_in + ": ");
        System.out.println(listaPeliculas.buscarPelicula(titulo_in).getTitulo());
    }

    public void printListaInterpretes(){
        for (int i = 0; i < listaInterpretes.getNumDeInterpretes(); i++){
            System.out.println("Interprete " + i + ": " + listaInterpretes.getInterprete(i).getNombre());
        }
    }
}
