import java.util.Scanner;

public class EightQueens
{

    static int N;

   // checks if queen can be placed
    static boolean isSafe(int board[][], int row, int col)
    {
        int i, j;

       // Check this row on left side
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < N; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static int counter = 0;

    /* A recursive utility function
    to solve N Queen problem */
    static boolean solveNQUtil(int board[][], int col)
    {

        // base case
        if (col == N)
        {
            counter++;
            return true;
        }

	    // check this col and try placing queen in all rows one by one
        boolean res = false;
        for (int i = 0; i < N; i++)
        {

            // check if queen can be placed
            if ( isSafe(board, i, col) )
            {
                // place queen
                board[i][col] = 1;
                // recurse
                res = solveNQUtil(board, col + 1) || res;
                board[i][col] = 0; // BACKTRACK
            }
        }
        return res;
    }

    // Driver code
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int board[][] = new int[N][N];
       solveNQUtil(board,0);
       System.out.println(counter);
    }
}

