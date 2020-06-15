import java.util.Arrays;
import java.util.Scanner;

public class soda
{
   public static void main(String[] args)
   {

      int N;
      int[] starts;
      int[] ends;
      int[] cpoints;

      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      starts = new int[N];
      ends = new int[N];
      cpoints = new int[2 * N];
      for (int i = 0; i < N; i++)
      {

         int s = sc.nextInt();
         int e = sc.nextInt();
         starts[i] = s;
         ends[i] = e;
         cpoints[2 * i] = s;
         cpoints[2 * i + 1] = e;
      }


      Arrays.sort(starts);
      Arrays.sort(ends);
      Arrays.sort(cpoints);

      int r = 0;
      int c = 0;
      int ps = 0;
      int pe = 0;

      for (int x : cpoints)
      {
         if (ps < N && x == starts[ps])
         {
            c++;
            ps++;
         }
         r = Math.max(r, c);
         if (pe < N && x == ends[pe])
         {
            c--;
            pe++;
         }
      }

      System.out.println(r);

   }

}