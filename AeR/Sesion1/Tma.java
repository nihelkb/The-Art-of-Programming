package AeR.Sesion1;
import java.util.Scanner;

// Triángulo mayor área - 350

public class Tma {

    static float calculoArea(int a, int b){
        return (float)(a*b)/2;
    }

    public static void main(String[] args) throws Exception {
        // try with resources
        try {
            Scanner sc = new Scanner(System.in);
    //  try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1*1024))){ // Lee 1024 y lo guarda en un buffer para leer de archivo (+ eficiente)
            int a, b;
            while (sc.hasNextLine()) {
                a = sc.nextInt();
                if (a == 0) {
                    break;
                }
                b = sc.nextInt();
                System.out.println(calculoArea(a, b));
            }
            sc.close();
        } catch (Exception e) { 
            System.exit(1);
        }
        
    }
}