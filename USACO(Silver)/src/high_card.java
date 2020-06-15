import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class high_card
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter outf = new PrintWriter(new File("highcard.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] elsie = new int[N];
        int[] bessie = new int[N];
        boolean[] visited = new boolean[2 * N];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            elsie[i] = Integer.parseInt(st.nextToken()) - 1;
            visited[elsie[i]] = true;
        }

        int index = 0;

        for (int i = 0; i < 2 * N; i++)
        {
            if (!visited[i])
            {
                bessie[index] = i;
                index++;
            }
        }

        Arrays.sort(elsie);
        Arrays.sort(bessie);

        index = 0;
        int ans = 0;
        for (int i = 0; i < N; i++)
        {
            while (index < N && bessie[index] < elsie[i])
            {
                index++;
            }

            if (index == N)
            {
                break;
            }
            index++;
            ans++;
        }

        outf.println(ans);
        outf.close();
        f.close();

    }
}
