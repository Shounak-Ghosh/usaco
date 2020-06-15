import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class homework
{
    static int[] scores;
    static int[] sums;
    static int[] min;
    static double[] average;

    static int N;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("homework.in"));
        PrintWriter outf = new PrintWriter(new File("homework.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        scores = new int[N];
        sums = new int[N];
        min = new int[N];
        average = new double[N];

        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++)
        {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        //System.out.println(Arrays.toString(scores));

        sums[N-1] = scores[N-1];
        for (int i = N - 2; i >= 0; i--)
        {
            sums[i] = scores[i] + sums[i + 1];
        }
        //System.out.println(Arrays.toString(sums));

        min[N - 1] = scores[N - 1];
        for (int i = N - 2; i >= 0; i--)
        {
            if(scores[i] < min[i + 1])
            {
                min[i] = scores[i];
            }
            else
                {
                    min[i] = min[i + 1];
                }
        }
        //System.out.println(Arrays.toString(min));
        double max = 0L;
        for (int i = 1; i <= N - 2; i++)
        {
            double numerator = sums[i] - min[i];
            double denominator = N - i - 1;
            average[i] = numerator/denominator;
            if(average[i] > max)
            {
                max = average[i];
            }
        }
        //System.out.println(Arrays.toString(average));

        //System.out.println("max:" + max);
        for(int i = 1; i <= N-2; i++)
        {
            if(average[i] == max)
            {
                //System.out.println(average[i]);
                outf.println(i);
            }
        }
        outf.close();
        f.close();
    }
}
