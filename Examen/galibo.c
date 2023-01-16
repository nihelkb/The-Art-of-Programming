#include <stdio.h>

int main (void){
    int nPuentes, nCarriles, valorCarril, i, j;
    int min = 9999, max = 0;
   while(scanf("%d", &nPuentes) && nPuentes != 0){
        for(j = 0; j <nPuentes; j++){
            scanf("%d", &nCarriles);
            for(i = 0; i < nCarriles; i++)
            {
                scanf("%d", &valorCarril);
                max = valorCarril > max ? valorCarril : max;
                //printf("max = %d\n", max);
            }
            min = min > max ? max : min;
            //printf("min = %d\n", min);
            max = 0;
        }
        printf("%d\n", min);
        min = 9999;
   }
    return 0;
}