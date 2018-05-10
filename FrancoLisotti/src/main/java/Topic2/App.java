package Topic2;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RecentFileList milista= new RecentFileList();
        int rta=-1;

        while (rta!=0){

            System.out.println("\nIngrese numero");
            System.out.println("1 - Agregar un archivo");
            System.out.println("0 - Salir");
            Scanner sc = new Scanner(System.in);
            rta = sc.nextInt ();
            String archivo;

            switch (rta) {
                case 1:
                    System.out.println("Ingrese nombre del archivo y extension a agregar");
                    sc = new Scanner(System.in);
                    archivo = sc.nextLine();
                    milista.addFile(archivo);
                    break;
                case 0:
                    break;
            }

        }


    }
}
