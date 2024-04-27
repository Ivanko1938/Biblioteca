package catbibliot;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Libros {

    public static String[] titulo = new String[100];
    public static String[] autor = new String[100];
    public static String[] isbn = new String[100];
    public static int[] numPaginas = new int[100];
    public static String[] editorial = new String[100];
    public static int[] temaCat = new int[100];

    public Libros() {


    }


    public void setTitulo(int i,String tit) {titulo[i] = tit;}
    public String[] getTitulo() {return titulo;}
    public void setAutor(int i, String aut) {autor[i] = aut;}
    public String[] getAutor() {return autor;}
    public void setIsbn(int i, String isb) {isbn[i] = isb;}
    public String[] getIsbn() {return isbn;}
    public void setNumPaginas(int i, int pags) {numPaginas[i] = pags;}
    public int[] getNumPaginas() {return numPaginas;}
    public void setEditorial(int i, String edit) {editorial[i] = edit;}
    public String[] getEditorial() {return editorial;}
    public void setTemaCat(int i, int tm) {temaCat[i] =tm;}
    public int[] getTemaCat() {return temaCat;}

    public static void listarLibros() {

        int contador = 0;

        for (int i = 0; i < 100; i++) {
            if (titulo[i] !="") {
                contador++;
                System.out.println("\nTítulo    : " + titulo[i]);
                System.out.println("Autor     : " + autor[i]);
                System.out.println("ISBN      : " + isbn[i]);
                System.out.println("Páginas   : " + numPaginas[i]);
                System.out.println("Editorial : " + editorial[i]);
                //System.out.println(temaCat[i]);
            }
        }

        System.out.println("\nTOTAL de libros    : " + contador + "\n\n");
    }

    public static void anadirLibro() {

        Scanner scan = new Scanner(System.in);
        String txt;
        int pag;

        for (int i = 0; i < 100; i++) {
            if (titulo[i].equals("")) {
                System.out.println("Título del libro    : ");
                txt = scan.nextLine();
                titulo[i] = txt;
                System.out.println("Autor  del libro   : ");
                txt = scan.nextLine();
                autor[i] = txt;
                System.out.println("ISBN  del libro    : ");
                txt = scan.nextLine();
                isbn[i] = txt;
                System.out.println("Editorial del libro: ");
                txt = scan.nextLine();
                editorial[i] = txt;
                System.out.println("Páginas del libro  : ");
                pag = scan.nextInt();
                numPaginas[i] = pag;
                System.out.println("¡¡ Libro añadido correctamente !! ");
                break;
            }
        }
    }

    public static void eliminarLibro() {

        Scanner scan = new Scanner(System.in);
        boolean encontrado = false;
        String isb;

        System.out.println("Introduzca el ISBN del libro a eliminar : ");
        isb = scan.nextLine();

        for (int i = 0; i < 100; i++) {
            if (isbn[i].equals(isb)) {
                titulo[i] = "";
                autor[i] = "";
                isbn[i] = "";
                editorial[i] = "";
                numPaginas[i] = 0;
                temaCat[i] = 1000;
                System.out.println("¡¡ Libro eliminado !! ");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("¡¡ Libro NO ENCONTRADO !! ");
        }
    }

    public static void modificarLibro() {

        Scanner scan = new Scanner(System.in);
        boolean encontrado = false;
        String isb, txt;
        int pag;

        System.out.println("Introduzca el ISBN del libro a modificar : ");
        isb = scan.nextLine();

        for (int i = 0; i < 100; i++) {
            if (isbn[i].equals(isb)) {
                System.out.println("Título del libro    : " + titulo[i]);
                System.out.println("Introduzca el nuevo Título o pulse INTRO para confirmar el actual");
                txt = scan.nextLine();
                if (!txt.equals("")) {
                    titulo[i] = txt;
                }
                System.out.println("Autor  del libro   : " + autor[i]);
                System.out.println("Introduzca el nuevo Autor o pulse INTRO para confirmar el actual");
                txt = scan.nextLine();
                if (!txt.equals("")) {
                    autor[i] = txt;
                }
                System.out.println("ISBN  del libro    : " + isbn[i]);
                System.out.println("Introduzca el nuevo ISBN o pulse INTRO para confirmar el actual");
                txt = scan.nextLine();
                if (!txt.equals("")) {
                    isbn[i] = txt;
                }
                System.out.println("Editorial del libro: " + editorial[i]);
                System.out.println("Introduzca la nueva Editorial o pulse INTRO para confirmar la actual");
                txt = scan.nextLine();
                if (!txt.equals("")) {
                    editorial[i] = txt;
                }
                System.out.println("Páginas del libro  : " + numPaginas[i]);
                System.out.println("Introduzca las páginas del libro o pulse INTRO para confirmar las actuales");
                txt = scan.nextLine();
                if (!txt.equals("")) {
                    numPaginas[i] = Integer.parseInt(txt);
                }
                System.out.println("¡¡ Libro modificado correctamente !! ");
                encontrado = true;
                break;
            }
        }
         if (!encontrado) {
                System.out.println("¡¡ Libro NO ENCONTRADO !! ");
         }
    }

    public static void exportarLibros() {

        String tab;
        String Fichero = "Libros.txt";

        try {
            FileWriter f = new FileWriter(Fichero);

            tab = "\n";
                tab = tab + "Fichero con todos los LIBROS" + "\n";

            for (int i = 0; i < 100; i++) {
                if (titulo[i] !="") {

                    tab = tab + "\nTítulo    : " + titulo[i] + "\n";
                    tab = tab + "Autor     : " + autor[i] + "\n" ;
                    tab = tab + "ISBN      : " + isbn[i] + "\n";
                    tab = tab + "Páginas   : " + numPaginas[i] + "\n";
                    tab = tab + "Editorial : " + editorial[i] + "\n";
                }
            }
            f.write(tab);
            f.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
