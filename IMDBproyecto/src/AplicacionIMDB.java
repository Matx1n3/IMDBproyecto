//package fase1;

import java.util.Scanner;

public class AplicacionIMDB {

    public static void main(String[] args){

        //TO DO: ...
        CatalogoIMDB catalogo = new CatalogoIMDB();
        //TO DO: Cargar pel�culas
        catalogo.cargarPeliculas("/home/matxin/WorkSpace/Uni/EDA/IMDBproyecto/IMDBproyecto/smallerfiles/films_tiny.txt");
        //TO DO Cargar int�rpretes
        catalogo.cargarInterpretes("/home/matxin/WorkSpace/Uni/EDA/IMDBproyecto/IMDBproyecto/smallerfiles/cast_tiny.txt");

        System.out.println("Printing lista de interpretes...");
        catalogo.printListaInterpretes();


        //Men�
        Scanner sc = new Scanner(System.in);
        int opcion=-1;

        while(opcion!=0) {
            System.out.println("Escoja una opcion:");
            System.out.println("1. Mostrar informaci�n de pelicula");
            System.out.println("2. Mostrar informaci�n de interprete");
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
            }
        }
        sc.close();


    }

}
