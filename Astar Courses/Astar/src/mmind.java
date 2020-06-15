import java.util.Scanner;
/**
 * Created by 22shounakg on 10/20/18.
 *
 */

public class mmind
{
    public static Scanner sc = new Scanner(System.in);
    public static int numGuesses;
    public static guess[] staticGuesses;

    public static void main(String[] args)
    {
        int numGuess = sc.nextInt();
        numGuesses = numGuess;
        guess[] guesses = new guess[numGuess];
        int g;
        int c;
        int w;

        for(int i = 0; i < numGuess; i++)
        {
            g = sc.nextInt();
            c = sc.nextInt();
            w = sc.nextInt();
            guesses[i] = new guess(g,c,w);
        }
        staticGuesses = guesses;
        /* /
        for(int i = 0; i < numGuess; i++)
        {
            System.out.println(staticGuesses[i].guess);
            compatible(i,7002);
        }
        /* */

        /* */
        for (int i = 1000; i <= 9999; i++)
        {
            if (candidate(i))
            {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println("NONE");
        /* */
    }

    public static boolean candidate(int candidate)
    {
        for(int i = 0; i < numGuesses; i++)
        {
            if (!compatible(i, candidate))
            {
                return false;
            }
        }
        return true;
    }

    public static boolean compatible(int index, int candidate)
    {
        char[] candidateChars = ("" + candidate).toCharArray();
        char[] guessChars = ("" + staticGuesses[index].guess).toCharArray();
        char[] temp = guessChars;

        boolean test1;
        int feedback1 = 0;

        for(int i = 0; i < 4; i++)
        {
            if(candidateChars[i] == temp[i])
            {
                candidateChars[i] = 'a';
                temp[i] = 'b';
                feedback1++;
            }
        }
        //System.out.println("Reported numbers in the correct Location: " + feedback1);
        test1 = feedback1 == staticGuesses[index].numInCorrLoc;

        //if(!test1)
        // System.out.println("DOES NOT MATCH: " + staticGuesses[index].numInCorrLoc);

        boolean test2;
        int feedback2 = 0;

        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                if(candidateChars[i] == temp[j])
                {
                    feedback2++;
                }
            }
        }
        //feedback2 -= feedback1;
        //System.out.println("Reported numbers in the wrong Location: " + feedback2);

        test2 = feedback2 == staticGuesses[index].numInWrongLoc;

        //if(!test2)
        //System.out.println("DOES NOT MATCH: " + staticGuesses[index].numInWrongLoc);

        return test1 && test2;
    }
}
class guess
{
    public int guess;
    public int numInCorrLoc;
    public int numInWrongLoc;

    public guess(int g, int c, int w)
    {
        guess = g;
        numInCorrLoc = c;
        numInWrongLoc = w;
    }
}
