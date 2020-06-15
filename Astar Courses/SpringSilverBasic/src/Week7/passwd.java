package Week7;

import java.util.Arrays;
import java.util.Scanner;

public class passwd
{
    static int len;
    static int numChars;
    static char[] letters;
    static char[] temp;
    static boolean[] type;
    static boolean[] mark;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        len = sc.nextInt();
        numChars = sc.nextInt();

        letters = new char[numChars];
        temp = new char[len];
        type = new boolean[numChars];
        mark = new boolean[numChars];

        for (int i = 0; i < numChars; i++)
        {
            letters[i] = sc.next().charAt(0);
            type[i] = isVowel(letters[i]);
        }
        Arrays.sort(letters);
        solve(-1,"");
    }

    public static void solve(int pos, String s)
    {
        if (s.length() == len)
        {
            if(isValid(s))
            {
                System.out.println(s);
            }
            return;
        }

        for (int i = pos + 1; i < numChars; i++)
        {

            solve(i,s + letters[i]);

        }
    }

    public static boolean isValid(String s)
    {
       int numVowels = 0;
       int numConsonants = 0;

       temp = s.toCharArray();


       for(int i = temp.length - 1; i > 0; i--)
       {
           if(isVowel(temp[i]))
           {
               numVowels++;
           }
           else
           {
               numConsonants++;
           }
       }
       if (isVowel(temp[0]))
       {
           numVowels++;
       }
       else
       {
           numConsonants++;
       }

       return numVowels >= 1 && numConsonants >= 2;
    }

    public static boolean isVowel(char c)
    {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
