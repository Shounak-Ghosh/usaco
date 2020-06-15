package Week1;

import java.util.Arrays;
import java.util.Scanner;

public class pachinko2
{
    static int R;
    static int[][] val;
    static int[][] mat;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        mat = new int[R][R];
        val = new int[R][R];


        for(int i = 0; i < R; i++)
        {
            for (int j = 0; j <= i; j++)
            {
                mat[i][j] = sc.nextInt();
                val[i][j] = -1;
            }
        }

        System.out.println(f(0,0));
    }



    private static int f(int r, int c)
    {
        if(r >= 0 && r < R && c >= 0 && c < R) // bounds check
        {
            if (val[r][c] < 0) // not computed yet
            {
                if (r == R - 1)
                {
                    val[r][c] = mat[r][c];
                }
                val[r][c] = Math.max(f(r + 1, c), f(r + 1, c + 1)) + mat[r][c];
            }

            // visual of the val 2d array
//           for (int i = 0; i < R; i++)
//           {
//               System.out.println(Arrays.toString(val[i]));
//           }
//            System.out.println();

            return val[r][c]; // if already computed, then the value is directly returned when f(r,c) is called
        }
        // does not contribute to the sum if r or c is out of bounds
        return 0;
    }
}
