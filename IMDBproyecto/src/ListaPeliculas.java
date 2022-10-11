import java.util.ArrayList;

public class ListaPeliculas {
    private ArrayList<Pelicula> listaPeliculas;

    public ListaPeliculas(ArrayList<Pelicula> listaPelicula) {
        this.listaPeliculas = listaPelicula;
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
    public Pelicula buscarPelicula(String titulo){  //Cambiar a busqueda bicotomica
        for (int i = 0; i < listaPeliculas.size(); i++) {
            if (listaPeliculas.get(i).getTitulo().equals(titulo)){
                //System.out.println("Film " + titulo + " has been found in the DB!");
                return listaPeliculas.get(i);
            }
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
}
