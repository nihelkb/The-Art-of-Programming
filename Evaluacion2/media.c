#include <stdio.h>

int main()
{
    int nExamenes, notaNecesaria, i, res, sumaNotas;
    while (scanf("%d", &nExamenes) && nExamenes > 0){
        sumaNotas = 0;
        for(i = 0; i < nExamenes; i++){
            scanf("%d", &res); 
            sumaNotas += res;
        }
        scanf("%d", &notaNecesaria);
        res = (notaNecesaria*(nExamenes + 1)) - sumaNotas;
        if(res > 10 || res < 0){
            printf("IMPOSIBLE\n");
        }else{
            printf("%d\n", res);
        }    
    }
}