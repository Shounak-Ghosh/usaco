
import java.util.*;
import java.io.*;

public class highcard
{
    public static void main(String[] args) throws Exception
    {
        // Read in Elsie and sort.
        BufferedReader f = new BufferedReader(new FileReader("highcard.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] elsie = new int[N];
        boolean[] used = new boolean[2*N];
        for (int i = 0; i<N; i++)
        {
            st = new StringTokenizer(f.readLine());
            elsie[i] = Integer.parseInt(st.nextToken())-1;
            used[elsie[i]] = true;
        }
        Arrays.sort(elsie);


        // create sorted bessie array
        int[] bessie = new int[N];
        int j=0;
        for (int i = 0; i < 2*N; i++)
        {
            if (!used[i])
                bessie[j++] = i;
        }
        Arrays.sort(bessie);

        // stores result and index into bessie
        int res = 0;
        j = 0;

        // go through elsie's cards (sorted) in order from low to high
        for (int i = 0; i < N; i++)
        {
            // find the smallest possible card to beat elsie's next card
            while (j < N && bessie[j] < elsie[i])
                j++;

            // could not be found
            if (j == N) break;

            // Count it and move up bessie's card.
            res++;
            //j++;
        }

        PrintWriter outf = new PrintWriter(new File("highcard.out"));
        outf.println(res);
        outf.close();
    }
}