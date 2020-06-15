package Week8;

import java.util.Arrays;
import java.util.Scanner;

public class hopscotch
{
    static int numRows;
    static int numCols;
    static char[][] matrix;
    static int answer;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numRows = sc.nextInt();
        numCols = sc.nextInt();

        char[] line;
        int index = 0;

        matrix = new char[numRows + 2][numCols + 2];

        for(int r = 1; r <= numRows; r++)
        {
            line = sc.next().toCharArray();
            for(int c = 1; c <= numCols; c++)
            {
                matrix[r][c] = line[index];
                index++;
            }
            index = 0;
        }

        for(char[] row: matrix)
        {
            System.out.println(Arrays.toString(row));
        }

        solve(1,1);
        System.out.println(answer);
    }

    public static void solve(int r, int c)
    {
        if(r == numRows && c == numCols)
        {
            answer++;
            return;
        }
        if(r >= numRows || c >= numCols)
        {
            return;
        }

        for(int i = r + 1; i <= numRows; i++)
        {
            for(int j = c + 1; j <= numCols; j++)
            {
                if (matrix[i][j] != matrix[r][c])
                {
                    //System.out.println("i: " + i + "\t j: " + j +"\t r: " + r + "\t c: " + c);
                    solve(i, j);
                }
            }
        }
    }
}
