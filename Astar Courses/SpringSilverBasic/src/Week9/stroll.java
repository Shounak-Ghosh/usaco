package Week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class stroll
{
    static ArrayList<Integer> pastures = new ArrayList<Integer>();
    static int[] head;
    static int numPastures;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numPastures = sc.nextInt();
        head = new int[numPastures];
        int node = 0;
        int left = 0;
        int right = 0;

        for(int i  = 0; i < numPastures - 1; i++)
        {
            node = sc.nextInt();
            left = sc.nextInt();
            right = sc.nextInt();

            head[left] = node;
            head[right] = node;

            if(left == 0)
            {
                pastures.add(node);
                head[0] = 0;
            }
            else if(right == 0)
            {
                pastures.add(node);
                head[0] = 0;
            }

        }

        int maxLen = 0;
        for(Integer e: pastures)
        {
            maxLen = Math.max(maxLen,findLen(e));
        }
        System.out.println(maxLen);
    }

    public static int findLen(int start)
    {
        int len = 0;
        while(start >= 1)
        {
            len++;
            start = head[start];
        }
        return len;
    }
}
