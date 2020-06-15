import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class cowdance_
{
    static int N, tMax;
    static ArrayList<Integer> cowList = new ArrayList<>();
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("cowdance.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        tMax = Integer.parseInt(st.nextToken());
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            int val = Integer.parseInt(st.nextToken());
            cowList.add(val);
        }
        //System.out.println(tMax);
        Collections.sort(cowList);
        int ans = 0;
        int currentSum = 0;
        int current = 0;
        while (!cowList.isEmpty())
        {
           if (tMax - currentSum < cowList.get(0))
           {
               ans++;
               currentSum = 0;
              System.out.println();
           }
           else
               {
                   current = cowList.remove(0);
                   currentSum += current;
                   System.out.print(current + "+");
               }

        }
        outf.println(ans);

        outf.close();
        f.close();


       // while ()

    }
}
