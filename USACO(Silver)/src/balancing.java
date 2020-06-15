import java.util.*;
import java.io.*;

public class balancing
{
    public static void main(String[] args) throws IOException
    {
        // Read in data.
        BufferedReader in = new BufferedReader(new FileReader("balancing.in"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());

        TreeSet<Integer> yVals = new TreeSet<>();

        int x,y;
        // Read in where the cows are and store the critical Y values.
        Point[] cows = new Point[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(in.readLine());
            x =	Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            cows[i] = new Point(x,y);
            yVals.add(y); // stores the distinct y values in an ordered set
        }

        Arrays.sort(cows); // cows are sorted by x value

        int M = Integer.MAX_VALUE;

        // Try placing the x line after each Point.
        for (int i=0; i< N-1; i++)
        {
            for (int cut: yVals)  // for each unique y value
            {
                // Count cows in bottom left.
                int left = 0;
                for (int j = 0; j <= i; j++)
                {
                    if (cows[j].y <= cut)
                    {
                        left++;
                    }
                }
                // And bottom right.
                int right = 0;
                for (int j=i+1; j<N; j++)
                    if (cows[j].y <= cut)
                        right++;
                // Now, take the max of the "4 quadrants"
                int cur = Math.max(left, right);
                cur = Math.max(cur, i+1-left);
                cur = Math.max(cur, N-i-1-right);
                M = Math.min(M, cur);
            }
        }
        PrintWriter out = new PrintWriter(new FileWriter("balancing.out"));
        out.println(M);
        out.close();
        in.close();
    }

    static class Point implements Comparable<Point>
    {

        public int x;
        public int y;

        public Point(int a, int b)
        {
            x = a;
            y = b;
        }

        public int compareTo(Point other)
        {
            return this.x - other.x;
        }

    }
}


