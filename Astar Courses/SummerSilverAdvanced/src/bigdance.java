/*
ID: alexstar11
LANG: JAVA
TASK: bigdance
*/
import java.io.*;
import java.util.*;

class bigdance
{
    public static void main (String [] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int num = Integer.parseInt(st.nextToken());
        out.println(helper(1,num));
        out.close();
        System.exit(0);
    }
    public static int helper(int first,int last)
    {
        if(last-first==0)
        {
            return 0;
        }
        else if(last-first==1)
        {
            return last*first;
        }
        else
        {
            int middle=(last+first)/2;
            return helper(first,middle)+helper(middle+1,last);
        }
    }
}