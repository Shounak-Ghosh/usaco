package Day4;

import java.util.*;
import java.io.*;

public class maxcross
{

    public static void main(String[] args) throws Exception
    {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(tok.nextToken());
        int K = Integer.parseInt(tok.nextToken());
        int broken = Integer.parseInt(tok.nextToken());

        // Initially all good.
        int[] sum = new int[N];
        Arrays.fill(sum, 1);

        // Set the broken ones.
        for (int i=0; i<broken; i++)
            sum[Integer.parseInt(in.readLine().trim())-1] = 0;

        // Get sum of first K items.
        int cur = 0;
        for (int i=0; i<K; i++)
            cur += sum[i];

        // Set up best streak of K.
        int best = cur;

        // Sweep across, keeping interval of size K by sub last, adding next.
        for (int i = K; i < N; i++)
        {
            cur += (sum[i] - sum[i-K]);
            best = Math.max(best, cur);
        }


        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(K - best);
        out.close();
        in.close();
    }
}