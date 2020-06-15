import java.util.*;

public class fliptile {

    static int C, R;
    static int[][] grid, copy, flips;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        C = in.nextInt();
        R = in.nextInt();
        grid = new int[R][C];
        copy = new int[R][C];
        flips = new int[R][C];
        int minFlips = Integer.MAX_VALUE;
        int currentFlips = 0;
        ArrayList<String> valid = new ArrayList<>();
        for (int y = 0; y < C; y++)
        {
            for (int x = 0; x < R; x++)
            {
                grid[x][y] = in.nextInt();
                copy[x][y] = grid[x][y];
                flips[x][y] = 0;
            }
        }

        // generate all possible flip combinations for the first row
        for (int num = 0; num < Math.pow(2, R); num++)
        {
            String bin = "000000000000000" + Integer.toBinaryString(num);
            // generate the flips for the first row
            bin = bin.substring(bin.length() - R);
            for (int i = 0; i < R; i++)
            {
                if (bin.charAt(i) == '1')
                    flip(i,0);
            }
            // greedily flip the rest of the grid as needed
            for (int j = 1; j < C; j++)
            {
                for (int i = 0; i < R; i++)
                {
                    if (copy[i][j - 1] == 1)
                        flip(i, j);
                }
            }

            boolean check = true;
            for (int i = 0; i < C; i++)
            {
                for (int j = 0; j < R; j++)
                {
                    if (copy[j][i] == 1)
                        check = false;
                }
            }
            // if it does, print the results
            if (check)
            {
                String res = "";
                for (int i = 0; i < C; i++)
                {
                    for (int j = 0; j < R; j++)
                    {
                        if(flips[j][i] == 1)
                        {
                            currentFlips++;
                        }
                        res += flips[j][i];
//                        System.out.print(flips[j][i]);
//                        if (j < R - 1)
//                            System.out.print(" ");
                    }
//                    System.out.println();
                }

                if(currentFlips < minFlips)
                {
                    valid.add(res);
                    minFlips = currentFlips;
                }
                currentFlips = 0;

//                System.exit(0);
            }
            reset();
        }
        if (valid.size() == 0)
        {
            // nothing worked
            System.out.println("IMPOSSIBLE");
            System.exit(0);
        }

        Collections.sort(valid);
        String ans = valid.get(valid.size() - 1);
        int counter = 0;
        for (int i = 0; i < C; i++)
        {
            for (int j = 0; j < R; j++)
            {
                System.out.print(ans.charAt(counter));
                counter++;
                if (j < R -1)
                {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    // execute a flip (flip the tile itself + 4 adjacent tiles)
    public static void flip(int x, int y)
    {
        int[][] dir = {{0,-1},{0,1},
                       {-1,0},{1,0}};
        copy[x][y] = 1 - copy[x][y];
        flips[x][y] = 1;
        for (int i = 0; i < 4; i++)
        {
            if (x + dir[i][0] >= 0 && x + dir[i][0] < R)
            {
                if (y + dir[i][1] >= 0 && y + dir[i][1] < C)
                {
                    copy[x + dir[i][0]][y + dir[i][1]] = 1 - copy[x + dir[i][0]][y + dir[i][1]];
                }
            }
        }
    }

    public static void reset()
    {
        for (int i = 0; i < C; i++)
        {
            for (int j = 0; j < R; j++)
            {
                copy[j][i] = grid[j][i];
                flips[j][i] = 0;
            }
        }
    }

}