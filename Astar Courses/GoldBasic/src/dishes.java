import java.util.*;

public class dishes
{
    public static int n;
    public static int[] vals;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        vals = new int[n];
        for (int i=0; i<n; i++) vals[i] = sc.nextInt();

        int low = 1, high = n;
        while (low < high)
        {
            int mid = (low+high+1)/2;
            if (possible(mid))
                low = mid;
            else
                high = mid-1;
        }

        System.out.println(low);
    }

    public static int binsearch(ArrayDeque[] stacks, int low, int high, int val)
    {
        while (low < high)
        {
            int mid = (low+high)/2;

            if (((ArrayDeque<Integer>)stacks[mid]).peek() < val)
                low = mid+1;
            else
                high = mid;
        }
        return low;
    }

    public static boolean sim(int[] list)
    {

        int k = list.length;

        // Set up our soapy stacks.
        ArrayDeque[] stacks = new ArrayDeque[k];
        for (int i=0; i<k; i++) stacks[i] = new ArrayDeque<Integer>();

        // Starting parameters.
        int cur = 0, numS = 0, stackI = 0;

        for (int i=0; i<k; i++)
        {
            if (list[i] == cur)
                cur++;
            else
                {
                if (stackI == numS)
                {
                    stacks[stackI].push(list[i]);
                    numS++;
                }
                else
                    {
                    if (((ArrayDeque<Integer>)stacks[numS-1]).peek() < list[i])
                    {
                        stacks[numS++].push(list[i]);
                    }
                    else
                        {
                         int idx = binsearch(stacks, stackI, numS-1, list[i]);
                        stacks[idx].push(list[i]);
                    }
                }
            }
            while (stackI < numS) {

                // We can keep on going till the stack runs out.
                while (stacks[stackI].size() > 0)
                {
                    // This is the only time we can clean this dish.
                    if (((ArrayDeque<Integer>)stacks[stackI]).peek().equals(cur) )
                    {
                        stacks[stackI].pop();
                        cur++;
                    }
                    // Need to get out.
                    else
                        break;
                }
                if (stacks[stackI].size() > 0)
                    break;

                stackI++;
            }
        }
        return cur == k;
    }

    public static boolean possible(int k)
    {
        int[] freq = new int[n+1];
        for (int i=0; i<k; i++)
            freq[vals[i]]++;

        int[] map = new int[n+1];
        int idx = 0;
        for (int i=1; i<=n; i++)
            if (freq[i] == 1)
                map[i] = idx++;
        int[] list = new int[k];
        for (int i=0; i<k; i++)
            list[i] = map[vals[i]];
        return sim(list);
    }


}