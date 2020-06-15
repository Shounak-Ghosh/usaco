

import java.util.*;
import java.io.*;

public class moocast_
{

    public static int n;
    private static int[][] pts;

    public static void main(String[] args) throws Exception
    {

        // Read in the points and range.
        Scanner stdin = new Scanner(new File("moocast.in"));
        n = stdin.nextInt();
        pts = new int[n][3];
        for (int i=0; i<n; i++)
            for (int j=0; j<3; j++)
                pts[i][j] = stdin.nextInt();

        // Try each starting vertex.
        int res = 0;
        for (int i=0; i<n; i++)
            res = Math.max(res, reach(i));

        // Write out the answer.
        PrintWriter out = new PrintWriter(new FileWriter("moocast.out"));
        out.println(res);
        out.close();
        stdin.close();
    }

    // Returns the number of cows reached from cow v.
    private static int reach(int v)
    {

        // Run floodfill.
        boolean[] used = new boolean[n];
        floodfill(v, used);

        // Count # of reached cows.
        int res = 0;
        for (int i=0; i<n; i++)
            if (used[i])
                res++;
        return res;
    }

    // Run a floodfill from v. used stores nodes already visited in the fill.
    private static void floodfill(int v, boolean[] used)
    {
        used[v] = true;

        // Try each neighbor.
        for (int i=0; i<n; i++) {
            if (used[i]) continue;

            // We can do the transmission from v to i.
            if ((pts[i][0]-pts[v][0])*(pts[i][0]-pts[v][0]) + (pts[i][1]-pts[v][1])*(pts[i][1]-pts[v][1]) <= (long)pts[v][2]*pts[v][2])
                floodfill(i, used);
        }
    }
}
