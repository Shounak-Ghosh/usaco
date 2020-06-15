package Day1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class folding
{
    static int l;
    static int n;
    static int[] knots;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        l = sc.nextInt();
        knots = new int[n];

        for(int i = 0; i < n; i++)
        {
            knots[i] = sc.nextInt();
        }

        Arrays.sort(knots);

        int count = 0;

        for (int i=0; i< n-1; i++)
        {
            knots[i] = knots[i+1] - knots[i];
        }


        for (int i=0; i<n-1; i++)
        {
            if (check(0,i))
                count++;
        }

        for (int i=1; i<n-1; i++)
        {
            if (check(i,n-2))
                count++;
        }

        System.out.println(count);

    }

    public  static boolean check(int start, int end)
    {
        int i;
        for (i=0; start+i<=end-i; i++)
            if (knots[start+i] != knots[end-i]) return false;
        return true;
    }
}
