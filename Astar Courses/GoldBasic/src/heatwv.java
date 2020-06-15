import java.util.Scanner;

public class heatwv
{
    public static int V,E,S,D;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int S = sc.nextInt() -1;
        int D = sc.nextInt() -1;

        int[][] graph = new int[V][V];

        for (int i = 0; i < E; i++)
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

        int[] dist = dijkstra(graph,S);
        System.out.println(dist[D]);

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
