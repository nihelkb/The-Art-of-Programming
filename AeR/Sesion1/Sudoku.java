package AeR.Sesion1;

import java.io.BufferedInputStream;
import java.util.Scanner;

// Sudoku - 345

public class Sudoku {

    public static void main (String [] args){
        
        try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))){
            int entradas = sc.nextInt();
            int [][] sudoku = new int[9][9];
            boolean [][] numLeido = new boolean [10][10]; // numLeido leidos
            boolean filas = true;
            boolean columnas = true;
            boolean regiones = true;

            while(entradas > 0){
                // ALmaceno el primer sudoku
                for(int i = 0; i < 9 && filas; i++){
                    for(int j = 0; j < 10; j++){
                        numLeido[i][j] = false;
                    }
                    for(int j = 0; j < 9 && filas; j++){
                        sudoku[i][j] = sc.nextInt();
                        if(numLeido[i+1][sudoku[i][j]]){ // Si ya se ha leido antes
                            System.out.println("No");
                            filas = false;
                        }
                        numLeido[i+1][sudoku[i][j]] = true;
                        if(i == 8){ // Ultima fila
                            
                        }
                    }
                    if(filas){
                        if(i == 2 || i == 5 || i == 8){ // Ya se han leido 3 lineas de una region
                            
                        }
                    }
                   
                }
                
                if (filas && columnas && regiones){
                    System.out.println("Si");
                }
                entradas--;
            }

        }catch (Exception e) {
            // TODO: handle exception
            System.exit(1);
        }
    }
}
