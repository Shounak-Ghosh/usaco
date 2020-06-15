package Diagnostic;

import java.util.*;

public class munch
{
    private static int numRows;
    private static int numCols;
    private static int startRow;
    private static int startCol;
    private static int finishRow;
    private static int finishCol;
    private static char[][] grid;
    private static int[][] matrix;


    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        numRows = sc.nextInt();
        numCols = sc.nextInt();
        grid = new char[numRows][numCols];
        matrix = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++)
        {
            String temp = sc.next();

            startCol = 0;
            startRow = 0;

            grid[0][0] = '.';
            for (int j = 0; j < numCols; j++)
            {
                grid[i][j] = temp.charAt(j);
                if (grid[i][j] == 'C')
                {
                    finishRow = i;
                    finishCol = j;
                }
            }
        }

        BFS(finishRow, finishCol, 1);
    }

    public static void BFS(int row, int col, int index)
    {
        Queue<Integer> x = new LinkedList<Integer>();
        Queue<Integer> y = new LinkedList<Integer>();
        Queue<Character> indexes = new LinkedList<Character>();
        while (true) // bad structure
        {
            if (col > 0)
            {
                if (grid[row][col - 1] == '.')
                {
                    grid[row][col - 1] = 'X';
                    matrix[row][col - 1] =  index;
                    x.add(col - 1);
                    y.add(row);
                    indexes.add((char) index);
                }
            }
            // check right
            if (col < numCols - 1)
            {
                if (grid[row][col + 1] == '.')
                {
                    grid[row][col + 1] = 'X';
                    matrix[row][col + 1] = index;
                    x.add(col + 1);
                    y.add(row);
                    indexes.add((char) index);
                }
            }
            // check up
            if (row > 0)
            {
                if (grid[row - 1][col] == '.')
                {
                    grid[row - 1][col] = 'X';
                    matrix[row - 1][col] = index;
                    x.add(col);
                    y.add(row - 1);
                    indexes.add((char) index);
                }
            }
            // check down
            if (row < numRows - 1)
            {
                if (grid[row + 1][col] == '.')
                {
                    grid[row + 1][col] = 'X';
                    matrix[row + 1][col] = index;
                    x.add(col);
                    y.add(row + 1);
                    indexes.add((char) index);
                }
            }

            // check left is not needed, barn is always to the right of bessie


            if (row == startRow && col == startCol)
            {
                System.out.println(matrix[startRow][startCol]);
                return;
            }

            row = y.peek();
            y.remove();
            col = x.peek();
            x.remove();
            index = indexes.peek() + 1;
            indexes.remove();
        }
    }
}