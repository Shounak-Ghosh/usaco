

import java.util.*;
import java.io.*;

public class measurement
{

    public static int[] cowID;
    public static int[] delta;
    public static HashMap<Integer,Integer> cows;

    public static void main(String[] args) throws Exception {


        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(in.readLine());
        int n = Integer.parseInt(tok.nextToken());
        tok.nextToken();


        cowID = new int[1000001];
        delta = new int[1000001];
        cows = new HashMap<Integer,Integer>();
        int ID = 1;

        // Read in data.
        for (int i=0; i<n; i++) {

            // Store the cow in the appropriate day.
            tok = new StringTokenizer(in.readLine());
            int day = Integer.parseInt(tok.nextToken());
            cowID[day] = Integer.parseInt(tok.nextToken());

            // Add to our list if we've never seen this cow.
            if (!cows.containsKey(cowID[day])) cows.put(cowID[day], ID++);


            String tmp = tok.nextToken();
            if (tmp.charAt(0) == '+') tmp = tmp.substring(1);
            delta[day] = Integer.parseInt(tmp);
        }


        for (int i=0; i<cowID.length; i++)
            if (cowID[i] != 0)
                cowID[i] = cows.get(cowID[i]);

        int[] milk = new int[ID];
        TreeMap<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
        treeMap.put(0, ID);
        int ans = 0, max = 0;

        // Go through each day.
        for (int i=0; i<cowID.length; i++)
        {

            if (cowID[i] == 0) continue;

            // Get previous and current milk.
            int prev = milk[cowID[i]];
            int cur = prev + delta[i];
            milk[cowID[i]] = cur;


            int numOld = treeMap.get(prev);
            if (numOld == 1)
            {
                treeMap.remove(prev);
            }
            else
                treeMap.put(prev, numOld-1);


            if (treeMap.containsKey(cur))
                treeMap.put(cur, treeMap.get(cur)+1);
            else
                treeMap.put(cur, 1);


            if (prev < max && cur >= max) ans++;

            // Become unique best, after being in a tie.
            if (prev == max && numOld > 1 && cur > max) ans++;

            int newtop = treeMap.lastKey();


            if (prev == max && cur < newtop) ans++;


            if (prev == max && cur == newtop && treeMap.get(newtop) > 1) ans++;

            // Update max.
            max = newtop;
        }

        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(ans);
        out.close();
        in.close();
    }
}