import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ratones
{
    static int totalRatones = 0;
    public static void main(String[] args)
    {
        try(Scanner sc = new Scanner(new BufferedInputStream(System.in, 1024))){
            int nCeldas, salida, tiempo, pasadizos;
            int a, b, segRaton;
            Union u;
            LinkedList<Union>[] grafo;
            while(sc.hasNext()){
                nCeldas = sc.nextInt();
                salida = sc.nextInt()-1;
                tiempo = sc.nextInt();
                pasadizos = sc.nextInt();
                grafo = new LinkedList[nCeldas];
                for(int i = 0; i<grafo.length; i++)
                {
                    grafo[i] = new LinkedList<>();
                }

                while(pasadizos > 0){
                    b = sc.nextInt()-1; // Se cuenta desde 0 en java :D
                    a = sc.nextInt()-1; // Se cuenta desde 0 en java :D
                    segRaton = sc.nextInt();
                    u = new Union(b,segRaton);
                    grafo[a].add(u);
                    pasadizos--;
                }
                totalRatones = 0;
                int[] tiempos = new int[nCeldas];
                dijkstra(salida,tiempos,grafo);
                for(int i = 0; i<tiempos.length;i++)
                {
                    if(i!=salida && tiempos[i]<=tiempo)
                        totalRatones++;
                }
                System.out.println(totalRatones);

            }
        }catch(Exception e){
            e.printStackTrace();
            System.exit(1);
        }
    }

    static void dijkstra(int salida, int[] tiempos, LinkedList<Union>[] grafo) {
        Arrays.fill(tiempos, Integer.MAX_VALUE);
        PriorityQueue<Union> q = new PriorityQueue<>();
        q.add(new Union(salida, 0));

        while (!q.isEmpty()) {
            Union actual = q.poll();
            for (Union explorar : grafo[actual.to]) {
                int nuevoCoste = actual.time + explorar.time;
                if (nuevoCoste < tiempos[explorar.to]) {
                    tiempos[explorar.to] = nuevoCoste;
                    q.add(new Union(explorar.to, nuevoCoste));
                }
            }
        }
    }

    static class Union implements Comparable<Union>{
        public final int to;
        public final int time;

        Union(int to,int time){
            this.to= to;
            this.time= time;
        }

        @Override
        public int compareTo(Union arista) {
            return this.time - arista.time;
        }
    }
}


