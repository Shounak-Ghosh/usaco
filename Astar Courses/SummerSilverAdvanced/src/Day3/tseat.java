package Day3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class tseat
{
    static int R;
    static int C;
    static seat[] seats;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        C = sc.nextInt();
        R = sc.nextInt();

        seats = new seat[R * C];

        int counter = 0;
        int row = 0;
        int col = 0;

        for(int i = 0; i < R * C; i++)
        {
            row = i / C;
            col = i % C;
            //System.out.println("r " + row + ",c " + col);
            seats[i] = new seat(i,row,col);
        }

        Arrays.sort(seats);

        //System.out.println(Arrays.toString(seats));

        for(int i = 0; i < seats.length; i++)
        {
            seats[i].priority = i + 1;
        }

        Arrays.sort(seats, new idCompare());

//        System.out.println(Arrays.toString(seats));
//        System.out.println();

        for(int i = 0; i < seats.length; i++)
        {
            System.out.print(seats[i].priority + " ");
            if((i + 1) % C == 0)
            {
                System.out.println();
            }
        }



    }

    static class seat implements Comparable<seat>
    {
        int row;
        int col;
        int id;
        int distance;
        int priority;

        public seat (int id, int row, int col)
        {
            this.row = row;
            this.col = col;
            this.id = id;

            distance = (int) Math.pow(Math.abs(row - R + 1), 2) + (int) Math.pow(Math.abs(col - (C / 2)),2) ;
        }

        public int compareTo(seat other)
        {
            int dist = this.distance - other.distance;

            if(dist == 0)
            {
                int row = other.row - this.row;
                if(row == 0)
                {
                    return this.col - other.col;
                }
                return row;
            }
            return dist;
        }

        public String toString()
        {
            return  "" + priority;
        }
    }

    static class idCompare implements Comparator<seat>
    {
        public int compare(seat a, seat b)
        {
            return a.id - b.id;
        }
    }


}


