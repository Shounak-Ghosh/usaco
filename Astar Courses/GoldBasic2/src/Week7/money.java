package Week7;

import java.io.*;
import java.util.*;

public class money
{
   static int V;
   static int[] money;
   static long[] dp;

   public static void main (String [] args) throws IOException
   {
      Scanner sc = new Scanner(System.in);
      V = sc.nextInt();
      int N = sc.nextInt();
      money = new int[V+1];
      dp = new long[N+1];
      int counter = 1;
      int length;
      money[0] = 0;


      for (int i = 0; i < V; i++)
      {
         money[i] = sc.nextInt();
      }



      boolean go = true;
      int storage;
      while(go){
         go = false;
         for(int x = 1;x<money.length;x++){
            if(money[x]==money[x-1]) money[x]=Integer.MAX_VALUE;
            if(money[x]<money[x-1]){
               go = true;
               storage = money[x];
               money[x]=money[x-1];
               money[x-1]=storage;
            }
         }
      }
      int start = V;

      for(int x = money.length-1;x>-1;x--){
         if(money[x]!=Integer.MAX_VALUE){
            start = x;
            break;
         }
         //System.out.println(Week7.money[x]);
      }


      dp[0]=1;

      for(int x = 1; x<=start;x++){
         for(int a = money[x];a<dp.length;a++){
            dp[a] += dp[a-money[x]];
         }
      }

      System.out.println(dp[N]);
   }
}