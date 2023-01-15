#include <stdio.h>

enum operationTypes {nop = 0,divi,mult,suma,rest};

int getPartialRes(const char op, const int opa, const int opb)
{
    int res;
    switch (op)
    {
        case divi:
            res = opa / opb;
            break;
        case mult:
            res = opa * opb;
            break;
        case rest:
            res = opa - opb;
            break;
        case suma:
            res = opa + opb;
            break;
        default:
            res = 0;
    }
    return res;
}

int main()
{
    unsigned char i, j, k, l, res;
    int operandos[5];
    int valorEsperado;
    while (scanf("%d",&valorEsperado)>0)
    {
        for(i = 0; i<5;i++)
        {
            scanf("%d",&operandos[i]);
        }

        char currentPermutation[4] = {nop, nop, nop, nop};
        int partialRes[3] = {0,0,0};
        res = 0;
        for(i = 0;!res&&i<4;i++)
        {
            if(++currentPermutation[0]==divi && (operandos[1] == 0 || operandos[0]%operandos[1]!=0))
            {
                continue;
            }
            partialRes[0] = getPartialRes(currentPermutation[0],operandos[0],operandos[1]);
            for (j = 0;!res&&j<4;j++)
            {
                if(++currentPermutation[1]==divi && (operandos[2] == 0 || partialRes[0]%operandos[2]!=0))
                {
                    continue;
                }
                partialRes[1] = getPartialRes(currentPermutation[1],partialRes[0],operandos[2]);
                for (k = 0;!res&&k<4;k++)
                {
                    if(++currentPermutation[2]==divi && (operandos[3] == 0 || partialRes[1]%operandos[3]!=0))
                    {
                        continue;
                    }
                    partialRes[2] = getPartialRes(currentPermutation[2],partialRes[1],operandos[3]);
                    for (l = 0;!res&&l<4;l++)
                    {
                        if(++currentPermutation[3]==divi && (operandos[4] == 0 || partialRes[2]%operandos[4]!=0))
                        {
                            continue;
                        }
                        res = (getPartialRes(currentPermutation[3],partialRes[2],operandos[4])==valorEsperado);
                    }
                    currentPermutation[3] = nop;
                }
                currentPermutation[2] = nop;
            }
            currentPermutation[1] = nop;
        }
        if(res)
            printf("SI\n");
        else
            printf("NO\n");
    }
    return 0;
}