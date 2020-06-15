import java.util.*;


public class bds
{
    private static int[][] pascal = {{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}, {1, 5, 10, 10, 5, 1}, {1, 6, 15, 20, 15, 6, 1}, {1, 7, 21, 35, 35, 21, 7, 1}, {1, 8, 28, 56, 70, 56, 28, 8, 1}, {1, 9, 36, 84, 126, 126, 84, 36, 9, 1}};
    private static int N;
    private static int total;
    private static boolean complete = false;
    private static int[] arr;


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        total = sc.nextInt();

        arr = new int[N];
        for (int i = 0; i < N; i++)
        {
            arr[i] = i+1;
        }

        List<Integer> result = new ArrayList<>();
        dfs(result);
    }

    private static void dfs(List<Integer> result)
    {
        if (complete)
            return;
        if (arr.length == result.size())
        {
            int sum = 0;

            for (int j = 0; j < N; j++)
            {
                sum += result.get(j) * pascal[N-1][j];
            }

            if (sum == total)
            {
                for (int ii : result)
                {
                    System.out.print(ii);
                    System.out.print(" ");
                }
                System.out.println();
                complete = true;
                return;
            }

        }

        for (int i = 0; i < arr.length; i++)
        {
            if (!result.contains(arr[i]))
            {
                result.add(arr[i]);
                dfs(result);
                result.remove(result.size() - 1);
            }
        }
    }



}