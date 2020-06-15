package Day2;

import java.util.*;

public class baseball
{


    public static void main(String[] args)
    {

        // Sort cow positions.
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] positions = new int[N];

        for (int i=0; i < N; i++)
        {
            positions[i] = sc.nextInt();
        }
        Arrays.sort(positions);


        int result = 0;
        for (int i=0; i < N; i++)
        {
            for (int j = i + 1; j < N; j++)
            {
                result += search(positions, i, j);
            }
        }

        System.out.println(result);
    }

    public static int search(int[] positions, int x, int y)
    {
        int min = 2* positions[y] - positions[x];
        int max = 3* positions[y] - 2*positions[x];
        return binSearch(positions, max) - binSearch(positions, min-1);
    }

    // Returns the number of items in the array <= item.
    public static int binSearch(int[] positions, int item)
    {

        int low = 0, high = positions.length-1;

        // Finding the highest index less than or equal to item.
        while (low < high-1)
        {
            int mid = (low+high)/2;
            if (positions[mid] <= item)
                low = mid;
            else
                high = mid;
        }

        // Walk through the last steps.
        while (high >= 0 && positions[high] > item)
        {
            high--;
        }
        return high+1;
    }
}