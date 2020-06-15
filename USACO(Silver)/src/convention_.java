import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention_
{
    static int N,M,C;
    static int[] times;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("convention.in"));
        PrintWriter outf = new PrintWriter(new File("convention.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        times = new int[N];

        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++)
        {
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);

        outf.println(iterativeBinarySearch());
        f.close();
        outf.close();

    }

    public static boolean check(int timeDifference)
    {
        int start = times[0];
        int busesUsed = 1;
        int startIndex = 0;

        for(int i = 0; i < N; i++)
        {
            if(times[i] - start > timeDifference || i + 1 - startIndex > C )
            {
                busesUsed++;
                start = times[i];
                startIndex = i;
            }
        }
        //System.out.println(busesUsed);
        return busesUsed <= M;
    }

    public static int iterativeBinarySearch()
    {
        int low = 0;
        int high = 1000000000;
        int middle = (low + high) / 2;

        while (low != high)
        {
            if(check(middle))
            {
                high = middle;
            }
            else
            {
                low = middle + 1;
            }
            middle = (low + high) / 2;
        }

        return low;
    }

    public static int binarySearch(int low, int high)
    {
        if(high == low)
        {
            return low;
        }

        if (low + 1 == high)
        {
            if(check(low))
            {
                return low;
            }
            return high;
        }

        int middle = (low + high) / 2;

        if(check(middle))
        {
            return binarySearch(low,middle);
        }
        else {
            return binarySearch(middle + 1,high);
        }
    }
}
