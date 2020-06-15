import java.util.Scanner;

public class lazy
{
    static int N, K, ans;
    static int[] field;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        int a, b;
        field = new int[1001000];

        for (int i = 0; i < N; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            field[b] = a;
        }

        for (int i  = 0; i < field.length; i++)
        {
            if (i <= 2 * K)
            {
                ans += field[i];
            }
        }

        int current = ans;

        for (int i = 2 * K + 1; i < field.length; i++)
        {
            current += field[i];
            current -= field[i - (2 * K  + 1)];
            ans = Math.max(ans,current);
        }

        System.out.println(ans);
    }
}
