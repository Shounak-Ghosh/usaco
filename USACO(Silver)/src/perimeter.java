import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class perimeter
{
    private static char[][] matrix;
    private static char[][] mark;
    private static int[] dR = {0,0,-1,1};
    private static int[] dC = {1,-1,0,0};
    private static int currentArea = 0;
    private static int currentPerimeter = 0;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("perimeter.in"));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter("perimeter.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        matrix = new char[N + 2][N + 2];
        mark = new char[N + 2][N + 2];
        char[] row;
        for (int i = 1; i <= N; i++)
        {
            st = new StringTokenizer(f.readLine());
            row = st.nextToken().toCharArray();
            for (int j = 1; j <= N; j++)
            {
                matrix[i][j] = row[j - 1];
                mark[i][j] = row[j -1];
            }
        }
        //printMark();

        int bestArea = 0;
        int bestPerimeter = 0;
        for (int i = 1; i <= N; i++)
        {
            for (int j = 1; j <= N; j++)
            {
                if(mark[i][j] == '#')
                {
                    currentArea = 0;
                    currentPerimeter = 0;
                    solve(i,j); // modifies currentArea and currentPerimeter
                    if((currentArea > bestArea) || (currentArea == bestArea && currentPerimeter < bestPerimeter))
                    {
                        bestArea = currentArea;
                        bestPerimeter = currentPerimeter;
                    }
                    //printMark();
                }
            }
        }
        outf.println(bestArea +  " " + bestPerimeter);
        outf.close();
        f.close();
    }

    private static void solve(int r, int c)
    {
        if(mark[r][c] != '#')
        {
            return;
        }

        // r,c is a '#'
        currentPerimeter += 4;
        for(int i = 0; i < 4; i++)
        {
            if(matrix[r + dR[i]][c + dC[i]] == '#')
            {
                currentPerimeter--;
            }
        }

        mark[r][c] = '.'; // mark as visited
        currentArea++;

        for(int i = 0; i < 4; i++)
        {
            int row = r + dR[i];
            int col = c + dC[i];
            solve(row,col);
        }
    }

//    private static void printMark()
//    {
//        for(char[] row: mark)
//        {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();
//    }

}
