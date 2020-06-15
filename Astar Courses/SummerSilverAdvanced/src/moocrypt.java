import java.util.*;
import java.io.*;

public class moocrypt
{

    public static int[] dX = {-1,-1,-1,0,0,1,1,1};
    public static int[] dY = {-1,0,1,-1,1,-1,0,1};
    public static int r;
    public static int c;
    public static char[][] grid;
    public static String temp;

    public static void main(String[] args) throws Exception {

        // Read in data.
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        r = Integer.parseInt(tok.nextToken());
        c = Integer.parseInt(tok.nextToken());
        grid = new char[r][c];
        for (int i=0; i<r; i++)
        {
            grid[i] = stdin.readLine().toCharArray();
        }

        HashMap<String,Integer> map = new HashMap<String,Integer>();

        for (int i = 0; i < r; i++)
        {
            for (int j = 0; j < c; j++)
            {
                for (int k=0; k < 8; k++)
                {
                    int nX = i + 2 * dX[k];
                    int nY = j + 2*dY[k];
                    if (!(nX < 0 || nX >= r || nY < 0 || nY >= c))
                    {
                        if (grid[i+dX[k]][j+dY[k]] == grid[i+2*dX[k]][j+2*dY[k]])
                        {
                            if (grid[i+dX[k]][j+dY[k]] != grid[i][j])
                            {
                                if (grid[i][j] != 'M')
                                {
                                    if (grid[i+dX[k]][j+dY[k]] != 'O')
                                    {
                                        temp = "" + grid[i][j] + grid[i+dX[k]][j+dY[k]] + grid[i+2*dX[k]][j+2*dY[k]];

                                        if (map.containsKey(temp))
                                            map.put(temp, map.get(temp)+1);
                                        else
                                            map.put(temp, 1);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        int ans = 0;
        for (String s : map.keySet())
        {
            ans = Math.max(ans, map.get(s));
        }

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(ans);
        out.close();
        stdin.close();
    }
}