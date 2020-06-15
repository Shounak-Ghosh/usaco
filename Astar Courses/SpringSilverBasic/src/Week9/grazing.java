package Week9;

import java.util.Arrays;
import java.util.Scanner;

public class grazing
{

    static int[] dR = {0,0,-1,1};
    static int[] dC = {1,-1,0,0};
    static int answer;
    static int numGrassy;
    static char[][] matrix = new char[5][5];

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numBarren = sc.nextInt();
        int r = 0;
        int c = 0;

        numGrassy  = 25 - numBarren;
        for(int i = 0; i < numBarren; i++)
        {
            r = sc.nextInt() -1;
            c = sc.nextInt() -1;
            matrix[r][c] = 'X';
        }

        answer = 0;
        //System.out.println(numGrassy);
        /*for(char[] row: matrix)
        {
            System.out.println(Arrays.toString(row));
        }
        System.out.println();
        */
        solve(0,0,1);

        System.out.println(answer);

    }

    public static void solve(int r, int c, int len)
    {
        /*for(char[] row: matrix)
        {
            System.out.println(Arrays.toString(row));
        }*/

        if(!isValid(r,c)) // out of bounds
        {
            return;
        }

        if(matrix[r][c] != '\0') // if barren
        {
            return;
        }

        if(r == 4 && c == 4)
        {
            //System.out.println("Len: " + len);
            if(len == numGrassy)
            {
                //System.out.println("ANSWER");
                answer++;
                return;
            }
        }

        // if len equals num grassy and the position is 4,4
        /*if(r == 4 && c == 4 && len == numGrassy)
        {
            answer++;
            return;
        }*/
        //System.out.println();

        matrix[r][c] = 'p';
        for(int i = 0; i < 4; i++)
        {
            int row = r + dR[i];
            int col = c + dC[i];
            if(isValid(row, col) && matrix[row][col] == '\0')
            {
                solve(row, col, len + 1);
            }
        }
        matrix[r][c] = '\0';
    }

    public static boolean isValid(int r, int c)
    {
        return  !(r >= 5 || c >= 5 || r < 0 || c < 0);
    }
}
