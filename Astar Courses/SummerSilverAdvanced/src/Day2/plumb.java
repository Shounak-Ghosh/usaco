package Day2;

import java.util.Arrays;
import java.util.Scanner;

public class plumb
{
    static int R;
    static int C;
    static int[][] pond;
    static int[] dR = {-1,-1,-1,0,0,1,1,1};
    static int[] dC = {-1,0,1,-1,1,-1,0,1};

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();

        pond = new int[R + 2][ C + 2];

        for(int r = 1; r <= R; r++)
        {
            for(int c = 1; c <= C; c++)
            {
                pond[r][c] = sc.nextInt();
            }
        }

        //printGrid(pond);

        int row = 0;
        int col = 0;

        int maxDepth = 0;

        for(int r = 0; r <= R; r++)
        {
            for(int c= 0; c <= C; c++)
            {
                if(pond[r][c] != 0)
                {
                    for (int k = 0; k < 8; k++)
                    {
                        row = r + dR[k];
                        col = c + dC[k];

                        if(pond[r][c] == pond[row][col])
                        {
                            maxDepth = Math.max(maxDepth,pond[r][c]);
                        }
                    }
                }
            }
        }

        System.out.println(maxDepth);
    }

    public static void printGrid(int[][] grid)
    {
        for(int[] g: grid)
        {
            System.out.println(Arrays.toString(g));
        }
    }
}
