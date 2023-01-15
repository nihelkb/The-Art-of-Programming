package AeR.Sesion2;

import java.io.BufferedInputStream;
import java.util.Scanner;

// División euclídea - 304

public class Dividir {
    
    public static void main (String [] args){
        int casos, dividendo, divisor, cociente, resto;
        try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))){   
            casos = sc.nextInt(); 
            while(casos > 0){
                dividendo = sc.nextInt();
                divisor = sc.nextInt();
                //System.err.println(String.format("%d / %d", dividendo, divisor));
                if(dividendo == 0){
                    System.out.println("0 0");
                }else if(divisor == 0){
                    System.out.println("DIV0");
                }else{
                    cociente = dividendo / divisor;
                    if(dividendo % divisor == 0){
                        resto = 0;
                    }
                    else if(dividendo < 0 && divisor < 0) {
                        cociente++;
                        resto = dividendo - (cociente * divisor);
                    }
                    else if(dividendo < 0) {
                        cociente--;
                        resto = dividendo - (cociente * divisor);
                    }
                    else {
                        resto = dividendo - (cociente * divisor);
                    }
                    System.out.println(cociente + " " + Math.abs(resto));
                }
                casos--;
            }
        }catch (Exception e) {
            // En caso de RTE quitar y poner exit(0)
           // e.printStackTrace();
            System.exit(0);
        }
    }
}