import java.io.*;
import java.util.*;

public class mountains_
{
    public static int N;
    public static Pair[] list;

    public static void main(String[] args) throws Exception
    {
        // Read in the list and sort it!
        BufferedReader f = new BufferedReader(new FileReader("mountains.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("mountains.out"));
        N = Integer.parseInt(f.readLine().trim());
        list = new Pair[N];
        for (int i=0; i<N; i++)
        {
            StringTokenizer tok = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(tok.nextToken());
            int y = Integer.parseInt(tok.nextToken());
            list[i] = new Pair(x, y);
        }
        Arrays.sort(list);

        int ans = 1;
        int i = 1;
        int maxSum = list[0].sum;

        // Sweep through; first mountain must be a visible peak.
        while (i < N)
        {
            // I sort where these are smaller and enveloped by the first peak.
            int prevI = i-1;
            while (i < N && list[i].diff == list[prevI].diff)
                i++;

            // exit
            if (i == N) break;

            // See if new line gets past old one.
            if (list[i].sum > maxSum)
            {
                ans++;
                maxSum = list[i].sum;
            }

            // Go to next line.
            i++;
        }

        // Ta da!
        outf.println(ans);
        outf.close();
        f.close();
    }

}

class Pair implements Comparable<Pair>
{
    public int diff;
    public int sum;

    public Pair(int myx, int myy)
    {
        diff = myx-myy;
        sum = myx+myy;
    }

    // Sort differences small to big, with ties going sums big to small.
    public int compareTo(Pair other)
    {
        if (diff != other.diff) return diff-other.diff;
        return other.sum - this.sum;
    }
}
