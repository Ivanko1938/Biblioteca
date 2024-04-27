package catbibliot;

import java.util.Scanner;

public class Entrada {

    private static String opcion ="";

    public static void main(String[] args) {

        boolean opcionSalir = false;

        anadirLibros();
        anadirTemas();

        while (!opcionSalir) {
            menuPrincipal();
            if (opcion.equals("9")) {opcionSalir = true;}
        }

    }

    public static void menuPrincipal(){

        Scanner scan = new Scanner(System.in);

        // Menú Biblioteca
        System.out.print("\n    MENU BIBLIOTECA \n");
        System.out.print("    ............... \n");
        System.out.print("   1. Listado de libros \n");
        System.out.print("   2. Añadir libro \n");
        System.out.print("   3. Eliminar libro \n");
        System.out.print("   4. Modificar libro \n");
        System.out.print("   5. Catalogo \n");
        System.out.print("   8. Exportar a fichero LIBROS todos los libros \n");
        System.out.print("   9. Salir \n");

        System.out.print("    ............... \n");
        System.out.print("    Seleccione una opción : ");

        opcion = scan.nextLine();

        switch (opcion) {
            case "1":
                System.out.println("\nOpción 1 : LISTADO DE LIBROS");
                Libros.listarLibros();
                opcion = "1";
                break;
            case "2":
                System.out.println("\nOpción 2 : AÑADIR LIBRO");
                Libros.anadirLibro();
                opcion = "2";
                break;
            case "3":
                System.out.println("\nOpción 3 : ELIMINAR LIBRO");
                Libros.eliminarLibro();
                opcion = "3";
                break;
            case "4":
                System.out.println("\nOpción 4 : MODIFICAR LIBRO");
                Libros.modificarLibro();
                opcion = "4";
                break;
            case "5":
                Catalogo.mostrarMenuCat();
                opcion = "5";
                break;
            case "8":
                System.out.println("\nOpción 8 : EXPORTAR A FICHERO LIBROS");
                Libros.exportarLibros();
                opcion = "4";
                break;
            case "9":
                System.out.println("Saliendo del programa...");
                opcion = "9";
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }

    }

    public static void anadirLibros() {

        Libros lib = new Libros();

        for (int i = 0; i < 100; i++) {
            lib.setTitulo(i, "");
            lib.setAutor(i, "");
            lib.setIsbn(i, "");
            lib.setNumPaginas(i, 0);
            lib.setEditorial(i, "");
            lib.setTemaCat(i, 900);
        }

        lib.setTitulo(0, "El nombre de la Rosa");
        lib.setAutor(0, "Umberto Eco");
        lib.setEditorial(0, "Debolsillo");
        lib.setIsbn(0, "111");
        lib.setNumPaginas(0, 784);
        lib.setTemaCat(0,0);

        lib.setTitulo(1, "El señor de los anillos");
        lib.setAutor(1, "J R Tolkin");
        lib.setEditorial(1, "Minotauro");
        lib.setIsbn(1, "222");
        lib.setNumPaginas(1, 408);

        lib.setTitulo(2, "El médico");
        lib.setAutor(2, "Noah Gordon");
        lib.setEditorial(2, "Roca");
        lib.setIsbn(2, "333");
        lib.setNumPaginas(2, 800);

        lib.setTitulo(3, "El mito de la caverna");
        lib.setAutor(3, "Platon");
        lib.setEditorial(3, "Bolsillo");
        lib.setIsbn(3, "444");
        lib.setNumPaginas(3, 220);
    }

    public static void anadirTemas() {

        Catalogo cat = new Catalogo();

        for (int i = 0; i < 100; i++) {
            cat.setTema(i,"");
        }

        cat.setTema(0,"Novela histórica");
        cat.setTema(1,"Novela fantástica");
        cat.setTema(2,"Novela científica");
        cat.setTema(3,"Filosofía");

    }

}
