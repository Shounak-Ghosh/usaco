import java.util.*;
public class lines
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Coordinate[] points = new Coordinate[N];
        for (int i = 0; i < N; i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Coordinate(x, y);
        }


        Set<Double> slopes = new HashSet<>();
        for (int i = 0; i < N; i++)
        {
            for (int j = i + 1; j < N; j++)
            {
                if (points[i].x == points[j].x)
                    slopes.add(2147483647.0); // in the case of a vertical line
                else if (points[i].y == points[j].y)
                    slopes.add(0.0);
                else
                {
                    double y = points[j].y - points[i].y;
                    double x = points[j].x - points[i].x;
                    double slope = y / x;
                    slopes.add(slope);
                }
            }
        }
        int numSlopes = slopes.size();
        System.out.println(numSlopes);

    }

}

class Coordinate
{
    int x, y;
    public Coordinate(int a, int b)
    {
        x = a;
        y = b;
    }
}