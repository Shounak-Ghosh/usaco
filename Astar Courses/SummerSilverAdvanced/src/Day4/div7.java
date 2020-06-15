package Day4;
// packages don't work for usaco
import java.util.*;
import java.io.*;

public class div7
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader in = new BufferedReader(new FileReader("div7.in"));
        PrintWriter out = new PrintWriter(new FileWriter("div7.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] array = new int[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(in.readLine());
            array[i] = Integer.parseInt(st.nextToken());
        }

        // create min and max arrays, filled with opposite values
        int[] min = new int[7];
        Arrays.fill(min,N);
        int[] max = new int[7];
        Arrays.fill(max, -1);


        min[0] = 0;
        max[0] = 0;


        int[] mods = new int[N + 1];
        for (int i=1; i <= N; i++)
        {
            mods[i] = (mods[i-1] + array[i-1])%7;// the modulo of the sum of the consecutive numbers
            min[mods[i]] = Math.min(min[mods[i]], i);// min of current value or i
            max[mods[i]] = Math.max(max[mods[i]], i);// max of current value or i

//            System.out.println(i);
//            System.out.println("mod " + Arrays.toString(mods));
//            System.out.println("max " + Arrays.toString(max));
//            System.out.println("min " + Arrays.toString(min));

        }


        int ans = 0;
        for (int i=0; i<7; i++)
        {
            ans = Math.max(ans, max[i] - min[i]);
        }


        out.println(ans);
        out.close();
        in.close();
    }
}