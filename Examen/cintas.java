import java.util.Scanner;

public class cintas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacidad, nJuegos;
        Integer[] tamaños;
        // Leer el número de casos de prueba
        while(sc.hasNextInt()){
            capacidad = sc.nextInt();   // Tamaño maximo cara
            nJuegos = sc.nextInt();     // Numero de juegos a copiar
            if(nJuegos > 8){
                System.out.println("NO");
                return;
            }
            tamaños = new Integer[nJuegos];
            for(int i = 0; i < nJuegos; i++){
                tamaños[i] = sc.nextInt();
            }
            if(puedeGrabarJuegos(tamaños, capacidad, 0, 0, 0, 0)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean puedeGrabarJuegos(Integer[] tamaños, int capacidad, int cap1, int cap2, int j, int procesados) {
        //Arrays.sort(tamaños, Collections.reverseOrder());
        // Recorrer el array de tamaños de los juegos
        int nuevaCapacidad;
        boolean puede;
        if(procesados == tamaños.length){
            return true;
        }
        for(int i = j; i < tamaños.length; i++){
            // Verificar si el juego actual cabe en la primera cara de la cinta
            //System.out.println("cinta1 " + tamAct1 + "+" + tamaños[i] + " = " +(tamAct1 + tamaños[i]));
            //System.out.println("cinta2 " + tamAct2 + "+" + tamaños[i] + " = " + (tamAct2 + tamaños[i]));
            if((nuevaCapacidad = cap1 + tamaños[i]) <= capacidad){
                puede = puedeGrabarJuegos(tamaños, capacidad, nuevaCapacidad, cap2, i+1, procesados+1);
                if(puede){
                    return true;
                }
               // System.out.println("Actualizo cinta1 a " + tamAct1);
            }
            if((nuevaCapacidad = cap2 + tamaños[i]) <= capacidad){
                puede = puedeGrabarJuegos(tamaños, capacidad, cap1, nuevaCapacidad, i+1, procesados+1);
                if(puede){
                    return true;
                }
               // System.out.println("Actualizo cinta1 a " + tamAct1);
            }
        }
        return false;
    }
}