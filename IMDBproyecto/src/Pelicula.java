import java.util.ArrayList;

public class Pelicula {
    private String titulo;
    private int año;
    private float rating;
    private int numvotos;
    private ListaInterpretes listaInterpretes;

    public Pelicula(String titulo_in, int año_in, float rating_in, int numvotos_in){
        titulo = titulo_in;
        año = año_in;
        rating = rating_in;
        numvotos = numvotos_in;

        listaInterpretes = new ListaInterpretes(new ArrayList<Interprete>());
    }

    //Getters----------------------------
    public String getTitulo() {
        return titulo;
    }

    public int getAño(){
        return año;
    }

    public float getRating(){
        return rating;
    }
    public int getNumvotos(){
        return numvotos;
    }
    //-----------------------------------

    //Setters----------------------------
    public void setRating(float newRating){
        rating = newRating;
    }
    //-----------------------------------

    /**
     * Añade un intérprete a la película
     * @param inter Intérprete a añadir
     */
    public void anadirInterprete(Interprete inter){
        listaInterpretes.anadirInterprete(inter);
    }

    /**
     * Añade un nuevo voto a la película.
     * POST: se han recalculado los ratings de sus intérpretes
     * @param voto
     */
    public void anadirVoto(float voto){
        rating = (rating * numvotos + voto) / (numvotos + 1);
        numvotos++;
    }

    public String toString(){
        return "Titulo pelicula: " +  titulo + ", numero de interpretes: " + listaInterpretes.getNumDeInterpretes();
    }

    public void actualizarRatingsInterpretes(){
        for (int i = 0; i < listaInterpretes.getNumDeInterpretes(); i++){
            listaInterpretes.getInterprete(i).calcularRating();
        }
    }

    public int compareTo(Pelicula peli_in){
        return titulo.compareTo(peli_in.titulo);
    }
}
