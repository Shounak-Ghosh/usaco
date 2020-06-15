package Day5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class flyingcow
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Queue<Integer>  Q = new LinkedList<Integer>();

        boolean[] visted = new boolean[N + 2];
        int[] dist = new int[N + 2];

        visted[0] = true;
        visted[1] = true;
        dist[0] = 0;
        dist[1] = 0;

        Q.add(1);

        int currentV = 0;
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;

        while (!Q.isEmpty())
        {
            currentV =  Q.remove();
            n1 = currentV  * 3;
            n2 = currentV - 1;
            n3 = currentV + 1;

            if(n1 > 0 && n1 <= N && !visted[n1])
            {
                dist[n1] = dist[currentV] + 1;
                visted[n1] = true;
                Q.add(n1);
            }

            if(n2 > 0  && n2 <= N && !visted[n2])
            {
                dist[n2] = dist[currentV] + 1;
                visted[n2] = true;
                Q.add(n2);
            }

            if(n3 > 0 && n3 <= N && !visted[n3])
            {
                dist[n3] = dist[currentV] + 1;
                visted[n3] = true;
                Q.add(n3);
            }
        }
        System.out.println(dist[N]);

    }
}
