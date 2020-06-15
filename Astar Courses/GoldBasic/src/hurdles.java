import java.util.Arrays;
import java.util.Scanner;

public class hurdles
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int T = sc.nextInt();

        int[][] matrix = new int[N + 1][N + 1];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                matrix[i][j] = 0;
            }
        }
        int x,y,z;
        for (int i = 0; i < M; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();
            z = sc.nextInt();
            matrix[x][y] = z;
        }

        System.out.println();
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }

        for (int k = 1; k <= N; k++)
        {
            for (int i = 1; i <= N; i++)
            {
                for (int j  = 1; j <= N; j++)
                {
                    if((matrix[i][k] > 0 && matrix[k][j] > 0) || matrix[i][j] > Math.max(matrix[i][k],matrix[k][j]))
                    {
                        matrix[i][j] = Math.max(matrix[i][k], matrix[k][j]);
                    }

                }
            }
        }


        System.out.println();
        for (int i = 0; i < matrix.length; i++)
        {
            System.out.println(Arrays.toString(matrix[i]));
        }

        for (int i = 0; i < T; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();
            System.out.println(matrix[x][y]);
        }

    }
}
