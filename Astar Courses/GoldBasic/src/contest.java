import java.util.*;

public class contest
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();

        int[][] graph = new int[N][N];
        for (int i = 0; i < M; i++)
        {
            graph[in.nextInt() - 1][in.nextInt() - 1] = 1;
        }

        // Floyd-Warshall
        for (int k = 0; k < N; k++)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (graph[i][k] == 1 && graph[k][j] == 1)
                        graph[i][j] = 1;
                }
            }
        }

        int count = 0;
        for (int c = 0; c < N; c++)
        {
            boolean ans = true;
            for (int d = 0; d < N; d++)
            {
                if (d == c)
                    continue;
                if (graph[c][d] == 0 && graph[d][c] == 0)
                    ans = false;
            }
            if (ans)
                count++;
        }

        System.out.println(count);

    }

}