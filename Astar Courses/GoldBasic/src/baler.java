import java.util.*;

public class baler
{
    private static int N, powerIndex;
    private static Roller[] rollers;
    private static int[][] graph;
    private static boolean[] visited;
    private static Stack<Integer> stack = new Stack<>(); // stores the path from the driver to the roller

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        int pX = in.nextInt();
        int pY = in.nextInt();
        int startIndex = 0;
        rollers = new Roller[N];
        for (int i = 0; i < N; i++)
        {
            int x = in.nextInt();
            int y = in.nextInt();
            int r = in.nextInt();
            if (x == pX && y == pY) powerIndex = i;
            if (x == 0 && y == 0) startIndex = i;
            rollers[i] = new Roller(x, y, r);
        }

        graph = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if ( i != j && Math.pow(rollers[i].x - rollers[j].x, 2) + Math.pow(rollers[i].y - rollers[j].y, 2) == Math.pow(rollers[i].r + rollers[j].r, 2))
                {
                    graph[i][j] = 1;
                }
            }
            visited[i] = false;
        }
        dfs(startIndex);

        int prevR = rollers[startIndex].r;
        double prevSpeed = 10000;
        double speed = prevSpeed;
        while (!stack.isEmpty())
        {
            int currentIndex = stack.pop();
            int currentR = rollers[currentIndex].r;
            double currentSpeed = prevSpeed * prevR / (double) currentR;
            speed += currentSpeed;
            prevR = currentR;
            prevSpeed = currentSpeed;
        }
        System.out.println(Math.abs((int) speed));

    }

    public static boolean dfs(int index)
    {
        visited[index] = true;
        if (index == powerIndex)
        {
            return true;
        }
        else
        {
            for (int i = 0; i < N; i++)
            {
                if (!visited[i] && graph[i][index] == 1)
                {
                    if (dfs(i))
                    {
                        stack.push(i);
                        return true;
                    }
                }
            }
            return false;
        }
    }

}

class Roller
{
    int x, y, r;
    public Roller(int newX, int newY, int newR)
    {
        x = newX;
        y = newY;
        r = newR;
    }
}