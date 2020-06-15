import java.util.*;

public class mud
{
    private static int finish_x, finish_y;
    private static int[][] field;
    private static int[] dx = { 0, 0, -1, 1 }, dy = { -1, 1, 0, 0 };

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        finish_x = sc.nextInt() + 510;
        finish_y = sc.nextInt() + 510;
        int numPuddles = sc.nextInt();
        field = new int[1020][1020];
        for (int i = 0; i < numPuddles; i++)
        {
            field[sc.nextInt() + 510][sc.nextInt() + 510] = -1; // puddle
        }
        System.out.println(bfs(510, 510, 0));
    }

    public static int bfs(int cX, int cY, int index)
    {

        Queue<Integer> x = new ArrayDeque<>();
        Queue<Integer> y = new ArrayDeque<>();
        Queue<Integer> indexes = new ArrayDeque<>();

        do {
            for (int i = 0; i < 4; i++)
            {
                if (cX + dx[i] >= 0 && cX + dx[i] < 1020 && cY + dy[i] >= 0
                        && cY + dy[i] < 1020)
                {
                    if (field[cX + dx[i]][cY + dy[i]] == 0)
                    {
                        field[cX + dx[i]][cY + dy[i]] = index + 1;
                        x.add(cX + dx[i]);
                        y.add(cY + dy[i]);
                        indexes.add(index + 1);
                    }
                }
            }
            cY = y.remove();
            cX = x.remove();
            index = indexes.remove();
            if (cY == finish_y && cX == finish_x)
                return index;
        } while (!y.isEmpty());
        return 0;
    }
}