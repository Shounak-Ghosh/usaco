import java.util.Scanner;
public class iou
{
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {
        int numCows = sc.nextInt();

        int[] values = new int[numCows];

        for(int i = 0; i < numCows; i++)
        {
            values[i] = sc.nextInt();
        }

        int earliestDebtPos = 0;
        int distTraveled = 0;
        int currentCash = 0;
        int currentDebt = 0;

        for(int i = 0; i < numCows; i++)
        {

            // collect from cows paying debt
            if(values[i] > 0)
            {
                currentCash += values[i];
            }
            else // add to the money
            {
                currentDebt += Math.abs(values[i]);
            }

            if(currentDebt <= currentCash && currentDebt > 0)
            {
                distTraveled += 2 * (i - earliestDebtPos);
                currentCash -= currentDebt;
                currentDebt = 0;
                earliestDebtPos = i;
            }

            distTraveled++;

            if(currentDebt == 0)
            {
                earliestDebtPos++;
            }
        }
        System.out.println(distTraveled);
    }
}
