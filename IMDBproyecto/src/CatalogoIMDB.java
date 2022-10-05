import java.io.FileNotFoundException;
import java.io.FileReader;
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
                Pelicula peliAñadir = new Pelicula();
            }
        }
        catch (FileNotFoundException e){

        }

    }
}
