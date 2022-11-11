import java.util.ArrayList;

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
     */
    public Pelicula buscarPelicula(String titulo){
        int from = 0;
        int to = listaPeliculas.size()-1;
        int midVal = (from+to)/2;
        while(from <= to){
            if (listaPeliculas.get(midVal).getTitulo().compareTo(titulo) > 0) { //Mirar a la izquierda
                to = midVal-1;
            }
            else if (listaPeliculas.get(midVal).getTitulo().compareTo(titulo) < 0){ //Mirar a la derecha
                from = midVal+1;
            }
            else {  //Peli encontrada
                return listaPeliculas.get(midVal);
            }
            midVal = (from+to)/2;
        }
        return null;
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
