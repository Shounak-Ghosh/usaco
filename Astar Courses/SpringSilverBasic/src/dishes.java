import java.util.Scanner;
import java.util.Stack;

public class dishes
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numDishes = sc.nextInt();

        Stack<Integer> dishes = new Stack<Integer>();

        for(int i = numDishes; i >= 1; i--)
        {
            dishes.push(i);
        }

        Stack<Integer> washed = new Stack<>();
        Stack<Integer> cleaned = new Stack<>();

        int command = 0;
        int currentDishes = 0;



        while (numDishes > cleaned.size())
        {
            command = sc.nextInt();
            currentDishes = sc.nextInt();

            if(command == 1)
            {
                for(int i = 0; i < currentDishes; i++)
                {
                    washed.push(dishes.pop());
                }
            }

            if (command == 2)
            {
                for(int i = 0; i < currentDishes; i++)
                {
                    cleaned.push(washed.pop());
                }
            }
        }



        while (!cleaned.isEmpty())
        {
            System.out.println(cleaned.pop());
        }
    }
}

