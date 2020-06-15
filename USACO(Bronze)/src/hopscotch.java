import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hopscotch
{

    static char[][] grid;
    static int numRows;
    static int numCols;
    static int numPaths;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("hopscotch.in"));
        PrintWriter outf = new PrintWriter(new File("hopscotch.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numRows = Integer.parseInt(st.nextToken());
        numCols = Integer.parseInt(st.nextToken());

        grid = new char[numRows + 2][numCols + 2];
        char[] temp;
        int counter = 0;

        for(int r = 1; r <= numRows; r++)
        {
            st = new StringTokenizer(f.readLine());
            temp = st.nextToken().toCharArray();
            for(int c = 1; c <= numCols; c++)
            {
                grid[r][c] = temp[counter];
                counter++;
            }
            counter = 0;
        }


//        for(char[] arr: grid)
//        {
//            System.out.println(Arrays.toString(arr));
//        }
        numPaths = 0;
        countPaths(1,1);
        outf.println(numPaths);
        f.close();
        outf.close();
    }



    public static void countPaths(int row, int col)
    {
        // bottom right square reached
        if(row == numRows  && col == numCols )
        {
            numPaths++;
            return;
        }

        // col boundary check
        if(row >= numRows || col >= numCols)
        {
            return;
        }

        if(row <= 0 || col <= 0)
        {
            return;
        }

        for(int r = row + 1; r <= numRows; r++)
        {
            for(int c = col + 1; c <= numCols; c++)
            {
                if(grid[row][col] != grid[r][c])
                {
                    //System.out.println("r: " + r + "\t c: " + c +"\t row: " + row + "\t col: " + col);
                    countPaths(r,c);
                }
            }
        }
    }
}
