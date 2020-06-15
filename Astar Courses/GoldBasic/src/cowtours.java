import java.util.Scanner;
import java.math.BigDecimal;

// todo fix 1.0 not being outputted as 1.000000
public class cowtours
{
    private static int n;
    private static int[] x, y;
    private static double[][] g;
    private static double[] maxDistance;
    private static final double INFINITE = 1e20;
    private static double ans = INFINITE;

    public  static double getDistance(int p1, int p2)
    {
        double dx = x[p1]-x[p2];
        double dy = y[p1]-y[p2];

        return Math.sqrt(dx*dx + dy*dy);
    }

    public static double truncate(double value, int places)
    {
        if (places < 0) {
            throw new IllegalArgumentException();
        }

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = (long) value;
        return (double) tmp / factor;
    }

    public static double round(double value, int places)
    {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        x = new int[n + 1];
        y = new int[n + 1];
        g = new double[n + 1][n + 1];
        maxDistance = new double[n + 1];

        int a,b;
        for (int i = 0; i < n; ++i)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            x[i] = a;
            y[i] = b;
        }

        char[] line;
        for (int i = 0; i < n; ++i)
        {
            line = sc.next().toCharArray();
            for (int j = 0; j < n; ++j)
            {
                if(line[j] == '1')
                {
                    g[i][j] = getDistance(i,j);
                }
                else
                {
                    g[i][j] = INFINITE;
                }

            }
        }

        for (int i = 0; i < n; ++i)
        {
            g[i][i] = 0;
        }

        // calculate shorest path
        for (int k = 0; k < n; ++k)
        {
            for (int i = 0; i < n; ++i)
            {
                for (int j = 0; j < n; ++j)
                {
                    if (g[i][k] + g[j][k] < g[i][j])
                    {
                        g[i][j] = g[i][k] + g[j][k];
                    }
                }
            }
        }

        for (int p = 0; p < n; ++p)
        {
            maxDistance[p] = 0;
        }

        for (int p = 0; p < n; ++p)
        {
            for (int src = 0; src < n; ++src)
            {
                if (g[p][src] != INFINITE && g[p][src] > maxDistance[p])
                {
                    maxDistance[p] = g[p][src];
                }
            }
        }

        for (int p1 = 0; p1 < n; p1++)
        {
            for (int p2 = 0; p2 < n; p2++)
            {
                // select two different area
                if (g[p1][p2] != INFINITE) {
                    continue;
                }

                // get max distance in area1
                double max1 = maxDistance[p1];
                double max2 = maxDistance[p2];
                double distance = max1 + max2 + getDistance(p1, p2);

                if (distance < ans)
                {
                    ans = distance;
                }
            }
        }

        for (int p = 0; p < n; ++p)
        {
            if (maxDistance[p] > ans)
            {
                ans = maxDistance[p];
            }
        }
        //System.out.println(ans);
        //System.out.println(round(ans,6));
        ans = round(ans,6);
        String res = "" + ans;
        if(res.endsWith(".0"))
        {
            res += "00000";
        }
        System.out.println(res);
    }
}
