import java.util.*;
import java.io.*;

public class pails
{

    final public static int IMPOSSIBLE = 1000;

    public static void main(String[] args) throws IOException
    {

        // Read in data.
        BufferedReader stdin = new BufferedReader(new FileReader("pails.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        int X = Integer.parseInt(tok.nextToken());
        int Y = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());
        int M = Integer.parseInt(tok.nextToken());



        // Set up BFS.
        int ans = Integer.MAX_VALUE;
        int[] dist = new int[200*200];
        Arrays.fill(dist, IMPOSSIBLE);
        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        dist[0] = 0;

        // Run BFS.
        while (!q.isEmpty())
        {
            // Get current item.
            int current = q.remove();
            int prevDist = dist[current];
            int first = current / 200;
            int second = current % 200;

            // Done with BFS. There are no more moves left
            if (dist[current] > K)
            {
                break;
            }
            // See if this one's better.
            ans = Math.min(ans, Math.abs(M-(first+second)));

            // Try filling the left.
            int fillLeft = 200 * X + second;
            if (dist[fillLeft] == IMPOSSIBLE) // not visited before
            {
                q.add(fillLeft);
                dist[fillLeft] = prevDist + 1;
            }

            // Try filling the right
            int fillRight = 200 * first + Y;
            if(dist[fillRight] == IMPOSSIBLE)
            {
                q.add(fillRight);
                dist[fillRight] = prevDist + 1;
            }

            // Empty the left

            if(dist[second] == IMPOSSIBLE)
            {
                q.add(second);
                dist[second] = prevDist + 1;
            }

            // Empty the right
            if(dist[200 * first] == IMPOSSIBLE)
            {
                q.add(200 *first);
                dist[200 * first] = prevDist + 1;
            }

            // Pour left to right.
            int pour = Math.min(first, Y-second);
            int pourLeft = 200*(first-pour) + (second+pour);
            if (dist[pourLeft] == IMPOSSIBLE) {
                q.offer(pourLeft);
                dist[pourLeft] = prevDist + 1;
            }
            // Pour right to left.
            pour = Math.min(second, X-first);
            int pourRight = 200*(first+pour) + (second-pour);
            if (dist[pourRight] == IMPOSSIBLE) {
                q.offer(pourRight);
                dist[pourRight] = prevDist + 1;
            }
        }

        // Write result.
        PrintWriter out = new PrintWriter(new FileWriter("pails.out"));
        out.println(ans);
        out.close();
        stdin.close();
    }
}

