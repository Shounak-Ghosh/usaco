import java.util.Scanner;

public class cgiving2
{

    private static int N,M,B;
    private static int[][] graph;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        B = sc.nextInt();
        graph = new int[N][N];

        for (int i = 0; i < M; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int c = sc.nextInt();

            if(graph[a][b] == 0)
            {
                graph[a][b] = c;
                graph[b][a] = c;
            }
            else if(c < graph[a][b])
            {
                graph[a][b] = c;
                graph[b][a] = c;
            }
        }

        int[] dist = dijkstra(graph,0);

        for (int i = 0; i < B; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            System.out.println(dist[a] + dist[b]);
        }

    }

    static int[] dijkstra(int[][] graph, int src)
    {
        int[] dist = new int[graph.length];

        boolean[] marked = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            marked[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < graph.length - 1; count++)
        {
            int min = Integer.MAX_VALUE, min_index = -1;

            for (int v = 0; v < graph.length; v++)
            {
                if (!marked[v] && dist[v] <= min)
                {
                    min = dist[v];
                    min_index = v;
                }
            }

            int u = min_index;

            marked[u] = true;

            for (int v = 0; v < graph.length; v++)
            {
                if (!marked[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

}
