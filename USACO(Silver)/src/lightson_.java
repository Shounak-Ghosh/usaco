import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class lightson_
{

   final private static int[] dX = {-1, 0, 0, 1};
   final private static int[] dY = {0, -1, 1, 0};

   public static int N;

   public static void main(String[] args) throws IOException
   {
      BufferedReader f = new BufferedReader(new FileReader("lightson.in"));
      PrintWriter outf = new PrintWriter(new FileWriter("lightson.out"));
      StringTokenizer st = new StringTokenizer(f.readLine());
      N = Integer.parseInt(st.nextToken()); // n by n grid
      int M = Integer.parseInt(st.nextToken()); // number of switches
      ArrayList[][] grid = new ArrayList[N][N];

      for (int i = 0; i < N; i++)
      {
         for (int j = 0; j < N; j++)
         {
            grid[i][j] = new ArrayList();
         }
      }

      for (int i = 0; i < M; i++)
      {
         st = new StringTokenizer(f.readLine());
         int r1 = Integer.parseInt(st.nextToken()) - 1;
         int c1 = Integer.parseInt(st.nextToken()) - 1;
         int r2 = Integer.parseInt(st.nextToken()) - 1;
         int c2 = Integer.parseInt(st.nextToken()) - 1;

         grid[r1][c1].add(r2 * N + c2);
      }

      boolean[][] visited = new boolean[N][N];
      boolean[][] on = new boolean[N][N];
      on[0][0] = true;
      ArrayDeque<Integer> q = new ArrayDeque<>();
      q.add(0);
      visited[0][0] = true;

      while (!q.isEmpty())
      {
         int curr = q.remove();
         int x = curr / N;
         int y = curr % N;

         for (int i = 0; i < grid[x][y].size(); i++)
         {
            int next = ((ArrayList<Integer>) grid[x][y]).get(i);
            on[next / N][next % N] = true;

            // add any room connected to a lit room to the queue
            for (int j = 0; j < dX.length; j++)
            {
               int nX = next / N + dX[j];
               int nY = next % N + dY[j];
               if (inbounds(nX, nY) && visited[nX][nY] && !visited[next / N][next % N])
               {
                  q.add(next);
                  visited[next / N][next % N] = true;
                  break;
               }
            }
         }

         // add neighbors (places that have not been visited but are lit)
         for (int i = 0; i < dX.length; i++)
         {
            if (inbounds(x + dX[i], y + dY[i]) && !visited[x + dX[i]][y + dY[i]] && on[x + dX[i]][y + dY[i]])
            {
               visited[x + dX[i]][y + dY[i]] = true;
               q.add(N * (x + dX[i]) + y + dY[i]);
            }
         }
      }

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
