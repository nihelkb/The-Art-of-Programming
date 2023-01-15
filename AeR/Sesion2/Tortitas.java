package AeR.Sesion2;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Tortitas - 143

public class Tortitas {
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1 * 1024))){
            int num;
            boolean linea = false;   
            boolean fin = false;
            List <Integer> lista = new ArrayList<>();
            while(sc.hasNextLine() && !fin){
                while(!linea && !fin){
                    num = sc.nextInt();
                    if(num != -1){
                        lista.add(num);
                    }else{
                        if(lista.isEmpty()){
                            fin = true;
                        }else{
                            linea = true;
                        }
                    }
                }
                num = sc.nextInt();
                while(num > 0 && !fin){
                    voltear(lista, sc.nextInt());
                    num--;
                }
                if(!fin){
                    System.out.println(lista.get(lista.size()-1));
                }
                lista.clear();
                linea = false;
            }
        }catch (Exception e) {
            // TODO: handle exception
            System.exit(0);
        }
    }

    private static void voltear (List<Integer> lista, int nTortitas){
        //List<Integer> invertidos = new ArrayList<Integer>();
        int [] invertidos = new int [nTortitas];
        int tam = lista.size();
        int tamFinal = tam - nTortitas;
        int j = nTortitas - 1;
        for(int i = tamFinal; lista.size() > tamFinal;){
            invertidos[j] = lista.get(i);
            lista.remove(i);
            j--;
        }
        for(int i = 0; i < invertidos.length; i++){
            lista.add(invertidos[i]);
        }
    }
}
