import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class perimeter
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
        numCols = numRows;
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


        printMatrix();

        for(int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {
                if(matrix[r][c] == '#')
                {
                    solve(r,c); // modifies the matrix
                    answer++;

                }
                printMatrix();
            }

        }


        System.out.println(areas);

        System.out.println(answer);


    }

    static ArrayList<Integer> areas = new ArrayList<>();
    static int currentArea = 1;

    public static void solve(int r, int c)
    {
        if(!isValid(r,c))
        {
            return;
        }

        if(matrix[r][c] != '#')
        {
            return;
        }

        matrix[r][c] = '.';

        currentArea++;

        for(int i = 0; i < 4; i++)
        {
            int row = r + dR[i];
            int col = c + dC[i];
            solve(row,col);
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
}

