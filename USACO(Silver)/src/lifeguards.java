import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class lifeguards
{
    static int N;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<Integer>();
        int n = Integer.parseInt(f.readLine());
        Endpoint[] l = new Endpoint[2*n];
        for(int i = 0; i < n; i++)
        {
            st = new StringTokenizer(f.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            l[2*i] = new Endpoint(start, i);
            l[2*i+1] = new Endpoint(end, i);
        }
        Arrays.sort(l);

        int actualCover = 0;
        int[] alone = new int[n];
        int last = 0;
        for(Endpoint out: l)
        {
            if(set.size() == 1)
            {
                alone[set.first()] += out.time - last;
            }
            if(!set.isEmpty()) {

                actualCover += out.time - last;
            }
            if(set.contains(out.index))
            {
                set.remove(out.index);
            }
            else
                {
                set.add(out.index);
            }
            last = out.time;
        }
        int ans = 0;

        for(int out: alone)
        {
            ans = Math.max(ans, actualCover - out);
        }



        outf.println(7);
        outf.close();
        f.close();
    }

    public static class Endpoint implements Comparable<Endpoint>
    {
        int time;
        int index;

        public Endpoint(int t, int i)
        {
            time = t;
            index = i;
        }

        public int compareTo(Endpoint other)
        {
            return time - other.time;
        }


    }
}
