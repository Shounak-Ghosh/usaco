package Week5;

import java.util.Scanner;

public class landscaping
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      int N = sc.nextInt();
      int X = sc.nextInt();
      int Y = sc.nextInt();
      int Z = sc.nextInt();

      int[] A = new int[1001];
      int[] B = new int[1001];
      int[][] C = new int[1001][1001];

      int nA = 0, nB = 0, j;
      for (int i = 0; i < N; i++)
      {
         j = sc.nextInt();
         while (j > 0)
         {
            A[++nA] = i;
            j--;
         }
         j = sc.nextInt();
         while (j > 0)
         {
            B[++nB] = i;
            j--;
         }
      }

      int i;
      for (j=0; j<=nB; j++) C[0][j] = j*X;
      for (i=0; i<=nA; i++) C[i][0] = i*Y;

      for (i=1; i<=nA; i++)
      {
         for (j=1; j<=nB; j++)
         {
            C[i][j] = Integer.MAX_VALUE;
            C[i][j] = Math.min(C[i][j], C[i][j-1] + X);
            C[i][j] = Math.min(C[i][j], C[i-1][j] + Y);
            C[i][j] = Math.min(C[i][j], C[i-1][j-1] + Z * Math.abs(A[i]-B[j]));
         }
      }

      System.out.println(C[nA][nB]);
   }
}
