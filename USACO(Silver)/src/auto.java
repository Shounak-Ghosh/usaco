import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class auto
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("auto.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        pair[] dict = new pair[W];
        String s;

        for (int i = 0; i < W; i++)
        {
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();
            dict[i] = new pair(i + 1, s);
        }
                Arrays.sort(dict);
                System.out.println(Arrays.toString(dict));


                }

static class pair implements Comparable<pair>
{
    int x;
    String s;

    public pair(int a, String b)
    {
        x = a;
        s = b;
    }

    public String toString()
    {
        return x + " " + s;
    }
    public int compareTo(pair other)
    {
        return this.s.compareTo(other.s);
    }
}
}
