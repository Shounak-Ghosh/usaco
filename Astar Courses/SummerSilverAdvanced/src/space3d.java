import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class space3d
{

    static char[][][] space;
    static int x, y, z;

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        y = x;
        z = x;
        space = new char[x][y][z];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                String temp = sc.next();
                for (int k = 0; k < z; k++)
                {
                    space[i][j][k] = temp.charAt(k);
                }
            }
        }
        int numAsteroids = 0;
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                for (int k = 0; k < z; k++)
                {
                    if (space[i][j][k] == '*')
                    {
                        bfs(i, j, k);
                        numAsteroids++;
                    }
                }
            }
        }
       System.out.println(numAsteroids);
    }

    public static void bfs(int nX, int nY, int nZ)
    {
        Queue<Integer> xQ = new ArrayDeque<>();
        Queue<Integer> yQ = new ArrayDeque<>();
        Queue<Integer> zQ = new ArrayDeque<>();
        xQ.add(nX);
        yQ.add(nY);
        zQ.add(nZ);
        while (!xQ.isEmpty())
        {
            nX = xQ.remove();
            nY = yQ.remove();
            nZ = zQ.remove();
            if (nX > 0  && nX < x)
            {
                if (space[nX - 1][nY][nZ] == '*')
                {
                    space[nX - 1][nY][nZ] = 'f';
                    xQ.add(nX - 1);
                    yQ.add(nY);
                    zQ.add(nZ);
                }
            }
            if (nX < x - 1 && nX >= 0)
            {
                if (space[nX + 1][nY][nZ] == '*')
                {
                    space[nX + 1][nY][nZ] = 'f';
                    xQ.add(nX + 1);
                    yQ.add(nY);
                    zQ.add(nZ);
                }
            }

            if (nY > 0 && nY < y)
            {
                if (space[nX][nY - 1][nZ] == '*')
                {
                    space[nX][nY - 1][nZ] = 'f';
                    xQ.add(nX);
                    yQ.add(nY - 1);
                    zQ.add(nZ);
                }
            }

            if (nY < y - 1 && nY >= 0)
            {
                if (space[nX][nY + 1][nZ] == '*')
                {
                    space[nX][nY + 1][nZ] = 'f';
                    xQ.add(nX);
                    yQ.add(nY + 1);
                    zQ.add(nZ);
                }
            }

            if (nZ < z - 1 && nZ >= 0)
            {
                if (space[nX][nY][nZ + 1] == '*')
                {
                    space[nX][nY][nZ + 1] = 'f';
                    xQ.add(nX);
                    yQ.add(nY);
                    zQ.add(nZ + 1);
                }
            }

            if (nZ > 0 && 1 < z)
            {
                if (space[nX][nY][nZ - 1] == '*')
                {
                    space[nX][nY][nZ - 1] = 'f';
                    xQ.add(nX);
                    yQ.add(nY);
                    zQ.add(nZ - 1);
                }
            }
        }
    }
}