import java.io.*;
import java.util.*;

public class msched
{

    static int numCows;
    static mschedCow[] cows;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("msched.in"));
        PrintWriter outf = new PrintWriter(new File("msched.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numCows = Integer.parseInt(st.nextToken());

        cows = new mschedCow[numCows];
        int gallons = 0;
        int deadline = 0;
        for(int i = 0; i < numCows; i++)
        {
            st = new StringTokenizer(f.readLine());
            gallons = Integer.parseInt(st.nextToken());
            deadline = Integer.parseInt(st.nextToken());
            cows[i] = new mschedCow(gallons,deadline);
        }

        Arrays.sort(cows);
        System.out.println(Arrays.toString(cows));

        ArrayList<mschedCow> goodCows = new ArrayList<>(10000);


        deadline = cows[0].deadline;
        goodCows.add(cows[0]);
        for(int i = 1; i < numCows; i++)
        {
            if(cows[i].deadline != deadline)
            {
                goodCows.add(cows[i]);
                deadline = cows[i].deadline;
            }
        }

        System.out.println(goodCows);

        f.close();
        outf.close();
    }

}

class mschedCow implements Comparable<mschedCow>
{
    int numGallons;
    int deadline;

    public mschedCow(int gal, int dead)
    {
        numGallons = gal;
        deadline = dead;
    }

    public String toString()
    {
        return numGallons + " " + deadline;
    }

    public int compareTo(mschedCow c1)
    {
        int d = this.deadline - c1.deadline;
        if(d == 0)
        {
            return c1.numGallons - this.numGallons;
        }
        return d;
    }

    public boolean equals(Object other)
    {
        if(other instanceof mschedCow)
        {
            mschedCow temp = (mschedCow) other;
            return temp.deadline == this.deadline;
        }
        return false;
    }


}
