import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class balancing
{
    static int numCows;
    static int maxValue;
    static  BalanceCoordinate[] cowCoordinates;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter outf = new PrintWriter(new File("balancing.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numCows =  Integer.parseInt(st.nextToken());
        maxValue =  Integer.parseInt(st.nextToken());
        cowCoordinates = new BalanceCoordinate[numCows];

        for(int i = 0; i < numCows; i++)
        {
            st = new StringTokenizer(f.readLine());
            cowCoordinates[i] = new BalanceCoordinate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int min = Integer.MAX_VALUE;

        for (int a = 0; a < maxValue; a += 2)
        {
            for (int b = 0; b < maxValue; b += 2)
            {
                min = Math.min(min,findMax(a,b));
            }
        }
        outf.println(min);
        f.close();
        outf.close();


    }

    public static int findMax(int a, int b)
    {
        int quad1 = 0;
        int quad2 = 0;
        int quad3 = 0;
        int quad4 = 0;

        for(BalanceCoordinate c: cowCoordinates)
        {
            if(c.x > a && c.y > b)
            {
                quad1++;
            }
            else if (c.x < a && c.y > b)
            {
                quad2++;
            }
            else if (c.x < a && c.y < b)
            {
                quad3++;
            }
            else if (c.x > a && c.y < b)
            {
                quad4++;
            }
        }
        return Math.max(Math.max(quad1,quad2),Math.max(quad3,quad4));
    }
}

class BalanceCoordinate
{
    int x;
    int y;
    public BalanceCoordinate (int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public  String toString()
    {
        return "\n" + x + " " + y;
    }
}
