#include <stdio.h>

int main (void){
    int nCasos;
    int mayor1, mayor2;
    int menor1, menor2;
    int parche1, parche2;
    scanf("%d", &nCasos);
    while(nCasos > 0){
        scanf("%d.%d.%d", &mayor1, &menor1, &parche1);
        scanf("%d.%d.%d", &mayor2, &menor2, &parche2);
        if(mayor1 == mayor2){
            if(menor1 == menor2){
                if(parche1 == parche2 - 1){
                    printf("SI\n");
                }else{
                    printf("NO\n");
                }
            }else{
                if(menor1 == menor2-1 && parche2 == 0){
                    printf("SI\n");
                }else{
                    printf("NO\n");
                }
            }
        }else{
            if(mayor1 == mayor2-1 && menor2 == 0 && parche2 == 0){
                printf("SI\n");
            }else{
                printf("NO\n");
            }
        }
        nCasos--;
    }
    return 0;
}