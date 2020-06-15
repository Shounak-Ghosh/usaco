import java.io.*;
import java.util.*;
public class shuffle
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("shuffle.in"));
        PrintWriter outf = new PrintWriter(new File("shuffle.out"));
        int N = Integer.parseInt(f.readLine());
        int[] dest = new int[N];
        int[] parent = new int[N]; // stores how many cows will be at each location after the shuffle
        StringTokenizer st = new StringTokenizer(f.readLine());
        for(int i = 0; i < N; i++)
        {
            dest[i] = Integer.parseInt(st.nextToken())-1;
            parent[dest[i]]++; // increments the number of cows at the particular destination read in
        }
        int ans = N;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++)
        {
            if(parent[i] == 0)
            {
                q.add(i);
                ans--;
            }
        }

        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(--parent[dest[curr]] == 0)
            {
                q.add(dest[curr]);
                ans--;
            }
        }
        outf.println(ans);
        outf.close();
        f.close();
    }
}