import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class btwr2
{
    public static void main(String[] args)
    {
        solve();
    }

    public static void solve()
    {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer,Integer> bales = new TreeMap<>();
        int numBales = sc.nextInt();
        int breadth = 0;
        int width = 0;

        for(int i = 0; i < numBales; i++)
        {
            width = sc.nextInt();
            breadth = sc.nextInt();

            bales.put(breadth,width);
        }
        System.out.println(bales.toString()); // least to greatest by breath

        int[] breadths = new int[numBales];
        int[] widths = new int[numBales];

        int counter = 0;

        for(Integer i: bales.keySet())
        {
            breadths[counter] = i;
            widths[counter] = bales.get(i);
            counter++;
        }

        System.out.println(Arrays.toString(breadths));
        System.out.println(Arrays.toString(widths));


        int numSubsets = (1 << numBales) -1;
        System.out.println(numSubsets);

        counter = 0;
        int max = 0;

        ArrayList<Integer> currentWidths = new ArrayList<>(numBales);
        ArrayList<Integer> currentBreadths = new ArrayList<>(numBales);


        for(int x = 0; x <= numSubsets; x++)
        {
            for(int y = 0; y < numBales; y++)
            {
                if((x & (1 << y)) > 0)
                {
                    currentBreadths.add(breadths[y]);
                    currentWidths.add(widths[y]);
                }
            }
        }


    }
}
