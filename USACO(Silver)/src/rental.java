import java.io.*;
import java.util.*;
public class rental
{
    static int N, M,R;
    static int[] cows;
    static long[] output;
    static int[] rent;
    static Shop[] milk;

    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("rental.in"));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter("rental.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        cows = new int[N];
        milk = new Shop[M];
        rent = new int[R];
        output = new long[N];

        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            cows[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cows);
        //System.out.println(Arrays.toString(cows));

        for (int i = 0; i < M; i++)
        {
            st = new StringTokenizer(f.readLine());
            int q = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            milk[i] = new Shop(q,p);
        }
        Arrays.sort(milk);
        //System.out.println(milk);

        for (int i = 0; i < R; i++)
        {
            st = new StringTokenizer(f.readLine());
            rent[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rent);


        int sum = 0;
        for (int i = N - 1; i >= 0; i--)
        {
            sum += cows[i];
            output[i] = milkOutput(sum);
        }

        long ans = 0L;
        long rentVal = 0;
        long milkVal = 0;
        int rentIndex = R - 1;

        for (int i = 0; i < N - 1; i++)
        {
            if(rentIndex >= 0)
            {
                rentVal = rent[rentIndex] + output[i + 1];
            }
            milkVal = output[i];

            if(rentVal >= milkVal)
            {
                ans += rent[rentIndex];
                rentIndex--;
            }
            else
                {
                    ans += milkVal;
                    break;
                }
        }

        //System.out.println(ans);
        outf.println(ans);
        outf.close();
        f.close();
    }

    public static long milkOutput(int gallons)
    {
        long ans = 0;

        for (int i = 0; i < M; i++)
        {
            if(gallons >= milk[i].quantity)
            {
                ans += milk[i].quantity * milk[i].price;
                gallons -= milk[i].quantity;
            }
            else if(gallons < milk[i].quantity)
            {
                ans += gallons * milk[i].price;
                return ans;
            }
        }
        return ans;
    }

    static class Shop implements Comparable<Shop>
    {
        int quantity;
        int price;

        public Shop(int q, int p)
        {
            quantity = q;
            price = p;
        }

        public int compareTo(Shop other)
        {
            return other.price - price;
        }

        public String toString()
        {
            return "q" + quantity + " p" + price;
        }
    }
}
