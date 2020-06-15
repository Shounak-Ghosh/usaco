package Diagnostic;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by 22shounakg on 12/8/18.
 *
 */
public class elect
{
    public static Scanner sc = new Scanner(System.in);


    public static void main(String[] args)
    {
        int numFirstRoundCows = sc.nextInt();
        int numSecondRoundCows = sc.nextInt();
        ArrayList<Coordinate> cows = new ArrayList<Coordinate>();

        for(int i = 0; i < numFirstRoundCows; i++)
        {
            cows.add(new Coordinate(sc.nextInt(), sc.nextInt(), i + 1));
        }

        Collections.sort(cows, new sortCoordinateX());

        ArrayList<Coordinate> candidates = new ArrayList<Coordinate>();

        for(int i = cows.size() - numSecondRoundCows; i < cows.size(); i++)
        {
            candidates.add(cows.get(i));
        }

        //System.out.print(candidates);

        Collections.sort(candidates, new sortCoordinateY());

        System.out.println(candidates.get(candidates.size() -1));

    }
}
class Coordinate
{
    public int x;
    public int y;
    public int number;

    public Coordinate(int x, int y, int number)
    {
        this.x = x;
        this.y = y;
        this.number = number;
    }


    public String toString()
    {
        return "" + number;
    }
}

class sortCoordinateX implements Comparator<Coordinate>
{
    public int compare(Coordinate a, Coordinate b)
    {
        return a.x - b.x;
    }
}
class sortCoordinateY implements Comparator<Coordinate>
{
    public int compare(Coordinate a, Coordinate b)
    {
        return a.y - b.y;
    }
}
