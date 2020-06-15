import java.io.*;
import java.util.*;
public class cowcode
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("cowcode.in"));
        PrintWriter outf = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
        StringTokenizer st = new StringTokenizer(f.readLine());
        String s = st.nextToken();
        long index = Long.parseLong(st.nextToken());

        outf.println(parse(s, index-1));
        outf.close();
        f.close();
    }

    private static char parse(String s, long index)
    {
        // base case, the index is within the length of the string
        if(index < s.length())
        {
            return s.charAt((int)index);
        }

        // the length of the input string
        long length = s.length();

        while(2*length <= index)
        {
            length *= 2;
        }

        if(length == index)
        {
            return parse(s, length-1);
        }
        return parse(s, index - length - 1);
    }
}