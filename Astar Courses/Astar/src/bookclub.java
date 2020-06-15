import java.util.Scanner;

public class bookclub
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args)
    {
        int numCows = sc.nextInt();
        int numQuestions = sc.nextInt();
        int numAnswers = sc.nextInt();

        int[][] clubData = new int[numCows][numQuestions];

        for(int r = 0; r < numCows; r++)
        {
            for(int c = 0; c < numQuestions; c++)
            {
                clubData[r][c] = sc.nextInt();
            }
        }

        boolean[] goodCows = new boolean[numCows]; // let false be the good cows
        int col = 0;
        int value = 0;

        for(int i = 0; i < numAnswers; i++) // for each answer
        {
            col = sc.nextInt() -1; // needs to be 0-indexed
            value = sc.nextInt();

            for(int j = 0; j < numCows; j++) // for each cow
            {
                if(!goodCows[j]) // if the cow is good
                {
                    goodCows[j] = !(clubData[j][col] == value);
                }
            }


        }
        int count = 0;

        for(int i = 0; i < numCows; i++)
        {
            if(goodCows[i])
            {
                count++;
            }
        }
        System.out.println(numCows - count);

    }
}
