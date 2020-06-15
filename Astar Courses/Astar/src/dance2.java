import java.util.Scanner;

public class dance2
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String dance;
        int numChars;

        int numDances = sc.nextInt();

        for(int i = 0; i < numDances; i++)
        {
            numChars = sc.nextInt();
            dance = sc.next();
            checkDance(dance);
        }
    }

    public static void checkDance(String dance)
    {
        char[] chars = dance.toCharArray();

        int counter = 0;
        for(int i = 0; i < chars.length; i++)
        {
            if(chars[i] == '>')
            {
                counter++;
            }

            if(chars[i] == '<')
            {
                counter--;
            }

            if(counter < 0)
            {
                break;
            }
        }

        if(counter == 0)
        {
            System.out.println("legal");
        }
        else {
            System.out.println("illegal");
        }

    }
}
