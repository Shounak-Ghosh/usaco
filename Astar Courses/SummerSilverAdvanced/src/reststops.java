

import java.io.*;
import java.util.*;

public class reststops {

    public static int len;
    public static int n;
    public static long tJohn;
    public static long tBessie;
    public static grass[] eats;

    public static void main(String[] args) throws Exception {

        // Read the data.
        BufferedReader stdin = new BufferedReader(new FileReader("reststops.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());

        // Get basic data.
        len = Integer.parseInt(tok.nextToken());
        n = Integer.parseInt(tok.nextToken());
        tJohn = Long.parseLong(tok.nextToken());
        tBessie = Long.parseLong(tok.nextToken());

        // Get each grass patch.
        eats = new grass[n];
        for (int i=0; i<n; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int x = Integer.parseInt(tok.nextToken());
            int val = Integer.parseInt(tok.nextToken());
            eats[i] = new grass(x, val);
        }
        Arrays.sort(eats);

        long res = 0;
        int curX = 0;

        // Go through each grass spot in order of value.
        for (int i=0; i<n; i++)
        {

            // We passed this grass, so skip it.
            if (eats[i].x <= curX) continue;

            // How long we can eat here.
            long xDiff = (long)(eats[i].x-curX);
            long tEat = xDiff*(tJohn-tBessie);

            // Value of what we can eat for this time.
            res += tEat*eats[i].value;

            // Update the current x value.
            curX = eats[i].x;
        }

        // Ta da!
        PrintWriter out = new PrintWriter(new FileWriter("reststops.out"));
        out.print(res);
        out.close();
        stdin.close();
    }
}

class grass implements Comparable<grass> {

    public int x;
    public int value;

    public grass(int myx, int myv) {
        x = myx;
        value = myv;
    }

    public int compareTo(grass other) {
        return other.value - this.value;
    }
}