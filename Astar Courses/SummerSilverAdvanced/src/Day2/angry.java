package Day2;

import java.util.*;

public class angry
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Sort it.
        Arrays.sort(arr);

        // Do binary search.
        int low = 1, high = arr[n-1]-arr[0];
        while (low < high-1)
        {
            int mid = (low+high)/2;
            if (!valid(arr, k, mid))
                low = mid+1;
            else
                high = mid;
        }

        if (!valid(arr, k, low))
            low++;
        System.out.println(low);
    }

    public static boolean valid(int[] arr, int numCows, int range)
    {

        int currBale = 0;


        for (int i=0; i<numCows; i++)
        {
            int start = arr[currBale];
            while (currBale < arr.length && arr[currBale]-start <= 2*range)
                currBale++;

            if (currBale == arr.length)
                return true;
        }
        return false;
    }
}