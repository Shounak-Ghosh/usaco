import java.util.Scanner;

public class dijkstra
{
    private static int V,E,S;
    private static int[][] graph;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        S = sc.nextInt() - 1;
        graph = new int[V][V];

        for (int i = 0; i < E; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();
            graph[a][b] = c;
            graph[b][a] = c;
        }

        int dist[] = new int[V];
        boolean marked[] = new boolean[V];

        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            marked[i] = false;
        }
        dist[S] = 0;

        for (int i = 0; i < V - 1; i++)
        {
            int min = Integer.MAX_VALUE, mindex = -1;

            for (int j = 0; j < V; j++)
            {
                if (!marked[j] && dist[j] <= min)
                {
                    min = dist[j];
                    mindex = j;
                }
            }
            int u = mindex;

            marked[u] = true;
            for (int j = 0; j < V; j++)
            {
                if (!marked[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j])
                {
                    dist[j] = dist[u] + graph[u][j];
                }
            }
        }

        for (int i = 0; i < V; i++)
        {
            if (dist[i] < Integer.MAX_VALUE)
            {
                System.out.println(dist[i]);
            }
            else
                System.out.println(-1);
        }

    }

}
