package Week1;

import java.util.*;

public class pie1
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] mat = new int[R + 2][C + 2];
        int[][] val = new int[R + 2][C + 2];

        for(int i = 0; i <= R + 1; i++)
        {
            for(int j = 0; j <= C + 1; j++)
            {
                val[i][j] = 0;
                if(i == 0 || j == 0)
                    continue;
                if(i > R || j > C)
                    continue;
                mat[i][j] = sc.nextInt();
            }
        }

        val[R][C] = mat[R][C];
        for(int j = C - 1; j >= 0; j--)
        {
            for(int i = 1; i <= R; i++)
            {
                if(!((i <= j) && (j-i <= C-R)))
                    continue;
                val[i][j] = mat[i][j] + Math.max(Math.max(val[i-1][j+1],val[i][j+1]),val[i+1][j+1]);
            }
        }

        System.out.println(val[1][1]);
    }
}