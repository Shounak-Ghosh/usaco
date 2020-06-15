package Week7;

import java.util.Scanner;

public class diet
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      int H = sc.nextInt();
      int N = sc.nextInt();
      int[] p = new int[502];
      int[][] m = new int[502][45002];

      for (int k = 0; k <= H; k++) {
         m[N][k] = k;
      }
      for (int i = 0; i <= N; i++) {
         m[i][H] = H;
      }
      for (int i = 0; i < N; i++) {
         p[i] = sc.nextInt();
      }
      for (int i = N - 1; i >= 0; i--) {
         for (int k = 0; k < H; k++) {
            if (k + p[i] <= H)
               m[i][k] = Math.max(m[i + 1][k + p[i]], m[i + 1][k]);
            else
               m[i][k] = m[i + 1][k];
         }
      }
      System.out.println(m[0][0]);
   }

}
