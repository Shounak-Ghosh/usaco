package Day2;

import java.util.Scanner;
import java.util.Arrays;

public class milk2
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        interval [] times = new interval [N];

        for(int i = 0; i < N; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();

            times[i] = new interval(x, y);
        }
        Arrays.sort(times);

        int begin = times[0].x;
        int end = times[0].y;
        int milktime = times[0].y - times[0].x;
        int stopping = 0;

        for(int i = 1; i < times.length; i++)
        {
            if(end >= times[i].x && end <= times[i].y)
            {
                end = times[i].y;
            }

            milktime = Math.max(end - begin, milktime);

            if(times[i].x > end)
            {

                milktime = Math.max(end - begin, milktime);
                stopping = Math.max(stopping, times[i].x - end);

                begin = times[i].x;
                end = times[i].y;

            }
        }
        System.out.println(milktime + " " + stopping);
    }

}

class interval implements Comparable <interval>
{
	public int x;
	public int y;
	
	public interval(int x, int y)
    {
		this.x = x;
		this.y = y;
	}

	public int compareTo(interval o)
    {
		Integer a = this.x;
		Integer b = o.x;
		return a.compareTo(b);
	}
	
}