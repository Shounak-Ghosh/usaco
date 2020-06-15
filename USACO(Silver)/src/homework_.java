import java.util.*;
import java.io.*;

public class homework_
{

    public static void main(String[] args) throws Exception
    {

        // Read the numbers.
        BufferedReader f = new BufferedReader(new FileReader("homework.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] vals = new int[n];
        st = new StringTokenizer(f.readLine());
        for (int i=0; i<n; i++)
            vals[i] = Integer.parseInt(st.nextToken());

        // Cumulative sums from back.
        int[] sum = new int[n];
        sum[n-1] = vals[n-1];
        for (int i=n-2; i>=0; i--)
            sum[i] = sum[i+1] + vals[i];

        // Minimums from back, also adjust sums.
        int[] min = new int[n];
        min[n-1] = vals[n-1];
        for (int i=n-2; i>=0; i--) {
            min[i] = Math.min(min[i+1], vals[i]);
            sum[i] -= min[i];
        }

        // Add best answers to res.
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(n-2);
        int besti = n-2;

        // Run backwards.
        for (int i=n-3; i>0; i--) {

            // See if this one's better.
            if (beat(sum[i], n-1-i, sum[besti], n-1-besti)) {
                besti = i;
                res.clear();
                res.add(i);
            }

            // Or equal, so just add to the list.
            else if (equal(sum[i], n-1-i, sum[besti], n-1-besti))
                res.add(i);
        }

        Collections.reverse(res);

        PrintWriter out = new PrintWriter(new FileWriter("homework.out"));
        for (int i=0; i<res.size(); i++)
            out.println(res.get(i));
        out.close();
        f.close();
    }

    public static boolean beat(int n1, int d1, int n2, int d2)
    {
        return ((long)n1)*d2 > ((long)n2)*d1;
    }

    public static boolean equal(int n1, int d1, int n2, int d2)
    {
        return ((long)n1)*d2 == ((long)n2)*d1;
    }
}