import java.io.*;
import java.util.StringTokenizer;

public class ctiming
{
    static int endHour;
    static int endMinute;
    static int endDay;

    static int startDay = 11;
    static int startHour = 11;
    static int startMinute = 11;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("ctiming.in"));
        PrintWriter outf = new PrintWriter(new File("ctiming.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());

        endDay = Integer.parseInt(st.nextToken());
        endHour = Integer.parseInt(st.nextToken());
        endMinute = Integer.parseInt(st.nextToken());

        int counter = -1;
        if(compareTo() < 0)
        {
            counter = 0;
            while (compareTo() != 0)
            {
                counter++;
                increment();
            }
        }
        outf.println(counter);
        f.close();
        outf.close();
    }

    public static void increment()
    {
        if(startHour == 23 && startMinute == 59)
        {
            startHour = -1;
            startDay++;
        }
        if(startMinute == 59)
        {
            startMinute = -1;
            startHour++;
        }
        startMinute++;
        //System.out.println(startDay + " " + startHour + " " + startMinute);
    }

    public static int compareTo()
    {
        int comp = startDay - endDay;
        if(comp != 0)
        {
            return comp;
        }
        comp = startHour - endHour;
        if(comp != 0)
        {
            return comp;
        }
        return startMinute - endMinute;
    }
}
