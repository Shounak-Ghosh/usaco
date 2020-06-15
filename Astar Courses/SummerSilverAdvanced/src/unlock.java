import java.io.*;
import java.util.*;

public class unlock
{

    static int[][] field = new int[27][27];
    static int[][] origin = new int [27][27];
    static boolean go = false;

    public static void main (String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int N1 = sc.nextInt();
        int N2 = sc.nextInt();
        int N3 = sc.nextInt();
        int x, y;
        for(int a = 0;a < N1;a++)
        {
            x = sc.nextInt() + 9;
            y = sc.nextInt() + 9;
            field[x][y] = 1;
            origin[x][y] = 1;
        }
        for(int a = 0; a<N2;a++)
        {
            x = sc.nextInt() + 9;
            y = sc.nextInt() + 9;
            field[x][y] = 2;
            origin[x][y] = 2;
        }
        for(int a = 0; a < N3;a++)
        {
            x = sc.nextInt() + 9;
            y = sc.nextInt() + 9;
            field[x][y] = 3;
            origin[x][y] = 3;
        }
        boolean flag = true;
        boolean a = true;
        boolean b = true;
        boolean c = true;

        while(flag)
        {
            flag = false;
            if(c && !recurse(3,1,0,0)|| !recurse(3,-1,0,0) || !recurse(3,0,1,0) ||!recurse(3,0,-1,0))
            {
                reset(3);
                flag = true;
                c = false;
            }
            if(b && !recurse(2,1,0,0)||!recurse(2,-1,0,0)||!recurse(2,0,1,0)||!recurse(2,0,-1,0))
            {
                reset(2);
                flag = true;
                b = false;
            }
            if(a && !recurse(1,1,0,0)||!recurse(1,-1,0,0)||!recurse(1,0,1,0)||!recurse(1,0,-1,0))
            {
                reset(1);
                flag = true;
                a = false;
            }
        }

        if(!a&&!b&&!c)
        {
            System.out.println(1);
        }
        else
            System.out.println(0);
    }
    private static boolean checkMove(int ID, int xdir, int ydir)
    {
        for (int b = 7; b<20;b++)
        {
            for(int a = 7; a<20;a++)
            {
                if(field[a][b]==ID)
                {
                    int x = a+xdir;
                    int y = b+ydir;

                    if(x<0||x>26||y<0||y>26)
                    {
                        return false;
                    }

                    if(field[x][y]!=0 &&field[x][y]!=ID)
                        return false;

                }
            }
        }

        return true;
    }

    private static boolean recurse(int ID, int xdir, int ydir, int counter)
    {
        if(counter>1000)
        {
            System.out.println(0);
        }

        if(checkMove(ID,xdir,ydir))
        {
            set(ID,xdir,ydir);
            if(checkTouch(ID))
                return false;
            if(!recurse(ID, 1, 0, ++counter))
                return false;
            if(!recurse(ID, -1, 0,++counter))
                return false;
            if(!recurse(ID, 0, 1,++counter))
                return false;
            return !recurse(ID, 0, -1,++counter);
        }
        return true;
    }

    private static boolean checkTouch(int ID)
    {
        for (int b = 0; b < 27; b++)
        {
            for(int a = 0; a < 27; a++)
            {

                if(field[a][b]==ID)
                {
                    if(a==26 || a==0||b==26|| b==0)
                        return true;
                }
            }
        }
        return false;
    }
    private static void set(int ID, int xdir, int ydir)
    {
        for (int b = 9; b<18;b++)
        {
            for(int a = 9; a<18;a++)
            {
                if(field[a][b]==ID)
                {
                    field[a][b] = 0;
                    field[a+xdir][b+ydir] = ID;
                }
            }
        }
    }

    private static void reset(int ID)
    {
        for (int y = 9; y<18;y++)
        {
            for(int x = 9; x<18;x++)
            {
                if(field[x][y]==ID)
                    field[x][y] = 0;
            }
        }
    }
}