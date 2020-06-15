import java.util.*;

public class agrinet
{

    static final int INF = 999999999;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        TreeSet<Integer> set = new TreeSet<>();

        // read input
        int N = sc.nextInt();
        int[][] matrix = new int[N][N]; // stores the distance
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                matrix[i][j] = sc.nextInt();

                if (i == j)
                {
                    matrix[i][j] = INF;
                }
                set.add(matrix[i][j]);
            }
        }

        System.out.println(set);

        int currentNode = 0;
        boolean[] visited = new boolean[N];
        visited[0] = true;
        int cost = 0;
        int min = INF;
        int index = 0;
        for (int i = 0; i < N - 1; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if(!visited[j])
                {
                   if (min > matrix[currentNode][j])
                   {
                       min =  matrix[currentNode][j];
                       index = j;
                   }
                }
            }
            cost += min;
            System.out.println(min);
            min = INF;
            visited[index] = true;
            currentNode = index;
        }

        System.out.println(cost);
    }

}