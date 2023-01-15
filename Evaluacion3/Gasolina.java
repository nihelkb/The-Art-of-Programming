package Evaluacion3;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class Gasolina {

        static int obtenerMax(int[] dEntrada, int[] anterior, int act) {
            int resultado;
            int max = 0;
            if (anterior[act] != 0){
                resultado = anterior[act];
            }else{
                
                for (int i = act + 1; i < dEntrada.length; i++) {
                    if (dEntrada[act] < dEntrada[i]) {
                        max = Math.max(obtenerMax(dEntrada, anterior, i), max);
                    }
                }
                anterior[act] = max + 1;
                resultado = max + 1;
            }
            return resultado;
        }
    
        public static void main(String[] args) {
            try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1024))){
                int n, veces;
                int[] dEntrada, anterior;
        
                while (true) {
                    n = sc.nextInt();
                    if (n == 0){
                        break;
                    }
        
                    dEntrada = new int[n];
                    anterior = new int[n];
        
                    for (int i = 0; i < n; i++){
                        dEntrada[i] = sc.nextInt();
                    }

                    veces = 0;
                    for (int i = 0; i < n; i++) {
                        veces = Math.max(veces, obtenerMax(dEntrada, anterior, i));
                    }
                    System.out.println(veces);
                }
            }catch(Exception e){
                e.printStackTrace();
                System.out.println(e);
                System.exit(1);
            }
        }
    }
