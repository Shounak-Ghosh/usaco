package Day4;

import java.util.*;
class haybales
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] list = new int[n];

        for(int i = 0; i < n; i++) {
            list[i] = sc.nextInt();
        }
        Arrays.sort(list);
        for(int i = 0; i < q; i++)
        {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(numLessOrEqual(list, b) - numLessOrEqual(list, a-1));
        }
    }

    public static int numLessOrEqual(int[] list, int limit)
    {
        if(list[0] > limit)
        {
            return 0;
        }
        int min = 0;
        int max = list.length-1;

        while(min != max)
        {
            int mid = (min+max+1)/2;

            if(list[mid] <= limit)
            {
                min = mid;
            }
            else {
                max = mid-1;
            }
        }
        return min + 1;
    }
}
