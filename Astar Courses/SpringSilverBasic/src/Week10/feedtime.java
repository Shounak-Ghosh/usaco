package Week10;

import java.util.Arrays;
import java.util.Scanner;

public class feedtime
{
    static char[][] matrix;
    static int numRows;
    static int numCols;
    static char[] line;
    static int[] dR = {-1,-1,-1,0,0,1,1,1};
    static int[] dC = {-1,0,1,-1,1,-1,0,1};
    static int answer;
    static int counter;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numCols = sc.nextInt();
        numRows = sc.nextInt();
        matrix = new char[numRows][numCols];

        for(int r = 0; r < numRows; r++)
        {
            line = sc.next().toCharArray();
            for(int c = 0; c < numCols; c++)
            {
                if(line[c] == '.')
                {
                    matrix[r][c] = 'W';
                }
                else
                {
                    matrix[r][c] = '.';
                }

            }
        }

        //printMatrix();

        answer = 0;

        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                if(matrix[r][c] == 'W')
                {
                    //solve(r,c,0);
                    counter = 0;
                    solve(r,c);
                    //answer++;
                }
            }
        }

        System.out.println(answer);

    }


    public static void solve(int r, int c)
    {
        if(!isValid(r,c))
        {
            return;
        }

        if(matrix[r][c] != 'W')
        {
            return;
        }



        matrix[r][c] = '.';
        counter++;

        if(answer < counter)
        {
            answer = counter;
            //System.out.println(counter);
        }

        for(int i = 0; i < 8; i++)
        {
            int row = r + dR[i];
            int col = c + dC[i];
            solve(row,col);
        }

        //printMatrix();



//        if(!isValid(r,c))
//        {
//            return;
//        }
//
//        if(matrix[r][c] == '.')
//        {
//            return;
//        }
//
//
//        if(count > answer)
//        {
//            answer = count;
//            System.out.println(answer);
//        }
//
//
//        matrix[r][c] = '.';
//        for(int i = 0; i < 8; i++)
//        {
//            int row = r + dR[i];
//            int col = c + dC[i];
//            solve(row,col, count + 1);
//        }
//
//        printMatrix();



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
}
