package Week6;

import java.util.Scanner;

public class egroup
{
   static int[] A;
   static int[][] dp;
   static int N;

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      N = sc.nextInt();
      A = new int[30000];
      dp = new int[30000][3];
      int v;

      for(int i = 0; i < N; i++)
      {
         A[i] = sc.nextInt();
      }
      v = fans();

      for(int i = 0; i < N; i++)
      {
         A[i]=4-A[i];
      }
      v = Math.min(v,fans());
      System.out.println(v);
   }

   private static int fans()
   {
      dp[0][0]=dp[0][1]=dp[0][2]=1;
      dp[0][A[0]-1]=0;
      int val = 0;
      for(int i=1;i<N;i++)
      {
         val = 0;
         if(A[i] == 1)
         {
            val = 1;
         }
         dp[i][0] = dp[i-1][0]+1-val;
         val = 0;
         if(A[i] == 2)
         {
            val = 1;
         }
         dp[i][1] = Math.min(dp[i-1][0],dp[i-1][1])+1-val;
         val = 0;
         if(A[i] == 3)
         {
            val = 1;
         }
         dp[i][2] = Math.min(Math.min(dp[i-1][0],dp[i-1][1]),dp[i-1][2])+1-val;
      }
      return Math.min(Math.min(dp[N-1][0],dp[N-1][1]),dp[N-1][2]);
   }
}

