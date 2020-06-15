import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class haybales_
{
    static int N,Q;
    static Bale[] bales;
    static int[] positions;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("haybales.in"));
        PrintWriter outf = new PrintWriter(new File("haybales.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        bales = new Bale[N];
        positions = new int[N];
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < N; i++)
        {
            int a = Integer.parseInt(st.nextToken());
            bales[i] = new Bale(a);
            positions[i] = a;
        }
        Arrays.sort(bales);
        Arrays.sort(positions);
        for (int i = 0; i < N; i++)
        {
            bales[i].count = i + 1;
        }

        //System.out.println(Arrays.toString(bales));
        //System.out.println(Arrays.toString(positions));

        for(int i = 0; i < Q; i++)
        {
            st = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            outf.println(query(a,b));
        }
        f.close();
        outf.close();
    }

    static int query(int lower, int higher)
    {

        int ans = 0;
        int lowerPos = Arrays.binarySearch(positions,lower);
        int higherPos = Arrays.binarySearch(positions,higher);

        if(lowerPos >= 0 && higherPos >= 0)
        {
            ans = 1;
        }

        if (lowerPos < 0)
        {
            lowerPos = -(lowerPos + 1);
        }
        if (higherPos < 0)
        {
            higherPos = -(higherPos + 1);
        }
        if (higherPos == bales.length)
        {
            higherPos--;
        }
        if (lowerPos == bales.length)
        {
            lowerPos--;
        }
        //System.out.println(lower + " >> " + lowerPos + " >> " + bales[lowerPos].count);
        //System.out.println(higher + " >> " + higherPos + " >> " + bales[higherPos].count);
        //System.out.println();
        ans += bales[higherPos].count - bales[lowerPos].count;

        return ans;
    }

    static class Bale implements Comparable<Bale>
    {
        int position;
        int count;
        public Bale(int pos)
        {
            position = pos;
        }

        public int compareTo(Bale other)
        {
            return this.position - other.position;
        }

        public String toString()
        {
            return "(" + position + ", " + count + ")";
        }
    }
}
