import java.util.ArrayList;

public class Interprete {
    private String nombre;
    private ListaPeliculas listaPeliculas;
    private float rating;

    //Constructor-----------------------------
    public Interprete(String nombre_in, ListaPeliculas listaPeliculas_in){
        nombre = nombre_in;
        listaPeliculas = listaPeliculas_in;
    }
    //-----------------------------------------
    //Getters----------------------------------
    public String getNombre() {
        return nombre;
    }
    //------------------------------------------

    /**
     * Calcula y asigna el rating del intérprete en base al rating de sus películas
     */
    public void calcularRating(){
        int i = 0;
        int nVotos = 0;
        float pRating = 0;
        while (i < listaPeliculas.cantidadDePeliculas()){
            pRating = pRating + listaPeliculas.getPelicula(i).getRating() * listaPeliculas.getPelicula(i).getNumvotos();
            nVotos = nVotos + listaPeliculas.getPelicula(i).getNumvotos();
            i++;
        }
        rating = pRating/nVotos;
    }

    /**
     * Añade una película al intérprete
     * @param pel Película a añadir
     * POST: El rating del intérprete NO se modifica en este momento
     */
    public void anadirPelicula(Pelicula pel){
        listaPeliculas.añadirPelicula(pel);
    }

    public String toString(){
        return "Nombre interprete: " + nombre + ",\nTitulos de las peliculas en las que ha actuado: " + listaPeliculas;
    }
}
