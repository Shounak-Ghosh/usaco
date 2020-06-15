import java.util.*;
import java.io.*;

public class haybales
{
    public static void main(String[] args) throws Exception
    {
        // Read in first line.
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("haybales.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int numQ = Integer.parseInt(st.nextToken());

        // Read in values adding dummy -1 for list beginning.
        int[] vals = new int[N+1];
        vals[0] = -1;
        st = new StringTokenizer(f.readLine());
        for (int i=1; i<=N; i++)
        {
            vals[i] = Integer.parseInt(st.nextToken());
        }

        // We want this list sorted.
        Arrays.sort(vals);

        // Compress values mapping values to indexes.
        TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
        for (int i=0; i<=N; i++)
            map.put(vals[i], i);

        // Process each query.
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < numQ; i++)
        {
            // Get query find lower bounds in map and just subtract corresponding indexes.
            st = new StringTokenizer(f.readLine());
            int low = map.floorKey(Integer.parseInt(st.nextToken())-1);
            int high = map.floorKey(Integer.parseInt(st.nextToken()));
            int res = map.get(high) - map.get(low);
            outf.println(res);

            // For speed.
//            sb.append(res+"\N");
        }

        // Output whole result.

        //outf.print(sb);
        outf.close();
        f.close();
    }
}