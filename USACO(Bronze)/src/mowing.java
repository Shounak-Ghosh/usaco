import java.io.*;
import java.util.*;
public class mowing
{
    static  int numDirections;
    static ArrayList<MowingCoordinate> cells = new ArrayList<>();
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("mowing.in"));
        PrintWriter outf = new PrintWriter(new File("mowing.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numDirections = Integer.parseInt(st.nextToken());

        String direction;
        int numSteps;
        int currentX = 0;
        int currentY = 0;
        MowingCoordinate currentCoordinate;
        int currentTime = 0;

        for(int i = 0; i < numDirections; i++)
        {
            st = new StringTokenizer(f.readLine());
            direction = st.nextToken();
            numSteps = Integer.parseInt(st.nextToken());

            if(direction.equals("N"))
            {
                for(int j = 0; j < numSteps; j++)
                {
                    currentCoordinate = new MowingCoordinate(currentX,currentY + j);

                    if(!cells.contains(currentCoordinate))
                    {
                        cells.add(currentCoordinate);
                    }
                    cells.get(cells.indexOf(currentCoordinate)).timesVisited.add(currentTime);
                    currentTime++;
                }
                currentY += numSteps;
            }
            else if(direction.equals("E"))
            {
                for(int j = 0; j < numSteps; j++)
                {
                    currentCoordinate = new MowingCoordinate(currentX + j, currentY);

                    if(!cells.contains(currentCoordinate))
                    {
                        cells.add(currentCoordinate);
                    }
                    cells.get(cells.indexOf(currentCoordinate)).timesVisited.add(currentTime);
                    currentTime++;
                }
                currentX += numSteps;
            }
            else if(direction.equals("S"))
            {
                for(int j = 0; j < numSteps; j++)
                {
                    currentCoordinate = new MowingCoordinate(currentX,currentY - j);

                    if(!cells.contains(currentCoordinate))
                    {
                        cells.add(currentCoordinate);
                    }
                    cells.get(cells.indexOf(currentCoordinate)).timesVisited.add(currentTime);
                    currentTime++;
                }
                currentY -= numSteps;
            }
            else if(direction.equals("W"))
            {
                for(int j = 0; j < numSteps; j++)
                {
                    currentCoordinate = new MowingCoordinate(currentX - j,currentY);

                    if(!cells.contains(currentCoordinate))
                    {
                        cells.add(currentCoordinate);
                    }
                    cells.get(cells.indexOf(currentCoordinate)).timesVisited.add(currentTime);
                    currentTime++;
                }
                currentX -= numSteps;
            }

        }

        int index = 0;
        while (index < cells.size())
        {
            if(cells.get(index).timesVisited.size() <= 1)
            {
                cells.remove(index);
            }
            else
            {
                index++;
            }
        }

        System.out.println(cells);
        ArrayList<Integer> timeDifferences = new ArrayList<>();

        for(MowingCoordinate c : cells)
        {
            for(int i = 1; i < c.timesVisited.size(); i++)
            {
                timeDifferences.add(c.timesVisited.get(i) - c.timesVisited.get(i-1));
            }
        }

        System.out.println(timeDifferences);
        Collections.sort(timeDifferences);
        if(timeDifferences.size() == 0)
        {
            outf.println(-1);
        }
        else
        {
            outf.println(timeDifferences.get(0));
        }
        f.close();
        outf.close();
    }
}
class MowingCoordinate
{
    int x;
    int y;
    ArrayList<Integer> timesVisited;
    public MowingCoordinate (int x, int y)
    {
        this.x = x;
        this.y = y;
        timesVisited = new ArrayList<>();
    }

    public  String toString()
    {
        return "\n" + x + " " + y + "\ntimes: " + timesVisited.toString() + "\n";
    }

    public boolean equals(Object other)
    {
        MowingCoordinate m = (MowingCoordinate) other;
        return m.x == this.x && m.y == this.y;
    }
}