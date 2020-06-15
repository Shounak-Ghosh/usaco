import java.util.Arrays;
import java.util.Scanner;

public class fad
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numCows = sc.nextInt();
        int fad = sc.nextInt();
        int dfad = sc.nextInt();

        int[] resistances = new int[numCows];

        for(int i = 0; i <  numCows; i++)
        {
            resistances[i] = sc.nextInt();
        }

        Arrays.sort(resistances);

        int participants = 0;
        for(int i = 0; i < numCows; i++ )
        {
            if(resistances[i] < fad)
            {
                participants++;
                fad+=dfad;
            }
        }
        System.out.print(participants);
    }
}
