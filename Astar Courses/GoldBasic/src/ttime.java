import java.util.Scanner;

public class ttime
{
    static int n,id;
    static int[] mark;
    static boolean[][] mat;
    public static void main(String[] args)
    {
        mark = new int[1001];
        mat = new boolean[1001][1001];

        Scanner sc = new Scanner(System.in);
        int m,q,a,b;

        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();

        for (int i=0; i<m; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            mat[a][b]=mat[b][a]=true;
        }

        id = 1;

        for (int i=1; i<=n; i++,id++)
            if (mark[i] == 0)
                visit(i);

        for (int i=0; i<q; i++)
        {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(mark[a]==mark[b] ? "Y" : "N");
        }
    }

    public  static void visit(int x)
    {
        mark[x]=id;
        for (int i=1; i<=n; i++)
            if (mark[i] == 0 && mat[x][i])
                visit(i);
    }


}
