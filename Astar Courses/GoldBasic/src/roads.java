import java.util.*;

public class roads
{
    private static final int INF = 999999999;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        // read input
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] coordinates = new int[N][2];
        HashSet<Pair> built = new HashSet<>();
        for (int i = 0; i < N; i++)
        {

            coordinates[i][0] = sc.nextInt();
            coordinates[i][1] = sc.nextInt();
        }

        int a,b = 0;
        for (int i = 0; i < M; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            built.add(new Pair(a,b));
            built.add(new Pair(b,a));

        }

        boolean[] visited = new boolean[N];

        int start = 0;

        double[] distances = new double[N];
        for (int i = 0; i < N; i++)
        {
            int dX = coordinates[i][0] - coordinates[start][0];
            int dY = coordinates[i][1] - coordinates[start][1];
            distances[i] = Math.sqrt(dX*dX + dY*dY);
            if(built.contains(new Pair(start,i)))
            {
                distances[i] = 0;
            }
        }
        visited[start] = true;
        distances[start] = 0;
        double cost = 0;

        // loop N-1 times
        for (int i = 1; i < N; i++)
        {
            int index = 0;
            double distance = INF;
            for (int j = 0; j < N; j++)
            {
                if (distances[j] < distance && !visited[j])
                {
                    distance = distances[j];
                    index = j;
                }
            }

            visited[index] = true;
            cost += distances[index];

            for (int j = 0; j < N; j++)
            {
                int dX = coordinates[j][0] - coordinates[index][0];
                int dY = coordinates[j][1] - coordinates[index][1];
                distances[j] = Math.sqrt(dX*dX + dY*dY);
                if(built.contains(new Pair(j,index)))
                {
                    distances[j] = 0;
                }
            }
        }
        System.out.println(cost);
    }

    static class Pair
    {
        public Integer x;
        public Integer y;
        public  Pair(int a, int b)
        {
            x = a;
            y = b;
        }

        public int hashCode()
        {
            return x.hashCode() + y.hashCode();
        }

        public boolean equals(Object other)
        {
           if(other instanceof Pair)
           {
               Pair o = (Pair) other;
               return o.x.equals(x) && o.y.equals(y);
           }
           return false;
        }
    }

}