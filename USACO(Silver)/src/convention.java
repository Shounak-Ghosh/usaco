import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class convention
{
    static int numCows;
    static int numBuses;
    static int busSize;
    static int[] cowTimes;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("convention.in"));
        PrintWriter outf = new PrintWriter(new File("convention.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());

        numCows = Integer.parseInt(st.nextToken());
        numBuses = Integer.parseInt(st.nextToken());
        busSize = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(f.readLine());
        cowTimes = new int[numCows];

        for(int i = 0; i < numCows; i++)
        {
            cowTimes[i] = Integer.parseInt(st.nextToken());
        }

        //System.out.println(Arrays.toString(cowTimes));
        Arrays.sort(cowTimes);

        outf.println(binarySearch(0,1000000000));


        f.close();
        outf.close();
    }

    public static boolean pos(int wait)
    {
        int buses = 1;
        int firstArrival = cowTimes[0];
        int firstIndex = 0;

        for(int i = 0; i < numCows; i++)
        {
            if(cowTimes[i] - firstArrival > wait || i + 1 - firstIndex > busSize)
            {
                buses++;
                firstArrival = cowTimes[i];
                firstIndex = i;
            }
        }
        return buses <= numBuses;
    }

    public static int binarySearch(int low, int high)
    {


        if( low == high)
        {
            return low;
        }

        if(low + 1 == high)
        {
            if(pos(low))
            {
                return low;
            }
            return  high;
        }

        int middle = (low + high) /2;

        if(pos(middle))
        {
            return binarySearch(low,middle);
        }
        else {
            return binarySearch(middle + 1, high);
        }
    }



}
