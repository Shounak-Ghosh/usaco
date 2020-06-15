import java.util.*;
public class cowdance
{

    private static int N;
    private static int maxT;
    private static int[] cows;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        maxT = sc.nextInt();
        cows = new int[N];
        int a;
        for (int i = 0; i < N; i++)
        {  a = sc.nextInt();
            cows[i] = a;
        }

        int low = 1 , high = N;
        while (low < high)
        {
            int mid = (low+high)/2;

            if (check(mid))
            {
                high = mid;
            }
            else
                low = mid+1;
        }
        System.out.println(low);
    }

    public static boolean check(int k)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i=0; i<k; i++)
        {
            pq.add(cows[i]);
        }

        for (int i = k; i < N; i++)
        {
            int curT = pq.remove();
            pq.add(cows[i]+curT);
        }

        int res = 0;
        while (pq.size() > 0)
        {
            res = Math.max(res, pq.remove());
        }
        return res <= maxT;
    }
}