import java.util.Scanner;

public class escape
{
    static int answer = 0;
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        int longest = 0;
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
            longest = Math.max(longest, Integer.toString(nums[i]).toCharArray().length);
        }

        char[][] cows = new char[n][longest];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < longest; j++) {
                cows[i][j] = '0';
            }
        }

        for (int i = 0; i < n; i++) {
            char[] chars = Integer.toString(nums[i]).toCharArray();

            for (int j = 0; j < chars.length; j++) {
                cows[i][longest - chars.length + j] = chars[j];
            }
        }

        char[] currentSum = new char[longest];
        for (int i = 0; i < longest; i++) {
            currentSum[i] = '0';
        }

        recursiveSearch(cows, -1, 0, currentSum);

        System.out.println(answer);
    }

    public static void recursiveSearch(char[][] cows, int previous, int depth, char[] currentSum) {
        if (depth > answer) {
            answer = depth;
        }

        outer:
        for (int i = previous + 1; i < cows.length; i++) {
            //check if we can add w/o carries
            for (int j = 0; j < cows[i].length; j++) {
                int sum = cows[i][j] + currentSum[j] - '0' - '0';
                if (sum > 9 || sum < 0) {
                    continue outer;
                }
            }

            for (int j = 0; j < cows[i].length; j++) {
                currentSum[j] += cows[i][j] - '0';
            }
            recursiveSearch(cows, i, depth + 1, currentSum);
            for (int j = 0; j < cows[i].length; j++) {
                currentSum[j] -= cows[i][j] - '0';
            }
        }
    }

}
