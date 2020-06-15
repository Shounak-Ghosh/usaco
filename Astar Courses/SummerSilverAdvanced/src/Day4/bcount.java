package Day4;

import java.util.*;
import java.io.*;

public class bcount
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(stdin.readLine());
        int N = Integer.parseInt(tok.nextToken());
        int Q = Integer.parseInt(tok.nextToken());
        int[] cows = new int[N];

        for (int i=0; i< N; i++)
            cows[i] = Integer.parseInt(stdin.readLine().trim());

        // Do cumulative frequency arrays for 1, 2 and 3, stored in freq[1], freq[2], freq[3].
        int[][] freq = new int[4][N+1];
        for (int i=1; i<= N; i++) {
            for (int j=1; j<=3; j++) freq[j][i] = freq[j][i-1];
            freq[cows[i-1]][i] = freq[cows[i-1]][i-1] + 1;
        }

        // Answer each query by using subtraction on cumulative frequency arrays.
        PrintWriter fout = new PrintWriter(new OutputStreamWriter(System.out));
        for (int i=0; i < Q; i++)
        {
            tok = new StringTokenizer(stdin.readLine());
            int low = Integer.parseInt(tok.nextToken())-1;
            int high = Integer.parseInt(tok.nextToken());
            for (int j=1; j<=3; j++) {
                fout.write(""+(freq[j][high]-freq[j][low]));
                if (j != 3) fout.write(" ");
            }
            fout.write("\n");
        }
        fout.close();
    }
}