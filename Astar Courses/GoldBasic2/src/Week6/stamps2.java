package Week6;

import java.util.Arrays;
import java.util.Scanner;

public class stamps2
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);


      int K = sc.nextInt();
      int N = sc.nextInt();

      int[] coins = new int[N];

      for(int i = 0; i < N; i++)
      {
         coins[i] = sc.nextInt();
      }

      Arrays.sort(coins);

      int[] minimums = new int[K*coins[N-1]+1];
      Arrays.fill(minimums, Integer.MAX_VALUE);
      minimums[0]=0;
      boolean finished = false;
      while(!finished)
      {
         finished=true;

         for (int i = 0; i < N; i++)
         {
            for (int j = 0; j+coins[i] < minimums.length; j++)
            {
               int newer = minimums[j]+1;
               int old = minimums[j+coins[i]];
               if (newer < old)
               {
                  finished=false;
                  minimums[j+coins[i]]=newer;
               }
            }
         }
      }
      int i = 0;
      for (; i < minimums.length; i++)
      {
         if (minimums[i]>K)
         {
            break;
         }
      }

      System.out.println(i-1);


   }
}