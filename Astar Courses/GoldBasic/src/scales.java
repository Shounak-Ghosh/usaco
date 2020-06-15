import java.util.*;

public class scales
{
    private static int numWeights, max, best;
    private static int[] weights;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numWeights = sc.nextInt();
        max = sc.nextInt();
        weights = new int[numWeights];
        for (int i = 0; i < numWeights; i++)
        {
            weights[i] = sc.nextInt();
        }
        solve(0, numWeights - 1);
        System.out.println(best);

    }

    // dfs
    public static void solve(int current, int index)
    {
        if (index > 0 && weights[index] + weights[index - 1] + current <= max)
        {
            solve(current + weights[index], index - 1);
        }
        else if (index > 0 && weights[index] + current <= max)
        {
            solve(current + weights[index], index - 2);
            if (index > 1)
                solve(current + weights[index - 1], index - 2);
        }
        else if (index > 0 && weights[index] + current > max)
        {
            solve(current, index - 1);
        }
        if (index == 0 && current + weights[0] <= max)
            current += weights[0];
        best = Math.max(best, current);
    }

}