import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class lightson
{
    public static int[] dX = {-1,0,0,1};
    public static int[] dY = {0,-1,1,0};
    public static int N,M;
    public static ArrayList<coordinate>[][] grid;
    public static boolean[][] visited;
    public static boolean[][] lit;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        grid = new ArrayList[N][N];
        visited = new boolean[N][N];
        lit = new boolean[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                grid[i][j] = new ArrayList<coordinate>();
            }
        }

        for (int i=0; i < M; i++)
        {
            int r1 = sc.nextInt() - 1;
            int c1 = sc.nextInt() - 1;
            int r2 = sc.nextInt() - 1;
            int c2 = sc.nextInt() - 1;
            grid[r1][c1].add(new coordinate(r2,c2));
        }

        visited[0][0] = true;
        lit[0][0] = true;
        dfs(0,0);
        int ans = 0;
        for (int i = 0; i < N; i++)
        {
            System.out.println(Arrays.toString(lit[i]));
            for (int j = 0; j < N; j++)
            {
                if(lit[i][j])
                {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
    static int row;
    static int col;
    public static void dfs(int x, int y)
    {
        System.out.println(x + " " + y);

        // turn on everything
        for (coordinate c: grid[x][y])
        {
            lit[c.c][c.r] = true;
        }

        for (int i = 0; i < 4; i++)
        {
            row = x + dX[i];
            col = y + dY[i];

            if((row >= 0 && row < N && col >= 0 && col < N) && lit[row][col])
            {

                System.out.println("row: " + row + " col: " + col);
                if(!visited[row][col])
                {
                    visited[row][col] = true;
                    dfs(row,col);
                }
            }
        }

        for (coordinate c: grid[x][y])
        {
            for (int i = 0; i < 4; i++)
            {
                row = c.r + dX[i];
                col = c.c + dY[i];
                if ((row >= 0 && row < N && col >= 0 && col < N))
                {

                    System.out.println("row: " + row + " col: " + col);
                    if(!visited[row][col])
                    {
                        visited[row][col] = true;
                        dfs(c.r,c.c);
                    }
                }
            }
        }

    }

    static class coordinate
    {
        int r, c;
        public coordinate(int row, int col)
        {
            r = row;
            c = col;
        }

        public String toString()
        {
            return r + " " + c;
        }
    }
}
