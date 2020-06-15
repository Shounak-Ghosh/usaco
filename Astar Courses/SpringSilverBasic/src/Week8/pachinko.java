package Week8;

import java.util.Scanner;

public class pachinko
{
    static int[][] matrix;
    static int numRows;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numRows = sc.nextInt();
        matrix = new int[numRows][numRows];

        int counter = 1;
        for(int i = 0; i < numRows; i++)
        {
            for(int j = 0; j < counter; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
            counter++;
        }
        System.out.println(solve(0,0));
    }

    public static int solve(int r, int c)
    {
        if(r > numRows || c > numRows)
        {
            return 0;
        }
        return matrix[r][c] + Math.max(solve(r+1,c),solve(r+1,c+1));

    }
}

