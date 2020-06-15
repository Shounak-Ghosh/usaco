

import java.io.*;
import java.util.*;

public class perimeter_
{

    // How we can move.
    final public static int[] DX = {-1,0,0,1};
    final public static int[] DY = {0,-1,1,0};

    // Stores grid.
    public static int n;
    public static char[][] grid;

    public static void main(String[] args) throws Exception
    {

        // Read in the grid.
        BufferedReader stdin = new BufferedReader(new FileReader("perimeter.in"));
        n = Integer.parseInt(stdin.readLine().trim());
        grid = new char[n][];
        for (int i=0; i<n; i++)
            grid[i] = stdin.readLine().trim().toCharArray();

        boolean[][] used = new boolean[n][n];
        int[] res = null;

        // Go through each square.
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<n; j++)
            {

                // Not a new region.
                if (used[i][j] || grid[i][j] == '.') continue;

                // Run this region.
                int[] tmp = bfs(i, j, used);

                // Update if this one is better.
                if (res == null || tmp[0] > res[0] || (tmp[0] == res[0] && tmp[1] < res[1]))
                    res = tmp;
            }
        }

        // Ta da!
        PrintWriter out = new PrintWriter(new FileWriter("perimeter.out"));
        out.println(res[0]+" "+res[1]);
        out.close();
        stdin.close();
    }

    private static int[] bfs(int x, int y, boolean[][] used)
    {

        // Set up BFS.
        LinkedList<Integer> q = new LinkedList<Integer>();
        q.offer(n*x+y);
        used[x][y] = true;

        // All regions of size 1 have perimeter 4.
        int[] res = new int[2];
        res[0] = 1;
        res[1] = 4;

        // Run BFS.
        while (q.size() > 0)
        {

            // Get next item.
            int cur = q.poll();
            int cX = cur/n;
            int cY = cur%n;

            // Try adding to the region.
            for (int i=0; i<DX.length; i++)
            {

                int nX = cX + DX[i];
                int nY = cY + DY[i];

                // All the reasons why this isn't adding to our new region.
                if (!inbounds(nX, nY)) continue;
                if (used[nX][nY]) continue;
                if (grid[nX][nY] == '.') continue;

                // Add 1 area, add to queue, mark as true.
                res[0]++;
                q.offer(nX*n+nY);
                used[nX][nY] = true;

                // Count border squares that are already part of region.
                int prev = 0;
                for (int j=0; j<DX.length; j++)
                {
                    int tmpX = nX + DX[j];
                    int tmpY = nY + DY[j];
                    if (!inbounds(tmpX, tmpY))
                        continue;
                    if (used[tmpX][tmpY]) prev++;
                }

                // This is weird, but I subtract prev (since the new square covers these)
                // Then I add 4-prev since these are my new borders. So, -prev+r-prev.
                res[1] += (4-2*prev);
            }
        }

        // Result for this region (area and perimeter).
        return res;
    }

    public static boolean inbounds(int x, int y)
    {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

}
