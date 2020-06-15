import java.util.Arrays;
import java.util.Scanner;

public class shelf22
{
    public static void main(String[] args)
    {
        solve();
    }

    public static void solve()
    {
        Scanner sc = new Scanner(System.in);
        int numCows = sc.nextInt();
        int height = sc.nextInt();
        int[] cows = new int[numCows];

        for(int i = 0; i < numCows; i++)
        {
            cows[i] = sc.nextInt();
        }

        int minExcess = Integer.MAX_VALUE;

        System.out.println(Arrays.toString(cows));

        int numSubsets = (1 << numCows)  - 1;
        System.out.println(numSubsets);

        int currentHeight = 0;

        for(int x = 0; x <= numSubsets; x++)
        {
            for(int y = 0; y < numCows; y++)
            {
                if((x & (1 << y)) > 0)
                {
                    currentHeight += cows[y];
                }
                System.out.println(currentHeight);
            }

            if(currentHeight > height)
            {
                minExcess = Math.min(minExcess, currentHeight - height);
            }
            else if (currentHeight == height)
            {
                System.out.println(0);
                return;
            }
            currentHeight = 0;
        }
        System.out.println(minExcess);
    }
}
