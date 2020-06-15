import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class shoppay
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numRegisters = sc.nextInt();
        Queue<Integer> line = new LinkedList<Integer>();
        ArrayList<ArrayList<Integer>> registers = new ArrayList<>();

        for(int i = 0; i < numRegisters; i++)
        {
            registers.add(new ArrayList<Integer>());
        }

        String type;
        //int num = 0;
        while (sc.hasNext())
        {
            type = sc.next();

            if(type.equals("C"))
            {
                 line.add(sc.nextInt());
            }

            if(type.equals("R"))
            {
                registers.get(sc.nextInt() - 1).add(line.remove());
            }
        }

        for(ArrayList<Integer> list: registers)
        {
            System.out.print(list.size() + " ");
            for(Integer i: list)
            {
                System.out.print(i + " ");
            }
            System.out.print("\n");
            //System.out.println(list);
        }

    }
}
