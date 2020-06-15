package Day2;

import java.util.Arrays;
import java.util.Scanner;

// TODO: generating polynomials is broken, needs to be fixed
public class farmoff
{
    static long N;
    static long a;
    static long b;
    static long c;
    static long d;
    static long e;
    static long f;
    static long g;
    static long h;
    static long M;
    static cow[] cows;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        d = sc.nextLong();
        e = sc.nextLong();
        f = sc.nextLong();
        g = sc.nextLong();
        h = sc.nextLong();
        M = sc.nextLong();

//        System.out.println(N);
//
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.println(d);
//
//        System.out.println(e);
//        System.out.println(f);
//        System.out.println(g);
//        System.out.println(h);
//
//        System.out.println(M);



        cows = new cow[3 * (int) N];

        for(int i = 0; i < cows.length; i++)
        {
            cows[i] = new cow(generate(i,a,b,c,d,2), generate(i,e,f,g,h,3));
            //System.out.println("\t" + cows[i]);
        }

        //System.out.println(Arrays.toString(cows));

        Arrays.sort(cows);
        long weightSum = 0;
        long counter = N;
        long index = cows.length - 1;

        //System.out.println(Arrays.toString(cows));


        while (counter > 0)
        {
            weightSum += (cows[(int) index].weight % M);
            index--;
            counter--;
        }


        System.out.println(weightSum % M);

    }

    public static long generate(int x, long a, long b, long c, long m, int type)
    {
        //System.out.println((a * pow(x,5,m)) % m +  " + "  + (b * pow(x,type,m) % m) + " + " + c);
        return ((a * pow(x,5,m) % m) + (b * pow(x,type,m) % m) + c) % m;
    }

    public static long pow(long base, long exp, long mod)
    {
        long ans = 1;
        for(int i = 0; i < exp; i++)
        {
            ans = (ans * base) % mod;
        }
        return ans;
    }

}

class cow implements Comparable<cow>
{
    long weight;
    long utility;

    public cow(long w, long u)
    {
        weight = w;
        utility = u;
    }

    public int compareTo(cow other)
    {
        int temp = (int) (this.weight - other.weight);
        if (temp == 0)
        {
            return (int) (this.weight - other.weight);
        }
        return temp;
    }

    public String toString()
    {
        return "w "  + weight + "/u " + utility;
    }


}
