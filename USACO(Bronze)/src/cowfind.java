import java.io.*;
import java.util.ArrayList;

public class cowfind
{
    static String grass;
    static char[] chars;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("cowfind.in"));
        PrintWriter outf = new PrintWriter(new File("cowfind.out"));

        grass = f.readLine();
        chars = grass.toCharArray();

        ArrayList<Integer> hind = hindIndexes();
        ArrayList<Integer> front = frontIndexes();

        int counter = 0;

        for(Integer i : hind)
        {
            for(Integer k: front)
            {
                if(i < k)
                {
                    counter++;
                }
            }
        }
        outf.println(counter);
        f.close();
        outf.close();
    }

    public static ArrayList<Integer> hindIndexes()
    {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        String temp = "";

        for(int i = 0; i < chars.length - 1; i++)
        {
            temp = "" + chars[i] + chars[i + 1];
            if(temp.equals("(("))
            {
                indexes.add(i);
            }

        }
        return indexes;
    }

    public static ArrayList<Integer> frontIndexes()
    {
        ArrayList<Integer> indexes = new ArrayList<Integer>();
        String temp = "";

        for(int i = 0; i < chars.length - 1; i++)
        {
            temp = "" + chars[i] + chars[i + 1];
            if(temp.equals("))"))
            {
                indexes.add(i);
            }

        }
        return indexes;
    }
}
