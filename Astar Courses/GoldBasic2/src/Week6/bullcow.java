package Week6;

import java.util.Scanner;

public class bullcow
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      int N,K;
      N = sc.nextInt();
      K = sc.nextInt();
      int[] dp = new int[100005];

      for(int n = 0; n <= N; n++)
      {
         if(n <= K)
         {
            dp[n] = n + 1;
         }
         else
            {
               dp[n] = (dp[n-1] + dp[n - K -1]) % 5000011;
            }
      }

      System.out.println(dp[N]);
   }
}
