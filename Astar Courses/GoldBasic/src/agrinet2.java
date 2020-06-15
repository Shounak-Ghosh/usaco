import java.util.Arrays;
import java.util.Scanner;


public class agrinet2
{
    private static int N;
    private static int[][] path;

    public static void main(String[] args)
    {

        Scanner sc = new Scanner (System.in);
        N = sc.nextInt();
        path = new int[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                path[i][j] = sc.nextInt();
            }
        }

        int[] dist = new int[N];
        boolean[] visited = new boolean[N];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int cost = 0;
        while (true)
        {
            int e = -1;
            for (int i = 0; i < N; i++)
            {
                if (visited[i])
                    continue;
                if (e == -1 || dist[i] < dist[e])
                {
                    e = i;
                }
            }
            if (e == -1)
                break;
            cost += dist[e];
            visited[e] = true;
            for (int i = 0; i < N; i++)
            {
                if (visited[i])
                    continue;
                if (path[e][i] < dist[i])
                    dist[i] = path[e][i];
            }
        }

        System.out.println(cost);
    }

}