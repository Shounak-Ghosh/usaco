package Week9;

import java.util.*;


public class cline
{
   private static long[] fact;
   private static int N;

   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);

      N = sc.nextInt();
      int K = sc.nextInt();

      fact = new long[N];
      fact[0] = 1;
      for (int i = 1; i < N; i++)
         fact[i] = (long) i * fact[i - 1];

      while (K-- > 0)
      {
         char command = sc.next().charAt(0);
         switch (command)
         {
            case 'P':
            {
               long k = sc.nextLong();
               int[] arr = find(k - 1);
               System.out.print(arr[0]);
               for (int i = 1; i < N; i++)
                  System.out.print(" " + arr[i]);
               System.out.println();
               break;
            }
            case 'Q':
            {
               int[] arr = new int[N];
               for (int i = 0; i < N; i++)
                  arr[i] = sc.nextInt();
               System.out.println(findNum(arr) + 1);
               break;
            }
         }
      }


   }

   private static int[] find(long k)
   {
      boolean[] vis = new boolean[N];
      int[] arr = new int[N];
      for (int i = 0; i < N; i++)
      {
         long q = k / fact[N - 1 - i], p = k % fact[N - 1 - i];
         int c = 0, j = 0;
         for (; c <= q && j < N; j++)
            if (!vis[j]) c++;
         arr[i] = j;
         vis[j - 1] = true;
         k = p;
      }
      return arr;
   }

   private static long findNum(int[] arr)
   {
      long ans = 0;
      boolean[] vis = new boolean[N];
      for (int i = 0; i < arr.length; i++)
      {
         int c = 0;
         for (int j = 0; j < arr[i] - 1; j++)
            if (!vis[j]) c++;
         vis[arr[i] - 1] = true;
         ans += fact[N - 1 - i] * c;
      }
      return ans;
   }
}