import java.io.*;
import java.util.*;

public class munch
{
    int[] dR = {0,0,-1,1};
    int[] dC = {1,-1,0,0};
    static int numRows;
    static int numCols;
    static int fR;
    static int fC;
    static int sR;
    static int sC;
    static char[][] grid;
    static int dist[][];

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        numRows = sc.nextInt();
        numCols = sc.nextInt();
        grid = new char[numRows][numCols];
        dist = new int[numRows][numCols];
        for (int i = 0; i < numRows; i++)
        {
            String temp = sc.next();
            for (int j = 0; j < numCols; j++)
            {
                grid[i][j] = temp.charAt(j);
                if (grid[i][j] == 'B')
                {
                    fR = i;
                    fC = j;
                    grid[i][j] = '.';
                }
                if (grid[i][j] == 'C')
                {
                    sR = i;
                    sC = j;
                }
            }
        }
        Queue<Character> indexes = new ArrayDeque<>();
        Queue<Integer> r = new ArrayDeque<>();
        Queue<Integer> c = new ArrayDeque<>();
        int index = 1;
        while (true)
        {
            if (sR == fR && sC == fC)
            {
                System.out.println(dist[fR][fC]);
                return;
            }

            if (sC > 0)
            {
                if (grid[sR][sC - 1] == '.')
                {
                    grid[sR][sC - 1] = 'k';
                    dist[sR][sC - 1] =  index;
                    indexes.add((char) index);
                    r.add(sC - 1);
                    c.add(sR);

                }
            }
            if (sC < numCols - 1)
            {
                if (grid[sR][sC + 1] == '.')
                {
                    grid[sR][sC + 1] = 'k';
                    dist[sR][sC + 1] = index;
                    indexes.add((char) index);
                    r.add(sC + 1);
                    c.add(sR);

                }
            }
            if (sR > 0)
            {
                if (grid[sR - 1][sC] == '.')
                {
                    grid[sR - 1][sC] = 'k';
                    dist[sR - 1][sC] = index;
                    indexes.add((char) index);
                    r.add(sC);
                    c.add(sR - 1);

                }
            }
            if (sR < numRows - 1)
            {
                if (grid[sR + 1][sC] == '.')
                {
                    grid[sR + 1][sC] = 'k';
                    dist[sR + 1][sC] = index;
                    indexes.add((char) index);
                    r.add(sC);
                    c.add(sR + 1);

                }
            }

            sR = c.remove();
            sC = r.remove();
            index = indexes.remove() + 1;
        }
    }
}