

import java.util.*;
import java.io.*;

public class mootube_
{

    public static int n;
    public static ArrayList[] g;

    final public static int MAX = 1000000000;

    public static void main(String[] args) throws Exception {

        // Read the data, sort by end time.
        BufferedReader stdin = new BufferedReader(new FileReader("mootube.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        n = Integer.parseInt(tok.nextToken());
        int q = Integer.parseInt(tok.nextToken());

        // empty graph.
        g = new ArrayList[n];
        for (int i=0; i<n; i++) g[i] = new ArrayList<edge>();

        // Add edges.
        for (int i=0; i<n-1; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int v1 = Integer.parseInt(tok.nextToken()) - 1;
            int v2 = Integer.parseInt(tok.nextToken()) - 1;
            int w = Integer.parseInt(tok.nextToken());
            g[v1].add(new edge(v2, w));
            g[v2].add(new edge(v1, w));
        }

        PrintWriter out = new PrintWriter(new FileWriter("mootube.out"));

        // Do queries.
        for (int i=0; i<q; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int k = Integer.parseInt(tok.nextToken());
            int v = Integer.parseInt(tok.nextToken()) - 1;
            out.println(bfs(v, k));
        }
        out.close();
        stdin.close();
    }

    // Runs a BFS from s on edges with weight min or greater, returns # of nodes visited - 1.
    public static int bfs(int s, int min) {

        // Set up BFS.
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.offer(s);
        boolean[] used = new boolean[n];
        used[s] = true;
        int res = 0;

        // Run BFS.
        while (q.size() > 0) {

            // Count the next item in the queue.
            int cur = q.poll();
            res++;

            // Go to neighbors with relevance min or greater.
            for (edge e: (ArrayList<edge>)g[cur]) {
                if (!used[e.v] && e.w >= min) {
                    q.offer(e.v);
                    used[e.v] = true;
                }
            }
        }

        // Don't count me...
        return res-1;
    }

}

class edge {

    public int v;
    public int w;

    public edge(int to, int weight) {
        v = to;
        w = weight;
    }
}