import java.util.*;
import java.io.*;

public class cowdance
{
    public static int N;
    private static int tMax;
    public static int[] cows;

    public static void main(String[] args) throws Exception
    {
        // Read in input.
        BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("cowdance.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        tMax = Integer.parseInt(st.nextToken());
        cows = new int[N];

        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(f.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }

        // Run a standard binary search, looking for the minimum value of K.
        int low = 1 , high = N;
        while (low < high)
        {
            int mid = (low+high)/2;

            if (isValid(mid))
                high = mid;
            else
                low = mid+1;
        }

        // Here is our result, the larger of these two.
        outf.println(low);
        outf.close();
        f.close();
    }

    // Returns true if k cows will finish on time.
    private static boolean isValid(int k)
    {
        // Put in the first k cows into the priority queue.
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i=0; i < k; i++)
        {
            pq.add(cows[i]);
        }

        // Now, place the rest of the cows in the Priority Queue - basically, get one
        // out and put in the finishing time of the next.
        for (int i = k; i < N; i++)
        {
            int curT = pq.remove();
            pq.add(cows[i]+curT);
        }

        // Now, get everyone off the stage!
        int totalTime = 0;
        while (!pq.isEmpty())
        {
            totalTime = Math.max(totalTime, pq.remove());
        }

        // Here is whether we finished on time or not.
        return totalTime <= tMax;
    }
}