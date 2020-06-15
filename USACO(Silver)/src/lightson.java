import java.util.*;
import java.io.*;

public class lightson
{

    final private static int[] dX = {-1,0,0,1};
    final private static int[] dY = {0,-1,1,0};

    public static int N;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
        PrintWriter outf = new PrintWriter(new File("lightson.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        int lights = Integer.parseInt(st.nextToken());
        ArrayList[][] grid = new ArrayList[N][N];
        for (int i = 0; i<N * N; i++)
        {
            grid[i / N][i % N] = new ArrayList<Integer>();
        }

        for (int i=0; i< lights; i++)
        {
            st = new StringTokenizer(f.readLine());
            int r1 = Integer.parseInt(st.nextToken()) - 1;
            int c1 = Integer.parseInt(st.nextToken()) - 1;
            int r2 = Integer.parseInt(st.nextToken()) - 1;
            int c2 = Integer.parseInt(st.nextToken()) - 1;
            grid[r1][c1].add(r2 * N + c2);
        }

        // set up bfs
        boolean[][] visited = new boolean[N][N];
        boolean[][] on = new boolean[N][N];
        on[0][0] = true;
        Queue<Integer> Q = new ArrayDeque<>();
        Q.offer(0);
        visited[0][0] = true;

        // Run bfs here
        while (Q.size() > 0)
        {
            // get next room in queue
            int cur = Q.remove();
            int x = cur/N;
            int y = cur%N;

            // greedily turn on all lights it is connected to
            for (int i=0; i<grid[x][y].size(); i++)
            {
                int next = ((ArrayList<Integer>)grid[x][y]).get(i);
                on[next/N][next%N] = true;

                // add any room connected to a lit room to the queue
                for (int j=0; j < dX.length; j++)
                {
                    int nX = next / N + dX[j];
                    int nY = next % N + dY[j];
                    if (inbounds(nX, nY) && visited[nX][nY] && !visited[next/N][next%N])
                    {
                        Q.add(next);
                        visited[next / N][next % N] = true;
                        break;
                    }
                }
            }
            // add neighbors (places that have not been visited but are lit)
            for (int i=0; i < dX.length; i++)
            {
                if (inbounds(x + dX[i], y + dY[i]) && !visited[x + dX[i]][y +dY[i]] && on[x+dX[i]][y+dY[i]])
                {
                    visited[x+ dX[i]][y + dY[i]] = true;
                    Q.add(N*(x+dX[i]) + y+dY[i]);
                }
            }
        }

        // count the number of rooms that are on
        int ans = 0;
        for (int i=0; i< N*N ; i++)
        {
            if (on[i/N][i%N])
            {
                ans++;
            }
        }

        outf.println(ans); // ans
        outf.close();
        f.close();
    }

    private static boolean inbounds(int x, int y)
    {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
