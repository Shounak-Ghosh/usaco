import java.util.Scanner;
import java.util.Arrays;

/**
 * Created by 22shounakg on 2/9/19.
 *
 */
public class btwr
{
    public static bale[] hayBales;
    public static int ans;
    public static boolean[] mark;
    public static int numBales;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        numBales = sc.nextInt();
        mark = new boolean[numBales];
        hayBales = new bale[numBales];
        ans = -1;

        for(int i = 0; i < numBales; i++)
        {
            hayBales[i] = new bale(sc.nextInt(), sc.nextInt());
        }
        //Arrays.sort(hayBales);

        int i = 0;
        for(bale b: hayBales)
        {
            Arrays.fill(mark,false);
            mark[i] = true;
            solve(b,1);
            i++;
        }
        System.out.println(ans);

    }

    public static void solve(bale current, int total)
    {
        ans = Math.max(ans,total);


        for (int i = 0; i < numBales; i++)
        {
            if (!mark[i] && current.isLarger(hayBales[i]))
            {
                mark[i] = true;
                solve(hayBales[i], total + 1);
                mark[i] = false;
            }
        }
    }
}
class bale implements Comparable<bale>
{
    int breadth;
    int width;

    public bale(int b, int w)
    {
        breadth = b;
        width = w;
    }

    public boolean isLarger(bale other)
    {
        return breadth > other.breadth && width > other.width;
    }

    public int compareTo(bale other)
    {
        if(breadth == other.breadth)
        {
            return width - other.width;
        }
        return breadth - other.breadth;
    }
}
