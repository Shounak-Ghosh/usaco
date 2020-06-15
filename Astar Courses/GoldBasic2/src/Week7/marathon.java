package Week7;

import java.util.*;
import java.io.*;

public class marathon
{

   public static int n;
   public static int k;
   public static int[][] pts;
   public static int[][] dist;
   public static int[][] all;
   public static int[][] memo;

   public static void main(String[] args) throws Exception
   {

      // Read in data.
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();
      k = sc.nextInt();
      if (k == n-1) k = n-2;
      pts = new int[n][2];

      // We just need to read in the number of values of each parity for each letter.
      for (int i=0; i<n; i++) {
         pts[i][0] = sc.nextInt();
         pts[i][1] = sc.nextInt();
      }

      // Our precomp - dist[i][j] is direct distance from pt i to pt j.
      dist = new int[n][n];
      for (int i=0; i<n; i++)
         for (int j=i+1; j<n; j++)
            dist[i][j] = Math.abs(pts[i][0]-pts[j][0]) + Math.abs(pts[i][1]-pts[j][1]);

      // Cumulative distances all[i][j] is cost of going from i to j, skipping none.
      all = new int[n][n];
      for (int i=0; i<n-1; i++) {
         all[i][i+1] = dist[i][i+1];
         for (int j=i+2; j<n; j++)
            all[i][j] = all[i][j-1] + dist[j-1][j];
      }

      memo = new int[n][n];
      for (int i=0; i<n; i++) Arrays.fill(memo[i], -1);

      // Write result.
      System.out.println(go(0, k));
   }

   // Returns the cost of starting at point cur, having skip more pts to skip.
   public static int go(int cur, int skip) {

      // Base cases.
      if (cur == n-1) return 0;
      if (skip == 0) return all[cur][n-1];
      if (memo[cur][skip] != -1) return memo[cur][skip];

      // If we skipped nothing.
      int res = all[cur][n-1];

      // next is the next spot we'll stop at.
      for (int next=cur+1; next<n&&next<=cur+skip+1; next++)
         res = Math.min(res, dist[cur][next] + go(next, skip-(next-cur-1)));

      // Store and return.
      return memo[cur][skip] = res;
   }
}