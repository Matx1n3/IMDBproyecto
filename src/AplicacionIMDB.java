//package fase1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AplicacionIMDB {

    public static void main(String[] args){

        CatalogoIMDB catalogo = CatalogoIMDB.getInstance();
        //Cargar pel�culas
        long start = System.nanoTime();
        System.out.println("Loading films...");
        catalogo.cargarPeliculas("/data/smallerfiles/films_medium.txt");
        //Cargar interpretes
        try {
            System.out.println("Loading interpretes...");
            catalogo.cargarInterpretes("//data/smallerfiles/cast_medium.txt");
        }
        catch (FileNotFoundException e){
            System.out.println("El fichero no ha sido encontrado");
        }
        long finish = System.nanoTime();
        System.out.println(catalogo.cantidadDePelisEnCatalogo() + " peliculas y " + catalogo.cantidadDeInterpretesEnCatalogo() + " han sido cargadas en " + ((finish-start)/(10000*100000)) + " segundos");
        Scanner sc = new Scanner(System.in);
        int opcion=-1;

        while(opcion!=0) {
            System.out.println("\n--------------------------------------");
            System.out.println("Escoja una opcion:");
            System.out.println("1. Mostrar informacion de pelicula");
            System.out.println("2. Mostrar informacion de interprete");
            System.out.println("3. Anadir voto a pelicula");
            System.out.println("0. Salir");
            opcion = Integer.parseInt(sc.nextLine());
            switch(opcion) {
                case 1:
                    System.out.println("Escribe el titulo de la pelicula: ");
                    String titulo = sc.nextLine();
                    catalogo.imprimirInfoPelicula(titulo);
                    break;
                case 2:
                    System.out.println("Escribe el nombre del interprete: ");
                    String interprete = sc.nextLine();
                    catalogo.imprimirInfoInterprete(interprete);
                    break;
                case 3:
                    System.out.println("Escribe el titulo de la pelicula: ");
                    String titulo2 = sc.nextLine();
                    System.out.println("Escribe tu valoracion (0.00-10.00): ");
                    float valoriacion = Float.parseFloat(sc.nextLine());
                    catalogo.anadirVoto(titulo2, valoriacion);
                    break;
                case 4:
                    catalogo.imprimirListaPeliculas();
                    break;
                case 5:
                    catalogo.printListaInterpretes();
                    break;
            }
        }
        sc.close();
    }

}
