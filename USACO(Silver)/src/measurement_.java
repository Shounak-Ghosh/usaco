import java.util.*;
import java.io.*;

public class measurement_
{
    public static void main(String[] args) throws Exception
    {
        int[] cowID;
        int[] delta;
        HashMap<Integer,Integer> cows;

        // Read the numbers.
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        st.nextToken();

        // So I don't need to sort the input...
        cowID = new int[1000001];
        delta = new int[1000001];
        cows = new HashMap<Integer,Integer>();
        int ID = 1;

        // Read in data.
        for (int i = 0; i < N; i++)
        {
            // Store the cow in the appropriate day.
            st = new StringTokenizer(f.readLine());
            int day = Integer.parseInt(st.nextToken());
            cowID[day] = Integer.parseInt(st.nextToken());

            // Add to our list if we've never seen this cow.
            if (!cows.containsKey(cowID[day]))
                cows.put(cowID[day], ID++);

            // This is annoying.
            String tmp = st.nextToken();
            if (tmp.charAt(0) == '+') tmp = tmp.substring(1);
            delta[day] = Integer.parseInt(tmp);
        }

        // Remap cows.
        for (int i=0; i<cowID.length; i++)
            if (cowID[i] != 0)
                cowID[i] = cows.get(cowID[i]);

        int[] milk = new int[ID];
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();
        tm.put(0, ID);
        int res = 0, max = 0;

        // Go through each day.
        for (int i=0; i<cowID.length; i++)
        {

            if (cowID[i] == 0) continue;

            // Get previous and current milk.
            int prev = milk[cowID[i]];
            int cur = prev + delta[i];
            milk[cowID[i]] = cur;

            // Change Tree Map - remove old value.
            int numOld = tm.get(prev);
            boolean flag = false;
            if (numOld == 1)
            {
                flag = true;
                tm.remove(prev);
            }
            else
                tm.put(prev, numOld-1);

            // Place new value.
            if (tm.containsKey(cur))
                tm.put(cur, tm.get(cur)+1);
            else
                tm.put(cur, 1);

            // Wasn't best now I am.
            if (prev < max && cur >= max) res++;

            // Become unique best, after being in a tie.
            if (prev == max && numOld > 1 && cur > max) res++;

            int newtop = tm.lastKey();

            // Was best now I am not.
            if (prev == max && cur < newtop) res++;

            // Was best, still am best, but now I share.
            if (prev == max && cur == newtop && tm.get(newtop) > 1) res++;

            // Update max.
            max = newtop;
        }

        PrintWriter outf = new PrintWriter(new FileWriter("measurement.out"));
        outf.println(res);
        outf.close();
        f.close();
    }
}