package Day5;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class pageant2
{
    public static void main(String[] args)
    {
        solve();
    }

    public static void solve()
    {
        int[] dR = {0,0,-1,1};
        int[] dC = {1,-1,0,0};
        Scanner sc = new Scanner(System.in);
        int numRow = sc.nextInt();
        int numCol = sc.nextInt();

        char[][] grid = new char[numRow + 2][numCol + 2];

        char[] temp;
        int index = 0;
        Arrays.fill(grid[0],'.');
        for(int r = 1; r <= numRow; r++)
        {
            temp = sc.next().toCharArray();
            grid[r][0] = '.';
            for(int c = 1; c <= numCol; c++)
            {
                grid[r][c] = temp[index];
                index++;
            }
            grid[r][index + 1] = '.';
            index = 0;
        }
        Arrays.fill(grid[numRow + 1],'.');

        printGrid(grid);

        int counter = 1;
        Queue<Integer> R = new ArrayDeque<>();
        Queue<Integer> C = new ArrayDeque<>();

        int currentR;
        int currentC;
        int row;
        int col;


        for(int r = 1; r <= numRow; r++)
        {
            for(int c = 1; c <= numCol; c++)
            {
                if(grid[r][c] == 'X')
                {
                    // bfs below
                    R.clear();
                    C.clear();

                    // add start to Q(s)
                    R.add(r);
                    C.add(c);
                    // mark start as visited
                    grid[r][c] = (char) (counter + '0');


                    while (!R.isEmpty()) // R and C queues should always have the same size
                    {
                        currentR = R.remove();
                        currentC = C.remove();

                        for(int i = 0; i < 4; i++)
                        {
                            row = currentR + dR[i];
                            col = currentC + dC[i];

                            if(grid[row][col] == 'X')
                            {
                                grid[row][col] = (char) (counter + '0') ;
                                R.add(row);
                                C.add(col);
                            }
                        }
                    }
                    // end of bfs
                    counter++;
                }
            }
        }

        System.out.println();

        printGrid(grid);


        // now that the regions are marked, compare each 1-2 pair and find the smallest manhattan distance
        int ans = Integer.MAX_VALUE;
        int current = 0;
        for (int a = 1; a <= numRow; a++)
        {
            for(int b = 1; b <= numCol; b++)
            {
                if(grid[a][b] == '1')
                {
                    for(int c = 1; c <= numRow; c++)
                    {
                        for(int d = 1; d <= numCol; d++)
                        {
                            if(grid[c][d] == '2')
                            {
                                current = Math.abs(a - c) + Math.abs(b - d) - 1;
                                ans = Math.min(ans,current);
                            }
                        }
                    }
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
