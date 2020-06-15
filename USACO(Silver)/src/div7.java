import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class div7
{
    static int N;
    static int[] id;
    static long[] prefix;
    static int[] prefixMod;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("div7.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("div7.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        id = new int[N];
        prefix = new long[N];
        prefixMod = new int[N];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            id[i] = Integer.parseInt(st.nextToken());
        }

        prefix[0] = (long) id[0];
        for (int i = 1; i < N; i++)
        {
            prefix[i] = prefix[i - 1] + id[i];
        }

        for (int i = 0; i < N; i++)
        {
            prefixMod[i] = (int) (prefix[i] % 7);
        }

        int front, back;
        int ans = 0;
        for (int i = 0; i <= 6; i++)
        {
            front = 0;
            back = N-1;
            while (front < N  && prefixMod[front] != i)
            {
                front++;
            }
            while (back >= 0 && prefixMod[back] != i)
            {
                back--;
            }

            if (back - front > ans)
            {
                ans = back - front;
            }
        }

        outf.println(ans);
        f.close();
        outf.close();

    }
}
