#include <stdio.h>

int main(void){
    int ncasos,d,m,a;
    scanf("%d", &ncasos);
    while(ncasos > 0){
        scanf("%d/%d/%d", &d, &m, &a);
        if(a % 4 == 0){
            if(!(m == 1 || m == 2 && d < 29)){
                a += 4 - (a % 4);
            }
        }else{
            a += 4 - (a % 4);
        }
        printf("29/02/%04u\n", a);
        ncasos--;
    }
}