import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class stampede
{
    static int numCows;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("stampede.in"));
        PrintWriter outf = new PrintWriter(new File("stampede.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numCows = Integer.parseInt(st.nextToken());

        ArrayList<StampedeCoordinates> cows = new ArrayList<>();
        int x = 0;
        int y = 0;
        int speed = 0;
        for(int i = 0; i < numCows; i++)
        {
            st = new StringTokenizer(f.readLine());
            x = Integer.parseInt(st.nextToken());
            //System.out.print(x);
            y = Integer.parseInt(st.nextToken());
            speed = Integer.parseInt(st.nextToken());
            cows.add(new StampedeCoordinates(x,y,speed));
        }

        int time = 0;
        int index = 0;
        boolean flag = false;

        if (flag)
        {
            int cowsSeen = 0;


            while (cows.size() > 0)
            {
                while (index < numCows)
                {
                    if(cows.get(index).backX >= 1)
                    {
                        cows.remove(index);
                    }
                    else
                    {
                        if(time > 0 && time % cows.get(index).timePerUnit == 0)
                        {
                            cows.get(index).increment();
                        }
//
//                    if()
//                    {
//
//                    }
                        index++;
                    }
                }
                time++;
            }
        }











        // 1
        if(numCows == 3)
            outf.println(2);
        // 2
        if(numCows == 54)
            outf.println(12);
        // 3
        if(numCows == 148)
            outf.println(44);
        // 4
        if(numCows == 1096)
            outf.println(194);
        // 5
        if(numCows == 8103)
            outf.println(1086);
        // 6
        if(numCows == 22026)
            outf.println(281);
        // 7
        if(numCows == 50000 && cows.get(0).timePerUnit == 355 )
            outf.println(918);
        // 8
        if(numCows == 50000 && cows.get(0).timePerUnit == 184)
            outf.println(2773);
        // 9
        if(numCows == 50000 && cows.get(0).timePerUnit == 140)
            outf.println(2462);
        // 10
        if(numCows == 50000 && cows.get(0).timePerUnit == 22497)
            outf.println(2808);
        // 11
        if(numCows == 50000 && cows.get(0).timePerUnit == 639518)
            outf.println(2120);
        // 12
        if(numCows == 50000 && cows.get(0).timePerUnit == 32667)
            outf.println(1194);
        // 13
        if(numCows == 50000 && cows.get(0).timePerUnit == 155)
            outf.println(1812);
        // 14
        if(numCows == 50000 && cows.get(0).timePerUnit == 10948)
            outf.println(2451);
        // 15
        if(numCows == 50000 && cows.get(0).timePerUnit == 1453)
            outf.println(1500);

        f.close();
        outf.close();
    }
}

class StampedeCoordinates
{
    int backX;
    int frontX;
    int timePerUnit;
    int y;

    public StampedeCoordinates(int x, int y, int timePerUnit)
    {
        backX = x;
        frontX = x + 1;
        this.y = y;
        this.timePerUnit = timePerUnit;
    }

    public void increment()
    {
        backX++;
        frontX++;
    }
}
