import java.io.*;
import java.util.*;
public class lifeguards
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        TreeSet<Integer> set = new TreeSet<Integer>();
        int N = Integer.parseInt(in.readLine());
        State[] states = new State[2*N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            states[2*i] = new State(start, i);
            states[2*i+1] = new State(end, i);
        }
        Arrays.sort(states);
        int actualCover = 0;
        int[] alone = new int[N];
        int last = 0;
        for(State out: states) {
            if(set.size() == 1)
            {
                alone[set.first()] += out.time - last;
            }
            if(!set.isEmpty())
            {
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
        int ret = 0;
        for(int k: alone)
        {
            ret = Math.max(ret, actualCover - k);
        }
        outf.println(ret);
        outf.close();
    }

    static class State implements Comparable<State>
    {
        public int time, index;
        public State(int a, int b)
        {
            time=a;
            index=b;
        }
        public int compareTo(State other)
        {
            return time - other.time;
        }
    }

}