import java.util.Scanner;

public class stringe
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numStrings = sc.nextInt();

        int concat = 0;
        int numIter = 0;
        String str = "";
        //String temp = "";
        for(int i = 0; i < numStrings; i++)
        {
            concat = sc.nextInt();
            numIter = sc.nextInt();
            str = sc.next();
            for(int j = 0; j < numIter; j++)
            {
                str = function(concat,str);
            }
            System.out.println(str);
        }
    }

    public static String function(int n, String s)
    {
        return s.substring(n) + s;
    }
}
