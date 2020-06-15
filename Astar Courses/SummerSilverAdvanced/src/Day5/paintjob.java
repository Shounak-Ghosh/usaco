package Day5;

import java.util.LinkedList;
        import java.util.Queue;
        import java.util.Scanner;

public class paintjob
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int P = sc.nextInt();
        int[] buckets = new int[N];
        int[] dist = new int[P + 1];
        boolean[] visited = new boolean[P + 1];

        Queue<Integer> Q = new LinkedList<>();
        for(int i = 0; i < N; i++)
        {
            buckets[i] = sc.nextInt();
        }

        visited[A] = true;
        Q.add(A);
        int currentV = 0;
        int next = 0;

        while (!Q.isEmpty())
        {
            currentV = Q.remove();
            for (int i = 0; i < N; i++)
            {
                next = (currentV * buckets[i]) % P;
                if(!visited[next])
                {
                    dist[next] = dist[currentV] + 1;
                    visited[next] = true;
                    Q.add(next);
                }
            }
        }

        if(dist[B] == 0)
        {
            System.out.println("-1");
        }
        else
        {
            System.out.println(dist[B]);
        }
    }
}
