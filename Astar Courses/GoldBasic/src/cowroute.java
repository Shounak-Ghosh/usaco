import java.util.*;

public class cowroute
{
    final public static int MAX = 1000;
    final public static long MAX_D = 1000000000000000000L;

    public static int n;

    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);
        int source = sc.nextInt() - 1;
        int dest = sc.nextInt() - 1;
        n = sc.nextInt();

        // Graph has at most 1000 vertices.
        ArrayList[] g = new ArrayList[MAX];
        for (int i=0; i < MAX; i++) g[i] = new ArrayList<edge>();

        // Add flights.
        for (int i=0; i<n; i++)
        {

            long weight = sc.nextLong();
            int numEdges = sc.nextInt();

            int[] route = new int[numEdges];
            for (int j=0; j < numEdges; j++)
                route[j] = sc.nextInt() - 1;

            // (1000000*cost + numflights)
            for (int j=0; j < numEdges; j++)
            {
                for (int k = j + 1; k < numEdges; k++)
                {
                    g[route[j]].add(new edge(route[k], 1000000* weight + k - j));
                }
            }
        }

        // Run Dijkstra's and extract necessary information.
        long res = dijkstra(g, source, dest);
        long dist, numF;

        if(res > 0)
        {
            dist = res/1000000;
            numF = res%1000000;
        }
        else {
            dist = -1;
            numF = -1;
        }
        System.out.println(dist + " " + numF);
    }

    public static long dijkstra(ArrayList[] g, int s, int e)
    {

        PriorityQueue<edge> pq = new PriorityQueue<edge>();
        long[] dist = new long[MAX];
        boolean[] used = new boolean[MAX];
        Arrays.fill(dist, MAX_D);
        dist[s] = 0;
        pq.offer(new edge(s, 0));

        while (pq.size() > 0)
        {
            // Get next edge.
            edge current = pq.poll();
            if (used[current.neighbor])
                continue;

            // Marked this vertex as used.
            used[current.neighbor] = true;

            // We made it.
            if (current.neighbor == e)
                return current.weight;

            // push relevant neighbors.
            for (edge next: (ArrayList<edge>)g[current.neighbor])
            {
                if (dist[current.neighbor] + next.weight < dist[next.neighbor])
                {
                    dist[next.neighbor] = dist[current.neighbor] + next.weight;
                    pq.offer(new edge(next.neighbor, dist[next.neighbor]));
                }
            }
        }

        return -1;
    }
}

class edge implements Comparable<edge>
{

    public int neighbor;
    public long weight;

    public edge(int myv, long myw)
    {
        neighbor = myv;
        weight = myw;
    }

    public int compareTo (edge other)
    {
        if (this.weight < other.weight)
            return -1;
        if (this.weight > other.weight)
            return 1;
        return 0;
    }
}