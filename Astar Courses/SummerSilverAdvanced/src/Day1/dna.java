package Day1;

import java.util.Arrays;
import java.util.Scanner;

public class dna {
    static int B;
    static int C;
    static String[] bulls;
    static String[] cows;
    static String[] animals;
    //static int[][] output;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        B = sc.nextInt();
        C = sc.nextInt();
        bulls = new String[B];
        cows = new String[C];
        animals = new String[B + C];

        //output = new int[B][C];
        int index = 0;

        for (int i = 0; i < B; i++)
        {
            bulls[i] = sc.next();
            animals[index] = bulls[i];
            index++;
        }

        for (int i = 0; i < C; i++)
        {
            cows[i] = sc.next();
            animals[index] = cows[i];
            index++;
        }
//
//        System.out.println(Arrays.toString(bulls));
//        System.out.println(Arrays.toString(cows));
//        System.out.println(Arrays.toString(animals));
        //System.out.println(children(1,0));




        for(int b = 0; b < B; b++)
        {
            for(int c = 0; c < C; c++)
            {
                //children(b,c);
                System.out.print(children(b,c) + " ");
            }
            System.out.println();
        }
    }

    static char[] sequence;
    public static int children(int bull, int cow)
    {
//        System.out.println("bull " + bulls[bull]);
//        System.out.println("cow " + cows[cow]);
        //System.out.println();
        int index = 0;
        int ans = 0;

        for (int i = 0; i < animals.length; i++)
        {
            if(!animals[i].equals(bulls[bull]) && !animals[i].equals(cows[cow]))
            {
                sequence = animals[i].toCharArray();
                index = 0;
                while (index < sequence.length && (sequence[index] == bulls[bull].charAt(index) || sequence[index] == cows[cow].charAt(index)))
                {
                    index++;
                }
                //System.out.println("index " + index);
                if(index == sequence.length)
                {
                    //System.out.println("child " + animals[i]);
                    ans++;
                }
            }
        }
        //System.out.println();
        return ans;
    }
}
