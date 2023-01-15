#include <stdio.h>

int main()
{
    unsigned long long casos, i;
    int amin, amax, bmin, bmax, temp;
    scanf("%llu", &casos);
    for(i=0;i<casos;i++)
    {
        scanf("%d %d %d %d", &amin, &amax, &bmin, &bmax);
        if(amin>amax)
        {
            temp = amax;
            amax = amin;
            amin = temp;
        }
        if(bmin>bmax)
        {
            temp = bmax;
            bmax = bmin;
            bmin = temp;
        }

        if(amax<=bmin || bmax<=amin)
        {
            printf("SEPARADOS\n");
        }
        else
        {
            printf("SOLAPADOS\n");
        }

    }
    return 0;
}