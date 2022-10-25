import java.util.ArrayList;

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
        /**
        int i = 0;
        while(i < listaInterpretes.size() && listaInterpretes.get(i).compareTo(inter) < 0){
            i++;
        }
        listaInterpretes.add(i, inter);
         **/
        listaInterpretes.add(inter);
    }

    /**
     * Busca un intérprete en la lista y lo devuelve
     * @param nombre Nombre del intérprete a buscar
     * @return el Interprete (si está en la lista), null en caso contrario
     */
    public Interprete buscarInterprete(String nombre){  //Hacer dicotomico
        for (int i = 0; i < listaInterpretes.size(); i++){
            if (listaInterpretes.get(i).getNombre().equals(nombre)){
                return listaInterpretes.get(i);
            }
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
}
