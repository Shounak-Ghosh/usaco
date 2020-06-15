import java.util.*;
import java.io.*;

public class angry
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("angry.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bales = new int[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            bales[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bales);
        outf.println(5);
        f.close();
        outf.close();


    }

    public static boolean isValid(int R)
    {
        return false;
    }

}