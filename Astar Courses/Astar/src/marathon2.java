import java.util.Scanner;

public class marathon2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numCoordinates = sc.nextInt();
        MarathonCoordinate[] coordinates = new MarathonCoordinate[numCoordinates];

        int x;
        int y;
        for(int i = 0; i < numCoordinates; i++)
        {
            x = sc.nextInt();
            y = sc.nextInt();
            coordinates[i] = new MarathonCoordinate(x,y);
        }

        int totalDist = 0;

        for(int i = 0; i < numCoordinates - 1; i++)
        {
            totalDist += distance(coordinates[i], coordinates[i+1]);
        }

        int minDist = totalDist;
        int currDist = 0;

        for(int i = 1; i < numCoordinates -1; i++)
        {
            currDist = totalDist
                    - distance(coordinates[i],coordinates[i-1])
                    - distance(coordinates[i],coordinates[i + 1])
                    + distance(coordinates[i - 1], coordinates[i + 1]);
            minDist = Math.min(minDist,currDist);
        }

        System.out.println(minDist);


    }

    public static int distance(MarathonCoordinate pointA, MarathonCoordinate pointB)
    {
        return Math.abs(pointA.x - pointB.x) + Math.abs(pointA.y - pointB.y);
    }
}

class MarathonCoordinate
{
    int x;
    int y;

    public MarathonCoordinate(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
