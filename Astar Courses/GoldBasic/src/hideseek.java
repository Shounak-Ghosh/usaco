import java.util.*;

public class hideseek
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < N; i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < M; i++)
        {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Barns> Q = new ArrayDeque<>();
        //int[] distances = new int[N];
        boolean[] visited = new boolean[N];
        int bestDist = -1, bestIndex = 0, number = 0;
        Q.add(new Barns(0,0));
        while (!Q.isEmpty())
        {
            Barns current = Q.remove();
            int index = current.index;
            int distance = current.distance;
            visited[index] = true;
            //distances[index] = distance;
            if (distance > bestDist)
            {
                bestDist = distance;
                bestIndex = index;
                number = 1;
            }
            else if (distance == bestDist)
            {
                number++;
                bestIndex = Math.min(bestIndex, index);
            }
            for (int i : graph.get(index))
            {
                if (!visited[i])
                {
                    Barns barn = new Barns(i, distance + 1);
                    visited[i] = true;
                    Q.add(barn);
                }
            }
        }
        System.out.println((bestIndex+1) + " " + bestDist + " " + number);
    }

}

class Barns
{
    int index, distance;
    public Barns(int i, int d)
    {
        index = i;
        distance = d;
    }
}