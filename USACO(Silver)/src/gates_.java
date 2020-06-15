import java.util.*;
import java.io.*;

public class gates_
{
    // Directions of movement.
    final private static int[] DX = {-1,0,0,1};
    final private static int[] DY = {0,-1,1,0};

    private static boolean[][] vertical;
    private static boolean[][] horiz;
    public static int n;

    public static void main(String[] args) throws IOException
    {
        // Read in data.
        BufferedReader f = new BufferedReader(new FileReader("gates.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("gates.out"));
        n = Integer.parseInt(f.readLine().trim());
        String path = f.readLine();

        int x = n, y = n;
        vertical = new boolean[2*n][2*n+1];
        horiz = new boolean[2*n+1][2*n];

        // Do each move.
        for (int i=0; i<n; i++)
        {
            // Old pos.
            int oldx = x, oldy = y;

            // Move.
            if (path.charAt(i) == 'N')
                y++;
            else if (path.charAt(i) == 'S')
                y--;
            else if (path.charAt(i) == 'E')
                x++;
            else x--;

            if (oldx == x)
                vertical[Math.min(oldy, y)][x] = true;
            else
                horiz[y][Math.min(oldx,x)] = true;
        }

        // Flood fill each distinct region.
        int res = 0;
        boolean[][] used = new boolean[2*n][2*n];

        // Go to each square.
        for (int i=0; i<2*n; i++)
        {
            for (int j=0; j<2*n; j++)
            {

                // Only fill if we've never been here before.
                if (!used[i][j])
                {
                    res++;
                    fill(i, j, used);
                }
            }
        }

        // Write result - subtract one since an spanning tree of a graph with n nodes has n-1 edges.

        outf.println(res-1);
        outf.close();
        f.close();
    }

    // floodfill bfs
    public static void fill(int x, int y, boolean[][] used)
    {

        used[x][y] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.add((2*n+1)*x+y);

        while (q.size() > 0)
        {

            // Get next item.
            int cur = q.remove();
            int curX = cur/(2*n+1);
            int curY = cur%(2*n+1);

            // Go through neighbors.
            for (int i=0; i<DX.length; i++)
            {
                int nextX = curX + DX[i];
                int nextY = curY + DY[i];

                // You must be inbounds, not blocked and not previously visited.
                if (inbounds(nextX, nextY) && !blocked(curX, curY, nextX, nextY) && !used[nextX][nextY])
                {
                    used[nextX][nextY] = true;
                    q.add(nextX*(2*n+1)+nextY);
                }
            }
        }
    }

    public static boolean inbounds(int x, int y) {
        return x >= 0 && x < 2*n && y >= 0 && y < 2*n;
    }

    public static boolean blocked(int x1, int y1, int x2, int y2) {
        if (x1 != x2) return vertical[y1][Math.max(x1,x2)];
        return horiz[Math.max(y1,y2)][x1];
    }
}