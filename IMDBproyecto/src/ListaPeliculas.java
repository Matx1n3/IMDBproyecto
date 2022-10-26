import java.util.ArrayList;
import java.util.List;

public class ListaPeliculas {
    private ArrayList<Pelicula> listaPeliculas;

    public ListaPeliculas(ArrayList<Pelicula> listaPelicula) {
        this.listaPeliculas = listaPelicula;
    }

    public ListaPeliculas(){
        listaPeliculas = new ArrayList<Pelicula>();
    }

    //Getters--------------------------------
    public int cantidadDePeliculas(){
        return listaPeliculas.size();
    }

    public Pelicula getPelicula(int i){
        return listaPeliculas.get(i);
    }
    //---------------------------------------

    /**
     * Añade una película a la lista
     * @param peli_in Película a añadir
     */
    public void añadirPelicula(Pelicula peli_in){
        listaPeliculas.add(peli_in);
        //System.out.println("Pelicula a añadir: " + peli_in.getTitulo());
    }

    /**
     * Busca una película en la lista y la devuelve
     * @param titulo Título de la película a buscar
     * @return la Película (si está en la lista), null en caso contrario
     *
     *            if s1 > s2, it returns positive number
     *      *     if s1 < s2, it returns negative number
     *      *     if s1 == s2, it returns 0
     */
    public Pelicula buscarPelicula(String titulo){  //Revisar la busqueda bicotomica
        int from = 0;
        int to = listaPeliculas.size();
        int midVal;
        while (from < to) {
            midVal = ((to - from) / 2) + from;
            int comp = listaPeliculas.get(midVal).getTitulo().compareTo(titulo);
            if (comp > 0) {//Mirar a la izquierda
                to = midVal;
            } else if (comp < 0) { //Mirar la derecha
                from = midVal;
            } else {
                return listaPeliculas.get(midVal);
            }
        }
        return null;

        /**
        for (int i = 0; i < listaPeliculas.size(); i++) {
            if (listaPeliculas.get(i).getTitulo().equals(titulo)){
                //System.out.println("Film " + titulo + " has been found in the DB!");
                return listaPeliculas.get(i);
            }
        }
         **/
        //return null;
    }

    public String toString(){
        String returnString = "";
        for (int i = 0; i < listaPeliculas.size(); i++){
            returnString = returnString + "\n" + listaPeliculas.get(i);
        }
        return returnString;
    }

    public String toStringTitles(){
        String returnString = "";
        for (int i = 0; i < listaPeliculas.size(); i++){
            returnString = returnString + "\n" + listaPeliculas.get(i).getTitulo();
        }
        return returnString;
    }
}
