package Day3;

import java.util.*;

public class diamond {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] diamonds = new int[N];
        for (int i=0; i < N; i++)
        {
            diamonds[i] = sc.nextInt();
        }


        Arrays.sort(diamonds);

        int low = 0, high = 0;

        // streaks[i] stores best streak starting at index i.
        int[] streaks = new int[N];

        // Sweep through the array with two pointers.
        while (high < N)
        {

            // Valid interval check if it's the best and extend high.
            if (diamonds[high] - diamonds[low] <= K) {
                streaks[low] = Math.max(streaks[low], high-low+1);
                high++;
            }

            // Must move low to find new intervals.
            else
                low++;
        }

        // Just in case we need these to be accurate.
        for (int i=low+1; i < N; i++)
            streaks[i] = N - i;

        // lookup[i] = max(streaks[i...n-1])
        int[] lookup = new int[N];
        lookup[N - 1] = streaks[N - 1];
        for (int i= N - 2; i >= 0; i--)
        {
            lookup[i] = Math.max(lookup[i + 1], streaks[i]);
        }

        // Store best here.
        int ans = 0;

        // Try each possible low bound.
        for (int i = 0; i < N; i++)
        {
            int temp = streaks[i];
            if (i + streaks[i] < N) temp += lookup[i + streaks[i]];
            ans = Math.max(ans, temp);
        }
        System.out.println(ans);
    }
}