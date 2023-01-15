package AeR.Sesion1;
import java.io.BufferedInputStream;
import java.util.Scanner;

// Pijote - 435

public class Pijote {

        public static void main(String [] args){
            try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))){
                int [] comprobacion = new int [10];
                String numero;
                int digito;
                boolean subnormal = true;
                int i = 0;
                while(sc.hasNextLine()){
                    numero = sc.nextLine();
                    i = numero.length();
                    if(i % 10 != 0){
                        System.out.println("no subnormal");
                    }else{
                        for(int k = 0; k < 10; k++){
                            comprobacion[k] = 0;
                        }
                        subnormal = true;
                        for(int j = 0; j < i && subnormal; j++){
                            digito = Character.getNumericValue(numero.charAt(j));
                            comprobacion[digito] += 1;

                            if(comprobacion[digito] > i/10 ){
                                System.out.println("no subnormal");
                                subnormal = false;
                            }
                        }
                        if(subnormal){
                            System.out.println("subnormal");
                        }
                    }  
                }

                }catch(Exception e){
                   // System.out.println("Fallo entrada de datos");
                    System.exit(1);
                }
            }
        }
    
