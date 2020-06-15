import java.util.*;


public class danger
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] order = new int[M];
        for (int i = 0; i < M; i++)
        {
            order[i] = sc.nextInt() - 1;
        }

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        for (int k = 0; k < N; k++)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        int danger = 0;
        for (int i = 1; i < M; i++)
        {
            danger += matrix[order[i-1]][order[i]];
        }
        System.out.println(danger);

    }

}