import java.util.ArrayList;
import java.util.Scanner;

public class dinner
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int numCows = sc.nextInt();
        int numSeats = sc.nextInt();

        //DinnerCoordinate[] cows = new DinnerCoordinate[numCows];
        //DinnerCoordinate[] seats = new DinnerCoordinate[numSeats];

        ArrayList<DinnerCoordinate> cows = new ArrayList<DinnerCoordinate>();
        ArrayList<DinnerCoordinate> seats = new ArrayList<DinnerCoordinate>();

        for(int i = 0; i < numCows; i++)
        {
            //cows[i] = new DinnerCoordinate(sc.nextInt(), sc.nextInt());
            cows.add(new DinnerCoordinate(sc.nextInt(), sc.nextInt(), i + 1));
        }

        for(int i = 0; i < numSeats; i++)
        {
            //seats[i] = new DinnerCoordinate(sc.nextInt(), sc.nextInt());
            seats.add(new DinnerCoordinate(sc.nextInt(), sc.nextInt(), i + 1));
        }

       // System.out.println(cows);
       // System.out.print(seats);

        int seatedCow = 0;

        while (seats.size() > 0)
        {
            seatedCow = findNearestCow( seats.remove(0), cows);
            cows.remove(seatedCow);
            //System.out.println("\n");
            //System.out.println(cows);
            //System.out.print(seats);
        }

        if(cows.size() == 0)
        {
            System.out.println("0");
        }
        //System.out.println("\n" + cows + "\n");
        for(int i = 0; i < cows.size(); i++)
        {
            System.out.println(cows.get(i));
        }

    }

    public static int findNearestCow(DinnerCoordinate seat, ArrayList<DinnerCoordinate> cows)
    {
        long minDistance = Long.MAX_VALUE;
        int index = 0;
        long dist = 0;

        for(int i = 0; i < cows.size(); i++)
        {
            dist = seat.computeDistance(cows.get(i));
            //System.out.println("\nindex " + i + " with dist " + dist);
            if(dist < minDistance)
            {
                minDistance = dist;
                index = i;
            }
        }
        //System.out.println("\nindex closest to seat " + seat.toString() + ": " + index);
        return  index;
    }
}
class DinnerCoordinate
{
    public long x;
    public long y;
    public int number;

    public DinnerCoordinate(long x, long y, int number)
    {
        this.x = x;
        this.y = y;
        this.number = number;
    }

    public long computeDistance (DinnerCoordinate coords) // doesnt compute the sqrt part
    {
        return Math.abs(coords.x -x) * Math.abs(coords.x -x) + Math.abs(coords.y - y) * Math.abs(coords.y - y);
    }

    public String toString()
    {
        return "" + number;
    }
}
