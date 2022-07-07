package skip;


import java.util.Scanner;

public class Skip {

    public static void main(String[] args) {

        String s = "Hola Mundo! 3 + 3.0 = 6.0 verdadero ";

        //crea un nuevo escáner con el objeto de cadena especificado
        Scanner scanner = new Scanner(s);


        //Omitir la palabra hola
        scanner.skip("Hola");

        //Imprime una linea de scanner
        System.out.println("" + scanner.nextLine());


        //Cieera el scanner
        scanner.close();

    }

}
