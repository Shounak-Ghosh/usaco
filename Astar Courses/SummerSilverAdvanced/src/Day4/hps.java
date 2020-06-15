package Day4;

import java.io.*;

public class hps
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(in.readLine());
        int[] moves = new int[N];
        for (int i=0; i < N; i++)
            moves[i] = toNum(in.readLine());

        // Get frequency array of each move.
        int[][] cumulativeFreq = new int[3][N];
        for (int i=0; i < N; i++)
            cumulativeFreq[moves[i]][i]++;


        for (int i=0; i<3; i++)
            for (int j=1; j < N; j++)
                cumulativeFreq[i][j] += cumulativeFreq[i][j-1];


        int ans = 0;

        for (int i=0; i <= N; i++)
            ans = Math.max(ans, max(cumulativeFreq, 0, i-1) + max(cumulativeFreq, i, N-1));


        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        out.println(ans);

        out.close();
        in.close();
    }

    public static int max(int[][] arr, int start, int end)
    {

        // This isn't possible.
        if (start > end)
            return 0;

        int res = 0;

        // Go through all three moves.
        for (int i=0; i<3; i++) {

            // See if we need to subtract something out for frequency of this range.
            int sub = start > 0 ? arr[i][start-1] : 0;

            // Take the ans of this move or the others.
            res = Math.max(res, arr[i][end]-sub);
        }
        return res;
    }

    public static int toNum(String s)
    {
        if (s.equals("H"))
            return 0;
        if (s.equals("P"))
            return 1;
        return 2;
    }
}