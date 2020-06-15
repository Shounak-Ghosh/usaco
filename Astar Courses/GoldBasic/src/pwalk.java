import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pwalk
{
    static int N,Q;
    static int[][] matrix;
    static boolean[] marked;
    static int start,end,length;
    static BufferedWriter p = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        //Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(st.nextToken());
        Q =  Integer.parseInt(st.nextToken());
        matrix = new int[N + 1][N + 1];
        marked = new boolean[N + 1];

        int a,b,l;
        for (int i = 0; i < N - 1; i++) // N - 1 edges
        {
            st = new StringTokenizer(in.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            matrix[a][b] = l;
            matrix[b][a] = l;
        }

        for (int i = 0; i < Q; i++)
        {
            st = new StringTokenizer(in.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            length = 0;
            Arrays.fill(marked,false);
            marked[start] = true;
            dfs(start,0);
        }
    }

    public static void dfs(int current, int length) throws IOException
    {
        if(current == end)
        {
            //p.write(length);
            System.out.println(length);
            return;
        }

        for (int i = 1; i <= N; i++)
        {
            if (!marked[i] && matrix[current][i] > 0)
            {
                marked[i] = true;
                dfs(i,length + matrix[current][i]);
            }
        }
    }
}
