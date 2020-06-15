package Day3;

import java.util.*;

public class reduce
{

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        ReduceCoordinates[] cows = new ReduceCoordinates[N];
        for (int i=0; i < N; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            cows[i] = new ReduceCoordinates(x,y);
        }

        Arrays.sort(cows);
        for (int i=0; i<3; i++)
        {
            cows[i].removable = true;
        }

        for (int i= N- 3; i < N; i++)
        {
            cows[i].removable = true;
        }


        // Now sort in y.
        Arrays.sort(cows, new compareY());
        for (int i=0; i<3; i++)
            cows[i].removable = true;
        for (int i= N- 3; i < N; i++)
            cows[i].removable = true;

        // Get a complete list of all items that are removable.
        ArrayList<Integer> removable = new ArrayList<Integer>();
        for (int i=0; i< N; i++)
        {
            if (cows[i].removable)
                removable.add(i);
        }


        // Bigger than any possible answer given their bounds.
        int ans = 2000000000;


        for (int mask = 0; mask<(1<<(removable.size())); mask++)
        {


            if (Integer.bitCount(mask) != 3)
                continue;

            // Add these three bits.
            ArrayList<Integer> exclude = new ArrayList<Integer>();
            for (int i=0; i<removable.size(); i++)
            {
                if ((mask & (1<<i)) > 0)
                    exclude.add(removable.get(i));
            }

            // We try excluding these three cows, update if it improves our answer.
            ans = Math.min(ans, area(cows, exclude));
        }

        System.out.println(ans);
    }

    // Returns the area enclosing cows excluding Day3.ReduceCoordinates cows[exclude].
    public static int area(ReduceCoordinates[] cows, ArrayList<Integer> exclude) {

        int minX = 100000, maxX = 0;
        int minY = 100000, maxY = 0;

        // Go through all cows but the excluded one.
        for (int i=0; i<cows.length; i++) {
            if (exclude.contains(i))
                continue;

            minX = Math.min(minX, cows[i].x);
            maxX = Math.max(maxX, cows[i].x);
            minY = Math.min(minY, cows[i].y);
            maxY = Math.max(maxY, cows[i].y);
        }

        // Here is our box.
        return (maxX - minX) * (maxY - minY);
    }
}

class ReduceCoordinates implements Comparable<ReduceCoordinates>
{

    public int x;
    public int y;
    public boolean removable;

    public ReduceCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
        removable = false;
    }

    public int compareTo(ReduceCoordinates other)
    {
        return this.x - other.x;
    }
}

class compareY implements Comparator<ReduceCoordinates>
{
    public int compare(ReduceCoordinates a, ReduceCoordinates b)
    {
        return a.y - b.y;
    }
}