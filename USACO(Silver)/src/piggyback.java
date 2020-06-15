import java.io.*;
import java.util.LinkedList;
import java.util.*;
public class piggyback
{

    static int B;
    static int E;
    static int P;
    static int N;
    static int M;
    static Graph g;
    static int[] bessDist;
    static int[] elsieDist;
    static int[] NDist;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("piggyback.in"));
        PrintWriter outf = new PrintWriter(new File("piggyback.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        B = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        g = new Graph(N);
        int source = 0;
        int dest = 0;

        for(int i = 0; i < M; i++)
        {
            st = new StringTokenizer(f.readLine());
            source = Integer.parseInt(st.nextToken());
            dest = Integer.parseInt(st.nextToken());
            g.addEdge(source,dest);
        }

        bessDist = g.BFS(1);
        elsieDist = g.BFS(2);
        NDist = g.BFS(N);


        int minEnergy = NDist[1] * B + NDist[2] * E;

        for(int k = 1; k <= N; k++)
        {
            minEnergy = Math.min(minEnergy,energy(k));
        }


        outf.println(minEnergy);
        f.close();
        outf.close();


    }




    public static int energy(int k)
    {
        int bess = bessDist[k] * B;
        int elsie = elsieDist[k] * E;
        int combined = NDist[k] * P;
        return bess + elsie + combined;
    }
}

class Graph
{
    private int V;   // No. of vertices
    // Adjacency List
    private LinkedList<Integer>[] adj;

    // Constructor
    Graph(int v)
    {
        V = v;
        adj = new LinkedList[v + 1];
        for (int i=0; i <= v; ++i)
            adj[i] = new LinkedList();
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w)
    {
        adj[v].add(w);
        adj[w].add(v);
    }


    public int[] BFS(int source)
    {
        boolean[] visited = new boolean[V + 1];
        int[] distances = new int[V + 1];
        distances[source] = 0;
        visited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty())
        {
            int v = q.remove();
            for(Integer w : adj[v])
            {
                if(w != 0 && !visited[w])
                {
                    visited[w] = true;
                    distances[w] = distances[v] + 1;
                    q.add(w);
                }
            }
        }

        //System.out.println(Arrays.toString(distances));
        return distances;
    }

    public int BFS(int source, int dest)
    {
        boolean[] visited = new boolean[V + 1];
        int[] distances = new int[V + 1];
        distances[source] = 0;
        visited[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty())
        {
            int v = q.remove();
            for(Integer w : adj[v])
            {
                if(!visited[w])
                {
                    visited[w] = true;
                    distances[w] = distances[v] + 1;
                    q.add(w);
                }
            }
        }

        //System.out.println(Arrays.toString(distances));
        return distances[dest];
    }

}
