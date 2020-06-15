

import java.util.*;
import java.io.*;

public class bcount
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("bcount.in"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] cows = new int[N];
        for (int i=0; i<N; i++)
        {
            cows[i] = Integer.parseInt(f.readLine().trim());
        }

        // Do cumulative frequency arrays for 1, 2 and 3, stored in freq[1], freq[2], freq[3].
        int[][] freq = new int[4][N+1];
        for (int i=1; i<=N; i++)
        {
            for (int j=1; j<=3; j++)
                freq[j][i] = freq[j][i-1];
            freq[cows[i-1]][i] = freq[cows[i-1]][i-1] + 1;
        }

        // answer each query by using subtraction on cumulative frequency arrays
        PrintWriter outf = new PrintWriter(new File("bcount.out"));
        for (int i = 0; i < Q; i++)
        {
            st = new StringTokenizer(f.readLine());
            int low = Integer.parseInt(st.nextToken())-1;
            int high = Integer.parseInt(st.nextToken());
            for (int j=1; j<=3; j++)
            {
                outf.print(""+(freq[j][high]-freq[j][low]));
                if (j != 3)
                    outf.print(" ");
            }
            outf.println();
        }
        outf.close();
        f.close();
    }
}