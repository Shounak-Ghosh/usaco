package Day3;

import java.util.*;

public class cownomics
{

    public static int[] key;

    public static void main(String[] args) throws Exception
    {
        key = new int[26];
        key[0] = 0;
        key['C'-'A'] = 1;
        key['G'-'A'] = 2;
        key['T'-'A'] = 3;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] spotted = new String[N];

        for (int i=0; i < N; i++)
            spotted[i] = sc.next();

        String[] notSpotted = new String[N];

        for (int i=0; i < N; i++)
            notSpotted[i] = sc.next();


        int ans = 0;

        for (int i=0; i < M; i++)
        {
            for (int j = i + 1; j < M; j++)
            {
                for (int k = j + 1; k < M; k++)
                {
                    if (isValid(spotted, notSpotted, i, j, k))
                    {
                        ans++;
                    }
                }
            }
        }

        System.out.println(ans);

    }

    public static boolean isValid(String[] arr1, String[] arr2, int c1, int c2, int c3)
    {


        boolean[] arr = new boolean[64];
        for (int i=0; i< arr1.length; i++)
            arr[16 * key[arr1[i].charAt(c1)-'A']+ 4 * key[arr1[i].charAt(c2)-'A']+ key[arr1[i].charAt(c3)-'A']] = true;


        for (int i=0; i< arr2.length; i++)
            if (arr[16 * key[arr2[i].charAt(c1)-'A']+4*key[arr2[i].charAt(c2)-'A']+key[arr2[i].charAt(c3)-'A']])
                return false;

        return true;
    }
}