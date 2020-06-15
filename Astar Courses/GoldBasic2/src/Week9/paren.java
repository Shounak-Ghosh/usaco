package Week9;

import java.util.*;


public class paren
{

   public static final long mod = 12345678910l;

   public static void main (String [] args)
   {
      Scanner sc = new Scanner(System.in);

      int N = sc.nextInt();

      long [] st = new long [N / 2 + 1]; // stack of our current totals
      int idx = 0;
      for (int i = 0; i < N; i++) {
         int c = sc.nextInt();
         switch (c) {
            case 0 : // '('
               idx++; // go down one level
               break;
            case 1 : // ')'
               if (st [idx] == 0) // we encountered a '()'
                  st [idx - 1]++;
               else
                  st [idx - 1] += st [idx] * 2;
               st [idx - 1] %= mod;
               st [idx--] = 0;
               break;
         }
      }
     System.out.println (st [0]);
   }
}