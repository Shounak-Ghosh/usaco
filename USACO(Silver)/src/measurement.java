import java.io.*;
import java.util.*;

public class measurement
{
    static int numCows;
    static int initValue;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("measurement.in"));
        PrintWriter outf = new PrintWriter(new File("measurement.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numCows = Integer.parseInt(st.nextToken());
        initValue = Integer.parseInt(st.nextToken());

        ArrayList<Integer> milkValues = new ArrayList<>(100000);
        //Collections.fill(milkValues,initValue);
        LogEntry[] entries = new LogEntry[numCows];

        int day = 0;
        int cowID = 0;
        int delta = 0;
        for(int i = 0;i < numCows; i++)
        {
            st = new StringTokenizer(f.readLine());
            day = Integer.parseInt(st.nextToken());
            cowID = Integer.parseInt(st.nextToken());
            delta = Integer.parseInt(st.nextToken());
            entries[i] = new LogEntry(day,cowID,delta);
            milkValues.add(initValue);

        }
        Arrays.sort(entries);


        int prevMax = 0;
        int currentMax = 0;
        int prevNumMax = 0;
        int currNumMax = 0;
        int display = 0;
        int temp = 0;

        //System.out.println(Arrays.toString(entries));
        //System.out.println(milkValues);
        for(int i = 0; i < numCows; i++)
        {
            temp = entries[i].delta + milkValues.get(entries[i].cowID);
            milkValues.set(entries[i].cowID, temp);

            currentMax = Collections.max(milkValues);
            currNumMax = Collections.frequency(milkValues,currentMax);

            // case 1: currentMax is greater than prevMax
            // numMax = 1, display++, prevMax = currentMax
            if(currentMax > prevMax)
            {
                prevNumMax = 1;
                //currNumMax = 1;
                display++;
                prevMax = currentMax;
            }


            // case 2: currentMax is equal to prevMax
            //      A: currNumMax == prevNumMax, no change needed
            //      B: currNumMax != prevNumMax, display++, prevNumMax = currNumMax
            if(currentMax == prevMax)
            {
                if(currNumMax != prevNumMax)
                {
                    display++;
                    prevNumMax = currNumMax;
                }
            }

            // case 3: currentMax < prevMax
            // display++,
            if(currentMax < prevMax)
            {
                prevNumMax = currNumMax;
                display++;
                prevMax = currentMax;
            }

            //System.out.println(milkValues + " display " + display);
        }

        outf.println(display);
        f.close();
        outf.close();
    }
}
class LogEntry implements Comparable<LogEntry>
{
    int day;
    int cowID;
    int delta;

    public LogEntry(int day, int cowID, int delta)
    {
        this.day = day;
        this.cowID = cowID - 1; // for 0-indexing
        this.delta = delta;
    }

    public int compareTo(LogEntry o)
    {
        return this.day - o.day;
    }

    public String toString()
    {
        return "day " + day + " |#" + cowID + "| delta " + delta;
    }
}
