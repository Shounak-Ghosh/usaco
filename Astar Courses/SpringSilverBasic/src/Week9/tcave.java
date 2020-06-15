package Week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class tcave
{
    static int[] head;
    static int numPassages;
    static int numSplits;
    static int treasure;

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        numPassages = sc.nextInt();
        numSplits = sc.nextInt();
        treasure = sc.nextInt();

        int node = 0;
        int left = 0;
        int right = 0;

        head = new int[numPassages + 1];

        for(int i  = 0; i < numSplits; i++)
        {
            node = sc.nextInt();
            left = sc.nextInt();
            right = sc.nextInt();
            head[left] = node;
            head[right] = node;
        }

        //System.out.println(Arrays.toString(head));

        ArrayList<Integer> path = new ArrayList<Integer>();
        int current = treasure;

        while(current >= 1)
        {
            path.add(0,current);
            current = head[current];
        }

        System.out.println(path.size());

        for(Integer e: path)
        {
            System.out.println(e);
        }

        //System.out.println(path);
    }


}
