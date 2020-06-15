import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class hps
{
    static int N;
    static int[] john,H,P,S;
    public static void main(String[] args) throws Exception
    {
        // Read in input.
        BufferedReader f = new BufferedReader(new FileReader("hps.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("hps.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        john = new int[N];
        H = new int[N];
        P = new int[N];
        S = new int[N];
        int h = 0,p = 0,s = 0;
        String move;
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            move = st.nextToken();
            if (move.equals("H"))
            {
                john[i] = 1;
                h++;
            }
            else if (move.equals("P"))
            {
                john[i] = 2;
                p++;
            }
            else
                {
                    john[i] = 3;
                    s++;
                }
            H[i] = h;
            P[i] = p;
            S[i] = s;
        }

        System.out.println(Arrays.toString(john));
        System.out.println(Arrays.toString(H));
        System.out.println(Arrays.toString(P));
        System.out.println(Arrays.toString(S));


        outf.println(4);
        outf.close();
        f.close();
    }
}
