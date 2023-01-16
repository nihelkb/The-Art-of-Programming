import java.util.Scanner;

public class arbol {

    //private static boolean correcto = true;
   
    public static void insertarArbol(Nodo cabeza, Scanner sc){
        
        int valor = sc.nextInt();
        if(valor != -1){
            cabeza.n_iz = new Nodo(valor);
            insertarArbol(cabeza.n_iz, sc);
        }

        valor = sc.nextInt();
        if(valor != -1){
            cabeza.n_der = new Nodo(valor);
            insertarArbol(cabeza.n_der, sc);
        }
    }

    public static boolean compruebaBusq(Nodo cabeza, int min, int max){
        if(cabeza != null){
            if((min != -1 && cabeza.valor <= min) || (max != -1 && cabeza.valor >= max)){
                return false;
            }
            boolean izquierda = compruebaBusq(cabeza.n_iz, min, cabeza.valor);
            boolean derecha = compruebaBusq(cabeza.n_der, cabeza.valor, max);
            return izquierda && derecha;
        }
        return true;
    }

    public static void main(String[] args) {
        int nCasos;        
        try(Scanner sc = new Scanner(System.in)) {
            nCasos = sc.nextInt();
            //System.out.println(nCasos);
            while(nCasos > 0){
                //System.out.println(nCasos);
                Nodo raiz = new Nodo(sc.nextInt());
                if(raiz.valor != -1){
                    insertarArbol(raiz, sc);
                    boolean correcto = compruebaBusq(raiz, -1, -1);
                    if(correcto){
                        System.out.println("SI");
                    }else{
                        System.out.println("NO");
                    }
                }else{
                    System.out.println("SI");
                }
                nCasos--;
            }  
        
        } catch (Exception e) {
            System.exit(1);
        }
    }
}

class Nodo{
    int valor;
    Nodo n_iz;
    Nodo n_der;

    public Nodo(int valor){
        this.valor = valor;
        n_iz = null;
        n_der = null;
    }

    public String toString() {
        return String.valueOf(valor);
    }
}