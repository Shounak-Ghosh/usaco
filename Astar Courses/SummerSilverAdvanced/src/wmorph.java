import java.util.*;
import java.io.*;
class wmorph
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("wmorph.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wmorph.out")));
        String start=f.readLine();
        String end=f.readLine();
        int num=start.length();
        for(int i=0;i < start.length();i++)
        {
            if(start.charAt(i)==end.charAt(i))
                num--;
        }
        out.println(num);
        out.close();
        System.exit(0);
    }
}