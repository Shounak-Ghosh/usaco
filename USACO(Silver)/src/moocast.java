import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class moocast
{
    static int N;
    private static Cow[] cows;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter outf = new PrintWriter(new File("moocast.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());
        cows = new Cow[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int rad = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(x,y,rad, i);
        }

        int ans = 0;

        for (Cow c : cows)
        {
            ans = Math.max(ans,bfs(c));
        }

        outf.println(ans);
        outf.close();
        f.close();
    }

    private static int bfs(Cow start)
    {
        boolean[] visited = new boolean[N];
        Queue<Cow> q = new ArrayDeque<>();
        q.add(start);
        visited[start.id] = true;
        Cow current;
        while (!q.isEmpty())
        {
            current = q.remove();
            visited[current.id] = true;
            for (Cow c : cows)
            {
                if(!visited[c.id] && current.inRange(c))
                {
                    q.add(c);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++)
        {
            if(visited[i])
            {
                ans++;
            }
        }
        return ans;
    }

    static class Cow
    {
        int x;
        int y;
        int radius;
        int id;

        public Cow(int x, int y, int rad, int id)
        {
            this.x = x;
            this.y = y;
            radius = rad;
            this.id = id;
        }

        public boolean inRange(Cow other)
        {
            return ((x - other.x) * (x - other.x) + (y - other.y) * (y - other.y)) <= radius * radius;
        }
    }
}
