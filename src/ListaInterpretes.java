import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ListaInterpretes {
    private ArrayList<Interprete> listaInterpretes;

    public ListaInterpretes(ArrayList<Interprete> listaInterpretes) {
        this.listaInterpretes = listaInterpretes;
    }

    //Getters-------------------------------------
    public int getNumDeInterpretes(){
        return listaInterpretes.size();
    }

    public Interprete getInterprete(int i ){
        return listaInterpretes.get(i);
    }
    //--------------------------------------------

    /**
     * Añade un intérprete a la lista
     * @param inter Intérprete a añadir
     *
     *     if s1 > s2, it returns positive number
     *     if s1 < s2, it returns negative number
     *     if s1 == s2, it returns 0
     */
    public void anadirInterprete(Interprete inter){
        listaInterpretes.add(inter);
    }

    /**
     * Busca un intérprete en la lista y lo devuelve
     * @param nombre Nombre del intérprete a buscar
     * @return el Interprete (si está en la lista), null en caso contrario
     */
    public Interprete buscarInterprete(String nombre){
        int from = 0;
        int to = listaInterpretes.size()-1;
        int midVal = (from+to)/2;
        while(from <= to){
            if (listaInterpretes.get(midVal).getNombre().compareTo(nombre) > 0) { //Mirar a la izk
                to = midVal-1;
            }
            else if (listaInterpretes.get(midVal).getNombre().compareTo(nombre) < 0){ //Mirar a la drch
                from = midVal+1;
            }
            else {
                //Peli encontrada
                return listaInterpretes.get(midVal);
            }
            midVal = (from+to)/2;
        }
        return null;
    }

    public String toString(){
        String returnString = "";
        for (int i = 0; i < listaInterpretes.size(); i++){
            returnString = returnString + "\n" + listaInterpretes.get(i);
        }
        return returnString;
    }

    public void sort(){
        Collections.sort(listaInterpretes);
    }
}
