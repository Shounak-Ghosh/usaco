package Week8;

import java.util.Arrays;
import java.util.*;

public class hshoe
{
    static char[][] matrix;

    static boolean[][] mark;

    static int len;

    static int[] dR = {0,0,-1,1};

    static int[] dC = {1,-1,0,0};

    static char[] line;

    static int counter;

    static int answer;

    public static void main(String[] args)
    {
       Scanner sc = new Scanner(System.in);

        len = sc.nextInt();

        matrix = new char[len + 2][len + 2];
        mark = new boolean[len + 2][len + 2];

        for(int i = 0; i < len + 2; i++)
        {
            //Arrays.fill(matrix[i],')');
            Arrays.fill(mark[i],true);
        }

        counter = 0;
        for(int r = 1; r <= len; r++)
        {

            line = sc.next().toCharArray();
            for(int c = 1; c <= len; c++)
            {
                matrix[r][c] = line[counter];
                mark[r][c] = false;
                counter++;
            }
            counter = 0;
        }

        /*
        for(char[] arr: matrix)
        {
            System.out.println(Arrays.toString(arr));
        }

        for(boolean[] arr: mark)
        {
            System.out.println(Arrays.toString(arr));
        }
        */

        answer = 0;

        if(matrix[1][1] == '(')
        {
            traverse(1,1,1,0,'(');
        }
        System.out.println(answer);
    }

    public static void traverse(int row, int col, int open,int close, char currState)
    {
        /*System.out.println();
        for(boolean[] arr: mark)
        {
            System.out.println(Arrays.toString(arr));
        }*/

        if (open == close)
        {
            answer = Math.max(answer, open * 2);
            //System.out.println(answer);
            return;
        }
        int r = 0;
        int c = 0;
        mark[row][col] = true;

        for (int i = 0; i < 4; i++)
        {
            r = row + dR[i];
            c = col + dC[i];

            if (!mark[r][c])
            {
                if (currState == '(')
                {
                    if (matrix[r][c] == '(')
                    {
                        traverse(r, c, open + 1, close, '(');
                    }
                    else if(matrix[r][c] == ')')
                    {
                        traverse(r, c, open, close + 1, ')');
                    }
                }
                else if (currState == ')')
                {
                    if (matrix[r][c] == ')')
                    {
                        traverse(r, c, open, close + 1, ')');
                    }
                }
            }
        }
        mark[row][col] = false;
    }
}
