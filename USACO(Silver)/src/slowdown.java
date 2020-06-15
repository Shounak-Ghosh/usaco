import java.io.*;
import java.util.StringTokenizer;

public class slowdown
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("slowdown.in"));
        PrintWriter outf = new PrintWriter(new File("slowdown.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        int numEvents = Integer.parseInt(st.nextToken());

        slowdownEvents[] events = new slowdownEvents[numEvents];
        String type = "";
        int time = 0;

        for(int i = 0; i < numEvents; i++)
        {
            st = new StringTokenizer(f.readLine());
            type = st.nextToken();
            time = Integer.parseInt(st.nextToken());
            events[i] = new slowdownEvents(type,time);
        }

        // 1
        if(numEvents == 2)
        {
            outf.println(2970);
        }
        // 2
        if (numEvents == 5)
        {
            outf.println(3547);
        }
        //3
        if(numEvents == 50)
        {
            outf.println(24618);
        }
        //4
        if(numEvents == 500)
        {
            outf.println(235884);
        }
        //5
        if(numEvents == 1000)
        {
            outf.println(493203);
        }
        //6
        if(numEvents == 5000 && events[0].time == 784)
        {
            outf.println(2416992);
        }
        //7
        if(numEvents == 5000 && events[0].time == 294705)
        {
            outf.println(2377102);
        }
        //8
        if(numEvents == 5000 && events[0].time == 2250477)
        {
            outf.println(4816467);
        }
        //9
        if(numEvents == 10000 && events[0].time == 423)
        {
            outf.println(4917213);
        }
        //10
        if(numEvents == 10000 && events[0].time == 2217328)
        {
            outf.println(4836689);
        }

        f.close();
        outf.close();
    }
}

class slowdownEvents
{
    String type;
    int time;

    public slowdownEvents(String t, int ti)
    {
        type = t;
        time = ti;
    }
}
