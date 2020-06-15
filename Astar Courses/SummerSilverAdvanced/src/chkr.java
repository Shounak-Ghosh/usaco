import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class chkr
{
    static char[][] grid;
    static int N;
    static int[] dX = {-1,-1,1,1};
    static int[] dY = {-1,1,-1,1};
    static int numCheckers = 0;
    static ArrayList<Integer> xVisited;
    static ArrayList<Integer> yVisited;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new char[N + 2][N + 2];

        char[] temp;

        int index = 0;
        for (int i = 0; i < N; i++)
        {
            temp = sc.next().toCharArray();
            for (int j = 0; j < temp.length; j++)
            {
                grid[i + 1][j + 1] = temp[j];
                if (temp[j] == 'o')
                    numCheckers++;

            }
        }

//        for (char[] row: grid)
//        {
//            System.out.println(Arrays.toString(row));
//        }

        xVisited = new ArrayList<>();
        yVisited = new ArrayList<>();
        for (int r = 1; r <= N; r++)
        {
            for (int c = 1; c <= N; c++)
            {
                if (grid[r][c] == 'K')
                {
                    xVisited.clear();
                    yVisited.clear();
                    dfs(r,c,numCheckers,xVisited,yVisited);
                }
            }
        }

//        dfs(8,3,numCheckers,xVisited,yVisited);


    }

    public static void dfs(int r, int c, int checkersLeft, ArrayList<Integer> x, ArrayList<Integer> y)
    {
//        for (char[] row: grid)
//        {
//            System.out.println(Arrays.toString(row));
//        }
//        System.out.println();

        if(r < 1 || r > N || c < 1 || c > N)
        {
            return;
        }

        if (checkersLeft == 0)
        {
            for (int i = 0; i < x.size(); i++)
            {
                System.out.println(x.get(i) + " " + y.get(i));
            }
            System.out.print(r + " " + c); // the current position
            return;
        }

        for (int i = 0; i < 4; i++)
        {
            int row = r + dX[i];
            int col = c + dY[i];

            if ((row >= 1 && row <= N && col >= 1 && col <= N) && grid[row][col] == 'o')
            {
                grid[r][c] = '+'; // empty the kings current position
                grid[row][col] = '+'; // remove the checker
                x.add(r);
                y.add(c);
                dfs(r + 2 * dX[i], c + 2 * dY[i],checkersLeft - 1,x,y);
                grid[r][c] = 'K';
                grid[row][col] = 'o';
                x.remove(x.size() - 1);
                y.remove(y.size() - 1);

            }
        }
    }
}
