package Week10;

import java.util.Arrays;
import java.util.Scanner;

public class pageant
{
    static char[][] matrix;
    static int numRows;
    static int numCols;
    static char[] line;
    static int[] dR = {0,0,-1,1};
    static int[] dC = {1,-1,0,0};
    static int answer;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numRows = sc.nextInt();
        numCols = sc.nextInt();
        answer = 0;

        matrix = new char[numRows][numCols];

        for(int r = 0; r < numRows; r++)
        {
            line = sc.next().toCharArray();
            for(int c = 0; c < numCols; c++)
            {
                matrix[r][c] = line[c];
            }
        }

        //printMatrix();

        boolean flag = false;

        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                if(matrix[r][c] == 'X')
                {
                    if(!flag)
                    {
                        solve(r,c,'1');
                        flag = true;
                    }
                    else
                    {
                        solve(r,c,'2');
                    }
                }
            }
        }

        System.out.println(findMinDistance() - 1);

    }


    public static void solve(int r, int c, char label)
    {
        if(!isValid(r,c))
        {
            return;
        }

        if(matrix[r][c] != 'X')
        {
            return;
        }

        matrix[r][c] = label;

        for(int i = 0; i < 4; i++)
        {
            int row = r + dR[i];
            int col = c + dC[i];
            solve(row,col, label);
        }

        //printMatrix();
    }

    public static boolean isValid(int r, int c)
    {
        return r >= 0 && r < numRows && c >= 0 && c < numCols;
    }

    public static void printMatrix()
    {
        for(char[] m : matrix)
        {
            System.out.println(Arrays.toString(m));
        }
        System.out.println();
    }

    public static int findMinDistance()
    {
        int min = Integer.MAX_VALUE;
        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                if(matrix[r][c] == '1')
                {
                    for(int a = 0; a < numRows; a++)
                    {
                        for(int b = 0; b < numCols; b++)
                        {
                            if(matrix[a][b] == '2')
                            {
                                min = Math.min(min,manhattanDistance(r,c,a,b));
                            }
                        }
                    }
                }
            }
        }
        return min;
    }

    public static int manhattanDistance(int a, int b, int c, int d)
    {
        return Math.abs(a - c) + Math.abs(b - d);
    }

}
