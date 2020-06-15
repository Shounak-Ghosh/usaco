import java.util.*;

public class scramble
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] best = new String[N];
        String[] worst = new String[N];
        String[] input = new String[N];
        for(int i=0; i < N; i++)
        {
            input[i] = in.next();
            char[] str = input[i].toCharArray();
            Arrays.sort(str);
            best[i] = new String(str);
            worst[i] = new StringBuilder(new String(str)).reverse().toString();
        }
        Arrays.sort(best);
        Arrays.sort(worst);

        String currB, currW;
        for(int i=0; i<N; i++)
        {
            char[] S = input[i].toCharArray();
            Arrays.sort(S);
            currB = new String(S);
            currW = new StringBuilder(currB).reverse().toString();

            int lo = Arrays.binarySearch(worst, currB);
            if(lo < 0) lo = -(lo+1);
            lo++;

            int hi = Arrays.binarySearch(best, currW);
            if(hi < 0) hi = -(hi+1);
            else hi++;

            System.out.println();
            System.out.println(lo+" "+hi);
        }
    }
}