package Week8;

import java.util.Arrays;
import java.util.Scanner;

public class maze
{
    public static void main(String[] args)
    {
        System.out.println(solve());
    }

    // start
    static String answer;
    static int rows;
    static int cols;
    static char[][] matrix;
    static int startRow;
    static int startCol;
    static int endRow;
    static int endCol;
    static char[] dir = {'R','L','U','D'};
    static int[] dR = {0,0,-1,1};
    static int[] dC = {1,-1,0,0};


    public static String solve()
    {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        matrix = new char[rows + 2][cols + 2];

        for(int i = 0; i < matrix.length; i++)
        {
            Arrays.fill(matrix[i],'#');
        }

        char[] line;
        int index = 0;

        for(int r = 1; r <= rows; r++)
        {
            line = sc.next().toCharArray();
            for(int c = 1; c <= cols; c++)
            {
                matrix[r][c] = line[index];
                if(matrix[r][c] == 'S')
                {
                    startRow = r;
                    startCol = c;
                }
                else if(matrix[r][c] == 'F')
                {
                    endRow = r;
                    endCol = c;
                }
                index++;
            }
            index = 0;
        }

        /*
        for(char[] row: matrix)
        {
            System.out.println(Arrays.toString(row));
        }
        */

        answer = "hi";
        dfs(startRow,startCol,"");
        //System.out.println("ans: " + answer);
        return answer;
    }

    public static void dfs(int r, int c, String s)
    {
        if(r == endRow && c == endCol)
        {
            answer = s;
            //System.out.println(answer);
            return;
        }

        matrix[r][c] = '#';
        int row = 0;
        int col = 0;
        for(int i = 0; i < 4; i++)
        {
            row = r + dR[i];
            col = c + dC[i];
            if(row >= 1 && col >= 1 && row <= rows && col <= cols && matrix[row][col] != '#')
            {
                //System.out.println(s);
                dfs(row,col,s + dir[i]);
            }
        }
    }

    // end
}
