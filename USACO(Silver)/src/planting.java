import java.io.*;
import java.util.StringTokenizer;

public class planting
{
    private static int N;
    private static int[] degree;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("planting.in"));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        degree = new int[N];

        int a,b;
        for (int i = 0; i < N - 1; i++)
        {
            st = new StringTokenizer(f.readLine());
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;
            degree[a]++;
            degree[b]++;
        }

        int ans = 0;
        for (int i = 0; i < N; i++)
        {
            ans = Math.max(degree[i],ans);
        }
        outf.println(ans + 1);
        outf.close();
        f.close();
    }
}
