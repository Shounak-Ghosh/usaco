import java.util.Scanner;
import java.util.Stack;

public class robo
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numLines = sc.nextInt();
        int counter = 1;
        Stack<Integer> haybales = new Stack<>();

        String command = "";
        for(int i = 0; i < numLines; i++)
        {
            command = sc.next();

            if(command.equals("ADD"))
            {
                haybales.push(counter);
                counter++;
            }

            if(command.equals("REMOVE"))
            {
                haybales.pop();
            }

            //System.out.println(haybales);
        }

        System.out.println(haybales.size());
        Stack<Integer> temp = new Stack<>();
        while (!haybales.isEmpty())
        {
            temp.push(haybales.pop());
        }

        while (!temp.isEmpty())
        {
            System.out.println(temp.pop());
        }
    }
}
