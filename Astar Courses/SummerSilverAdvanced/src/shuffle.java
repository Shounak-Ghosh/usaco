import java.io.*;
import java.util.*;
public class shuffle
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(in.readLine());
        int[] to = new int[N];
        int[] parent = new int[N];
        StringTokenizer st = new StringTokenizer(in.readLine());
        for(int i = 0; i < N; i++)
        {
            to[i] = Integer.parseInt(st.nextToken())-1;
            parent[to[i]]++;
        }
        int ans = N;
        Queue<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            if(parent[i] == 0) {
                q.add(i);
                ans--;
            }
        }
        while(!q.isEmpty()) {
            int curr = q.remove();
            if(--parent[to[curr]] == 0) {
                q.add(to[curr]);
                ans--;
            }
        }
        out.println(ans);
        out.close();
    }
}