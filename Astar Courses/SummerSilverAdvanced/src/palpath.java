import java.util.Scanner;
import java.util.*;

@SuppressWarnings("unchecked")
public class palpath
{
    static int N;
    static char[][] grid;
    static HashSet<String>[] topLeft;
    static HashSet<String>[] bottomRight;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        char[] temp;
        grid = new char[N][N];
        for (int i = 0; i < N; i++)
        {
            temp = sc.next().toCharArray();
            for (int j = 0; j < temp.length; j++)
            {
                grid[i][j] = temp[j];
            }
        }

        topLeft = new HashSet[N];
        bottomRight = new HashSet[N];
        for (int i = 0; i < N; i++)
        {
            topLeft[i] = new HashSet<>();
            bottomRight[i] = new HashSet<>();
        }

        dfsTopLeft(grid,0,0,topLeft,"");
        dfsBottomRight(grid,N-1,N-1,bottomRight,"");

        for (int i = 0; i < N; i++)
        {
            System.out.println(topLeft[i].toString());
        }
        System.out.println();

        for (int i = 0; i < N; i++)
        {
            System.out.println(bottomRight[i].toString());
        }

        HashSet<String> palindromes = new HashSet<>();

        for (int i = 0; i < N; i++)
        {
            for(String key: topLeft[i])
            {
                if(bottomRight[i].contains(key))
                    palindromes.add(key);
            }
        }

        System.out.println(palindromes.size());

    }

    public static void dfsTopLeft(char[][] grid, int r, int c, Set<String>[] setArray, String str)
    {
        if(r >= 0 && r < N && c >= 0 && c < N)
        {
            if(r + c == N - 1)
            {
                setArray[r].add(str + grid[r][c]);
                return;
            }
            else
            {
                dfsTopLeft(grid, r + 1, c, setArray, str + grid[r][c]);
                dfsTopLeft(grid, r, c + 1, setArray, str + grid[r][c]);
            }
        }

    }

    public static void dfsBottomRight(char[][] grid, int r, int c, Set<String>[] setArray, String str)
    {
        if(r >= 0 && r < N && c >= 0 && c < N)
        {
            if(r + c == N - 1)
            {
                setArray[r].add(str + grid[r][c]);
                return;
            }
            else
            {
                dfsBottomRight(grid, r - 1, c, setArray, str + grid[r][c]);
                dfsBottomRight(grid, r, c - 1, setArray, str + grid[r][c]);
            }
        }
    }


}
