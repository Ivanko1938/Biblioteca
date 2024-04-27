package catbibliot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Catalogo {

    private static String[] tema = new String[100];
    private static String opcionCat = "";

    public Catalogo() {

        for (int i = 0; i < 100; i++) {
            tema[i] = "";
        }

    }

    public static void setTema(int i, String tm) {
        tema[i] = tm;
    }

    public String[] getTema() {
        return tema;
    }

    public static void mostrarMenuCat() {

        boolean salirCatalogo = false;

        while (!salirCatalogo) {
            menuCatalogo();
            if (opcionCat.equals("9")) {
                salirCatalogo = true;
            }
        }

    }

    public static void menuCatalogo() {

        Scanner scan = new Scanner(System.in);

        // Menú Biblioteca
        System.out.print("\n    CATALOGO DE LIBROS  \n");
        System.out.print("    ================== \n");
        System.out.print("   1. Listado de temas del Catálogo \n");
        System.out.print("   2. Añadir tema al Catálogo \n");
        System.out.print("   3. Agregar libros al Catálogo \n");
        System.out.print("   4. Consultar número de libros del Catálogo \n");
        System.out.print("   5. Eliminar libro del Catálogo \n");
        System.out.print("   6. Listado de libros del Catálogo \n");
        System.out.print("   8. Exportar a fichero CATALOGO los libros del Catálogo \n");
        System.out.print("   9. Volver al Menú de la Biblioteca \n");

        System.out.print("     \n");
        System.out.print("    Seleccione una opción : ");

        opcionCat = scan.nextLine();

        switch (opcionCat) {
            case "1":
                System.out.println("\nOpción 1 : Listado de TEMAS del Catálogo");
                listadoTemas();
                opcionCat = "1";
                break;
            case "2":
                System.out.println("\nOpción 2 : Añadir Tema al Catálogo");
                anadirTema();
                opcionCat = "2";
                break;
            case "3":
                System.out.println("\nOpción 3 : Agregar libro al Catálogo");
                agregarLibros();
                opcionCat = "3";
                break;
            case "4":
                System.out.println("\nOpción 4 : Consultar libros del Catálogo");
                consultarCatalogo();
                opcionCat = "4";
                break;
            case "5":
                System.out.println("\nOpción 5 : Eliminar libro del Catálogo");
                eliminarLibCatalogo();
                opcionCat = "5";
                break;
            case "6":
                System.out.println("\nOpción 6 : Listado de libros del Catálogo");
                listadoCatalogo();
                opcionCat = "6";
                break;
            case "8":
                System.out.println("\nOpción 8 : Exportado a CATALOGO los libros del Catálogo");
                exportarCatalogo();
                opcionCat = "8";
                break;
            case "9":
                System.out.println("Volviendo al Menú de la Biblioteca");
                opcionCat = "9";
                break;
            default:
                System.out.println("Opción inválida. Por favor, seleccione una opción válida.");
        }


    }

    public static void listadoTemas() {

        for (int i = 0; i < 100; i++) {
            if (tema[i] != "") {
                System.out.println("Tema " + i + ". " + tema[i]);
            }
        }
    }

    public static void anadirTema() {

        Scanner scan = new Scanner(System.in);
        String txt;

        for (int i = 0; i < 100; i++) {
            if (tema[i].equals("")) {
                System.out.println("Nuevo tema del Catálogo  : ");
                txt = scan.nextLine();
                tema[i] = txt;
                break;
            }
        }
    }

    public static void agregarLibros() {

        Scanner scan = new Scanner(System.in);
        int n = 900;
        String isb, tem;
        boolean encontrado = false;

        System.out.println("Introduzca el ISBN del libro a agregar al Catálogo : ");
        isb = scan.nextLine();

        Libros lib = new Libros();

        for (int i = 0; i < 100; i++) {
            if (lib.isbn[i].equals(isb)) {
                n = i;
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("\n¡¡ Libro no encontrado !!");
        } else {
            System.out.println("\nIntroduzca Número del Tema del Catálogo para el libro \n" +
                    "     [" + lib.titulo[n] + "]\n     o pulse INTRO para cancelar");
            tem = scan.nextLine();
            if (!tem.equals("")) {
                lib.setTemaCat(n, Integer.parseInt(tem));
            }
        }
    }

    public static void consultarCatalogo() {

        int contador = 0;
        Libros lib = new Libros();

        for (int i = 0; i < 100; i++) {
            if (lib.temaCat[i] < 100) {
                contador++;
                System.out.println("    [" + lib.titulo[i] + "]");
            }
        }

        System.out.println("Total de libros en el Catalogo : " + contador);
    }

    public static void eliminarLibCatalogo() {

        Scanner scan = new Scanner(System.in);
        int n = 900;
        String isb, tem;
        boolean encontrado = false;

        System.out.println("Introduzca el ISBN del libro a eliminar del Catálogo : ");
        isb = scan.nextLine();

        Libros lib = new Libros();

        for (int i = 0; i < 100; i++) {
            if (lib.isbn[i].equals(isb)) {
                n = i;
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("  ¡¡ Libro no encontrado !!");
        } else {
            lib.setTemaCat(n, 900);
            System.out.println("El libro [" + lib.titulo[n] + "] ha sido eliminado del Catálogo !!");
        }
    }

    public static void listadoCatalogo() {


        Libros lib = new Libros();

        for (int t = 0; t < 100; t++) {

            if (!tema[t].equals("")) {
                System.out.println("\nTEMA : " + tema[t]);
                for (int i = 0; i < 100; i++) {
                    if (lib.temaCat[i] == t) {

                        //System.out.println("    [" + lib.titulo[i] + "]");
                        if (lib.titulo[i] != "") {

                            System.out.println("\nTítulo    : " + lib.titulo[i]);
                            System.out.println("Autor     : " + lib.autor[i]);
                            System.out.println("ISBN      : " + lib.isbn[i]);
                            System.out.println("Páginas   : " + lib.numPaginas[i]);
                            System.out.println("Editorial : " + lib.editorial[i]);
                            System.out.println("Tema      : " + tema[t]);
                        }
                    }
                }
            }
        }
    }

    public static void exportarCatalogo() {

        String tab;
        String Fichero = "Catalogo.txt";

        try {
            FileWriter f = new FileWriter(Fichero);

            tab = "\n";
            tab = tab + "Fichero con todos los libros del CATALOGO" + "\n";

            Libros lib = new Libros();

            for (int t = 0; t < 100; t++) {
                if (!tema[t].equals("")) {
                    tab = tab + "\nTEMA : " + tema[t] + "\n";
                    for (int i = 0; i < 100; i++) {
                        if (lib.temaCat[i] == t) {
                            if (lib.titulo[i] != "") {

                                tab = tab + "\nTítulo    : " + lib.titulo[i] + "\n";
                                tab = tab + "Autor     : " + lib.autor[i] + "\n";
                                tab = tab + "ISBN      : " + lib.isbn[i] + "\n";
                                tab = tab + "Páginas   : " + lib.numPaginas[i] + "\n";
                                tab = tab + "Editorial : " + lib.editorial[i] + "\n";
                                tab = tab + "Tema      : " + tema[t] + "\n";
                            }
                        }
                    }
                }
            }

            f.write(tab);
            f.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
