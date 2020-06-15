import java.util.Scanner;

public class daisy
{
    private static int V,E;
    private static boolean[][] graph;
    private static boolean[] mark;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        mark = new boolean[V + 1];
        graph = new boolean[V + 1][V + 1];

        int x,y;
        for (int i = 0; i < E; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();
            graph[x][y] = true;
            graph[y][x] = true;
        }

        visit_dfs(1);

        int unmarked = 0;
        for(int i = 1; i <= V; i++)
        {
            if(!mark[i])
            {
                unmarked++;
                System.out.println(i);
            }
        }

        if(unmarked == 0)
        {
            System.out.println(0);
        }

    }

    public static void visit_dfs(int start)
    {
        mark[start] = true;
        for (int i = 1; i <= V; i++)
        {
            if (!mark[i] && graph[start][i])
            {
                visit_dfs(i);
                mark[i] = true;
            }
        }
    }
}
