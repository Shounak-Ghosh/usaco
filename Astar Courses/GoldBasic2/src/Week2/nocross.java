package Week2;

import java.util.*;
import java.io.*;

public class nocross
{

   public static void main(String[] args) throws Exception
   {

      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();

      // Get input.
      int[] f1 = new int[n];
      for (int i=0; i<n; i++)
         f1[i] = sc.nextInt();

      int[] map = new int[n];

      // Store these in reverse.
      for (int i=0; i<n; i++)
         map[f1[i]-1] = i+1;

      // Get second input.
      int[] f2 = new int[n];
      for (int i=0; i<n; i++)
         f2[i] = sc.nextInt();

      // minI[i] will store the minimum index from the bottom we link to the top to get i crosswalks.
      int[] minI = new int[n+1];
      Arrays.fill(minI, n+1);
      minI[0] = -1;
      int finalans = 0;

      // Go through each item.
      for (int i=0; i<n; i++) {

         // For f2[i], I want to find the list of items it can cross to.
         int low = Math.max(f2[i] - 5, 0);
         int high = Math.min(f2[i] + 3, n-1);
         int[] tmp = new int[high-low+1];

         // Basically, for where I am at, I can get to cows low through high, inclusive.
         // So I am trying each of these crosswalks.
         for (int j=low; j<=high; j++) {

            // This tells me the best answer if I were to link the cow at index i on the bottom to this
            // particular cow on the top.
            int res = binSearch(minI, map[j]) + 1;

            // Just storing all answers for doing a cross walk with cow in index i on the bottom.
            tmp[j-low] = res;
            finalans = Math.max(finalans, res);
         }

         // Now, this list has to be updated based on tmp, if we got a better answer than before for
         // any number of cross walks by adding one of these.
         for (int j=low; j<=high; j++) {
            minI[tmp[j-low]] = Math.min(minI[tmp[j-low]], map[j]);
         }

      }

      System.out.println(finalans);
   }

   // Finds largest i such that minI[i] < index.
   public static int binSearch(int[] minI, int index) {

      int low = 0, high = minI.length-1;
      while (low < high) {
         int mid = (low+high+1)/2;
         if (minI[mid] < index)
            low = mid;
         else
            high = mid-1;
      }
      return low;
   }
}