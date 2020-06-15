package Diagnostic;

import java.util.Arrays;
import java.util.Scanner;

public class minnum
{
    static int n;
    static int l;
    static String s;
    static String[] nums;
    static String best = "";

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        l = sc.nextInt();
        n = sc.nextInt();
        s = sc.next();

        nums = new String[1000];
        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.next();
        }

//        System.out.println(l);
//        System.out.println(n);
//        System.out.println(s);
//        System.out.println(Arrays.toString(nums));


        solve("");

        if(best.equals(""))
        {
            System.out.println("NO SOLUTION");
        }
        else
        {
          System.out.println(best);
        }
    }

    public static boolean isCompatible(int x, int k)
    {
        if(x + nums[k].length() > l)
        {
            return false;
        }

        for(int i = 0; i < nums[k].length(); i++)
        {
            if(!(nums[k].substring(i, i+ 1)).equals(s.substring(x + i, x + i + 1)) && !(s.substring(x + i, x + i + 1)).equals("?"))
            {
                return false;
            }

        }
        return true;
    }

    public static void solve(String num)
    {
        if(num.length() == l)
        {
            if(best.equals("") || best.compareTo(num) > 0)
            {
                best = num;
            }
            return;
        }

        for(int i = 0; i < n; i++)
        {
            if(isCompatible(num.length(),i))
            {
                solve(num + nums[i]);
            }
        }
    }



}
