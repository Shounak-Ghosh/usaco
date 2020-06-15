package Day5;

import java.util.*;

public class space2
{
    public static void main(String[] args)
    {
        solve();
    }

    public static void solve()
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        char[][] grid = new char[N + 2][N + 2];
        char[] temp;
        int index = 0;

        int[] dR = {0,0,-1,1};
        int[] dC = {1,-1,0,0};

        Arrays.fill(grid[0],'.');
        for(int i = 1; i <= N; i++)
        {
            temp = sc.next().toCharArray();
            Arrays.fill(grid[i],'.');
            for(int j = 1; j <= N; j++)
            {
                grid[i][j] = temp[index];
                index++;
            }
            index = 0;
        }
        Arrays.fill(grid[N + 1],'.');

        printGrid(grid);

        Queue<Integer> R = new ArrayDeque<>();
        Queue<Integer> C = new ArrayDeque<>();

        int ans = 0;
        for(int r = 1; r <= N; r++)
        {
            for(int c = 1; c <= N; c++)
            {
                if(grid[r][c] == '*')
                {
                   // bfs is below
                    R.clear();
                    C.clear();

                    // add start to Q(s)
                    R.add(r);
                    C.add(c);
                    // mark start as visited
                    grid[r][c] = '.';

                    int currentR;
                    int currentC;
                    int row;
                    int col;

                    while (!R.isEmpty()) // R and C queues should always have the same size
                    {
                        currentR = R.remove();
                        currentC = C.remove();

                        for(int i = 0; i < 4; i++)
                        {
                            row = currentR + dR[i];
                            col = currentC + dC[i];

                            if(grid[row][col] == '*')
                            {
                                grid[row][col] = '.';
                                R.add(row);
                                C.add(col);
                            }
                        }
                    }
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }


    public static void printGrid(char[][] grid)
    {
        for(char[] row: grid)
        {
            System.out.println(Arrays.toString(row));
        }
    }


}
