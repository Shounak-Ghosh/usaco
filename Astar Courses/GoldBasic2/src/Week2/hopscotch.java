package Week2;

import java.util.*;
public class hopscotch
{
   static char[][] grid;
   public static void main(String[] args)
   {
      Scanner sc = new Scanner(System.in);
      int R = sc.nextInt();
      int C = sc.nextInt();
      int colors = sc.nextInt();
      int[][] grid = new int[R][C];
      ArrayList<Integer>[] columns = new ArrayList[colors+1];
      for(int i = 1; i < columns.length; i++)
      {
         columns[i] = new ArrayList<Integer>();
      }
      for(int i = 0; i < R; i++)
      {
         for(int j = 0; j < C; j++) {
            grid[i][j] = sc.nextInt();
         }
      }
      for(int j = 0; j < C; j++)
      {
         for(int i = 0; i < R; i++)
         {
            int color = grid[i][j];
            if(!columns[color].isEmpty() && columns[color].get(columns[color].size()-1) == j) continue;
            columns[color].add(j);
         }
      }
      BIT[] bits = new BIT[colors+1];
      for(int i = 1; i < bits.length; i++)
      {
         if(columns[i].size() > 0) {
            bits[i] = new BIT(columns[i]);
         }
      }
      ArrayList<Integer> gen = new ArrayList<Integer>();
      for(int i = 0; i < C; i++)
      {
         gen.add(i);
      }
      BIT full = new BIT(gen);
      full.update(0, 1);
      bits[grid[0][0]].update(0, 1);
      for(int i = 1; i < R-1; i++) {
         for(int j = C-2; j > 0; j--) {
            int val = full.query(j-1) - bits[grid[i][j]].query(j-1);
            if(val < 0) val += MOD;
            full.update(j, val);
            bits[grid[i][j]].update(j, val);
         }
      }
      int ret = full.query(C-2) - bits[grid[R-1][C-1]].query(C-2);
      if(ret < 0) ret += MOD;
     System.out.print(ret);
   }

   static final int MOD = 1000000007;

   static class BIT {
      public int[] tree;
      public int[] indices;
      public BIT(ArrayList<Integer> set) {
         indices = new int[set.size()+2];
         tree = new int[indices.length];
         indices[0] = -1;
         int index = 1;
         for(int out: set) {
            indices[index++] = out;
         }
         indices[indices.length-1] = Integer.MAX_VALUE;
      }
      public void update(int index, int val) {
         int actual = Arrays.binarySearch(indices, index);
         while(actual < indices.length) {
            tree[actual] += val;
            if(tree[actual] >= MOD) tree[actual] -= MOD;
            actual += actual & -actual;
         }
      }
      public int query(int index) {
         int left = 0;
         int right = indices.length-1;
         while(left != right) {
            int mid = (left+right+1)/2;
            if(indices[mid] > index) {
               right = mid-1;
            }
            else {
               left = mid;
            }
         }
         int ret = 0;
         while(left > 0) {
            ret += tree[left];
            if(ret >= MOD) ret -= MOD;
            left -= left & -left;
         }
         return ret;
      }
   }

}