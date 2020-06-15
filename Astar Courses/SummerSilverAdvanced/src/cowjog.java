// Arup Guha
// Solution to Decmber 2014 USACO Bronze Problem: Cow Jog

import java.util.*;
import java.io.*;
public class cowjog {

    public static void main(String[] args) throws Exception {

        Scanner fin = new Scanner(new File("cowjog.in"));
        PrintWriter fout = new PrintWriter("cowjog.out");

        // Read in data into cow objects.
        int n = fin.nextInt();
        cow[] myCows = new cow[n];
        for (int i=0; i<n; i++) {
            int first = fin.nextInt();
            int second = fin.nextInt();
            myCows[i] = new cow(first, second);
        }

        // This is key.
        Arrays.sort(myCows);

        // Go through cows in this order, they get a group if they're
        // position is after the LAST cow that has a group.
        int cnt = 0, curPos = -1;
        for (int i=0; i<n; i++) {
            if (myCows[i].first > curPos)
            {
                cnt++;
                curPos = myCows[i].first;
            }
        }

        // Print the result.
        fout.print(cnt);
        fin.close();
        fout.close();
    }
}

class cow implements Comparable<cow> {

    public int first;
    public int second;

    public cow(int start, int velocity) {

        first = start;
        second = velocity;
    }

    // Slower cows go first, then break ties by current position.
    public int compareTo(cow other) {
        if (this.second != other.second)
            return this.second-other.second;
        return this.first - other.first;
    }
}