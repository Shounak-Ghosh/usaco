import java.util.*;

public class maze1 {

    public static void main(String[] args)
    {


        Scanner in = new Scanner(System.in);
        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
        // read input
        int W = in.nextInt();
        int H = in.nextInt();
        int[][] dist = new int[W][H];
        Queue<Point> Q = new ArrayDeque<>();
        char[][] maze = new char[2 * W + 1][2 * H + 1];
        in.nextLine();
        for (int i = 0; i < 2 * H + 1; i++)
        {
            String line = in.nextLine();
            for (int j = 0; j < 2 * W + 1; j++)
            {
                maze[j][i] = line.charAt(j);
            }
        }

//        for (int i = 0; i < 2 * H + 1; i++)
//        {
//            for (int j = 0; j < 2 * W + 1; j++)
//            {
//                System.out.print(maze[j][i] + " ");
//            }
//            System.out.println();
//        }


        for (int i = 1; i < W * 2 + 1; i += 2)
        {
            if (maze[i][0] == ' ')
                Q.add(new Point((i - 1) / 2, 0, 1));
            if (maze[i][H * 2] == ' ')
                Q.add(new Point((i-1)/2, H-1, 1));
        }

        for (int i = 1; i < H * 2; i += 2)
        {
            if (maze[0][i] == ' ')
                Q.add(new Point(0, (i-1)/2, 1));
            if (maze[W * 2][i] == ' ')
                Q.add(new Point(W - 1, (i-1)/2, 1));
        }

        int numFilled = 0;

        // bfs
        while (!Q.isEmpty())
        {
            Point current = Q.remove();
            if (dist[current.x][current.y] == 0)
            {
                dist[current.x][current.y] = current.d;
                numFilled++;
                if (numFilled == W * H)
                {
                    System.out.println(current.d);
                    break;
                }
                for (int i = 0; i < 4; i++)
                {
                    if ((current.x + dir[i][0]) < W && (current.x + dir[i][0]) >= 0)
                    {
                        if ((current.y + dir[i][1]) < H && (current.y + dir[i][1]) >= 0)
                        {
                            if (maze[current.x * 2 + 1 + dir[i][0]][current.y * 2 + 1 + dir[i][1]] == ' ')
                            {
                                Q.add(new Point(current.x + dir[i][0], current.y + dir[i][1], current.d + 1));
                            }
                        }
                    }
                }
            }
        }
    }

}

class Point
{
    int x, y, d;

    Point(int a, int b, int c)
    {
        x = a;
        y = b;
        d = c;
    }
}