package AeR.Sesion3;

import java.io.BufferedInputStream;
import java.util.Scanner;

// Hoy comemos mejillones - 502

public class Mejillones {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))){
            int nMej, i, j, nMon;
            int[] tamaño;
            int[] montones;
            while(sc.hasNextLine()){
                nMej = sc.nextInt(); // numero mejillones que van a haber
                tamaño = new int [nMej]; 
                montones = new int [nMej];
                i = 0;
                j = 0;
                nMon = 0;
                while(nMej > 0){
                    tamaño[i] = sc.nextInt();
                    if(i == 0){ // el primer elemento siempre forma un monton
                        montones[0] = tamaño[i];
                        nMon++;
                    }else{
                        
                    }
                    nMej--;
                }
            }

        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }
}