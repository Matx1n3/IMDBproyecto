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
    //--------------------------------------------

    /**
     * Añade un intérprete a la lista
     * @param inter Intérprete a añadir
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
        for (int i = 0; i < listaInterpretes.size(); i++){
            if (listaInterpretes.get(i).getNombre() == nombre){
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
