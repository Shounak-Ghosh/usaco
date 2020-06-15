import java.util.*;

public class irrigation
{

    private static final int INF = 999999999;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // read input
        int V = sc.nextInt();
        int C = sc.nextInt();
        int[][] coordinates = new int[V][2];
        for (int i = 0; i < V; i++)
        {

            coordinates[i][0] = sc.nextInt();
            coordinates[i][1] = sc.nextInt();
        }

        boolean[] visited = new boolean[V];

        int start = 0;

        int[] distances = new int[V];
        for (int i = 0; i < V; i++)
        {
            int dX = coordinates[i][0] - coordinates[start][0];
            int dY = coordinates[i][1] - coordinates[start][1];
            distances[i] = dX*dX + dY*dY;
            if (distances[i] < C)
            {
                distances[i] = INF;
            }
        }
        visited[start] = true;
        distances[start] = 0;
        int cost = 0;

        // loop V-1 times
        for (int i = 1; i < V; i++)
        {
            // find the optimal vertex (minimum distance)
            int index = 0, distance = INF;
            boolean foundOne = false;
            for (int j = 0; j < V; j++)
            {
                if (distances[j] >= C && distances[j] < distance && !visited[j])
                {
                    distance = distances[j];
                    index = j;
                    foundOne = true;
                }
            }
            if (!foundOne)
            {
                System.out.println(-1);
                System.exit(0);
            }

            visited[index] = true;
            cost += distances[index];

            for (int j = 0; j < V; j++)
            {
                int dX = coordinates[j][0] - coordinates[index][0];
                int dY = coordinates[j][1] - coordinates[index][1];
                if (dX*dX + dY*dY >= C)
                    distances[j] = Math.min(distances[j], dX*dX + dY*dY);
            }
        }
        System.out.println(cost);
    }

}