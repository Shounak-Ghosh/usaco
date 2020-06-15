

import java.util.*;
import java.io.*;

public class convention2
{

    public static int n;
    public static cow[] list;

    public static void main(String[] args) throws Exception
    {

        // Get basic info.
        BufferedReader stdin = new BufferedReader(new FileReader("convention2.in"));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        n = Integer.parseInt(tok.nextToken());
        list = new cow[n];

        // Read in each cow and sort by time.
        for (int i=0; i<n; i++) {
            tok = new StringTokenizer(stdin.readLine());
            int s = Integer.parseInt(tok.nextToken());
            int t = Integer.parseInt(tok.nextToken());
            list[i] = new cow(s,t,i);
        }
        Arrays.sort(list);

        // Here is my list of cows who are waiting, by priority.
        PriorityQueue<cow> pq = new PriorityQueue<cow>(10, new Comparator<cow>()
        {
            public int compare(cow a, cow b)
            {
                return a.priority-b.priority;
            }
        });

        int curT = 0, res = 0;
        int curCow = 0;

        // Just run the simulation.
        while (curCow < n || pq.size() > 0)
        {

            if (curCow < n && list[curCow].start <= curT)
            {
                pq.offer(list[curCow++]);
            }

            // No one is waiting.
            else if (pq.size() == 0) {
                cow cur = list[curCow++];
                curT = cur.start + cur.time;
            }

            // Cow is waiting in the queue.
            else {
                cow cur = pq.poll();
                res = Math.max(res, curT-cur.start);
                curT += cur.time;
            }
        }

        // Solve and print out the result.
        PrintWriter out = new PrintWriter(new FileWriter("convention2.out"));
        out.println(res);
        out.close();
        stdin.close();
    }
}

class cow implements Comparable<cow> {

    public int start;
    public int time;
    public int priority;

    public cow(int s, int t, int p) {
        start = s;
        time = t;
        priority = p;
    }

    public int compareTo(cow other) {
        return this.start - other.start;
    }


}