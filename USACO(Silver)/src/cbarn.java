import java.util.*;
import java.io.*;

public class cbarn
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new FileReader("cbarn.in"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        for (int i=0; i<N; i++)
        {
            st = new StringTokenizer(in.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;

        // Try each rotation.
        for (int i = 0; i < N; i++)
        {
            int[] rot = new int[N];
            for (int j=0; j < N; j++)
            {
                rot[j] = cows[(i+j)%N];
            }

            // See if this rotation is possible.
            int total = 0;
            boolean possible = true;
            for (int j= N-1; j >= 0; j--)
            {
                total += rot[j];
                if (total > N-j)
                {
                    possible = false;
                    break;
                }
            }

            if(possible)
            {
                // Find last 0 slot, initially.
                int cost = 0;
                int last = N-1;
                while (last >= 0 && rot[last] != 0)
                {
                    last--;
                }

                // Now go backwards.
                for (int j=last-1; j>=0; j--)
                {
                    // As long as this room has cows to donate.
                    while (rot[j] > 0)
                    {
                        if (last == -1 || last < j)
                            break;

                        // Move a cow from j to last.
                        rot[j]--;
                        rot[last]++;
                        cost += (last-j)*(last-j);

                        // Update last.
                        while (last >= 0 && rot[last] != 0)
                        {
                            last--;
                        }
                    }
                }

                // See if this is better or not.
                ans = Math.min(ans, cost);
            }
        }
        // Write result.
        PrintWriter out = new PrintWriter(new FileWriter("cbarn.out"));
        out.println(ans);
        out.close();
        in.close();
    }
}