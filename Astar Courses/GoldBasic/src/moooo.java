import java.util.*;

public class moooo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Cow> cows = new ArrayList<>();

        int a,b;
        for (int i = 0; i < N; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            cows.add(new Cow(i, a, b));
        }
//        System.out.println("reached 0");

        Stack<Cow> heightStack = new Stack<>();

        int[] mooVal = new int[N];

        for (Cow cow : cows)
        {
            while (heightStack.size() > 0 && heightStack.peek().H < cow.H)
            {
                mooVal[cow.index] += heightStack.pop().V;
//                System.out.println("reached 1");
            }
            heightStack.push(cow);
        }
        Collections.reverse(cows);
        heightStack = new Stack<>();
        for (Cow cow : cows)
        {
            while (heightStack.size() > 0 && heightStack.peek().H < cow.H)
            {
                mooVal[cow.index] += heightStack.pop().V;
            }
            heightStack.push(cow);
        }
        int max = 0;
        for (int i = 0; i < N; i++)
        {
            if (mooVal[i] > max)
            {
                max = mooVal[i];
            }
        }
        System.out.println(max);
    }

    private static class Cow
    {
        int index;
        int V;
        int H;
        public Cow(int index, int H, int V)
        {
            this.index = index;
            this.V = V;
            this.H = H;
        }

        public int hashCode()
        {
            return V * 31 + H + 1000 * index;
        }
    }
}