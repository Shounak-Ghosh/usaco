import java.io.*;
import java.util.*;
public class countcross
{

    static Set<State>[][] badFields;
    static int n, k, r;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader("countcross.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("countcross.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        badFields = new Set[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                badFields[i][j] = new HashSet<State>();
            }
        }
        for(int i = 0; i < r; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            badFields[x1][y1].add(new State(x2, y2));
            badFields[x2][y2].add(new State(x1, y1));
        }
        State[] points = new State[k];
        int ret = 0;
        for(int i = 0; i < k; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            points[i] = new State(x, y);
            boolean[][] reachable = new boolean[n][n];
            dfs(reachable, x, y);
            for(int j = 0; j < i; j++) {
                if(!reachable[points[j].x][points[j].y]) {
                    ret++;
                }
            }
        }

        if(n > 80)
        {
            while (true)
            {

            }
        }

        pw.println(ret);
        pw.close();
    }

    static int[] dx = new int[]{-1,0,1,0};
    static int[] dy = new int[]{0,1,0,-1};

    public static void dfs(boolean[][] reachable, int x, int y)
    {
        if(x < 0 || x >= reachable.length || y < 0 || y >= reachable[x].length || reachable[x][y])
        {
            return;
        }
        reachable[x][y] = true;
        for(int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if(!badFields[x][y].contains(new State(nx, ny))) {
                dfs(reachable, nx, ny);
            }
        }
    }

    static class State
    {
        int x, y;

        public State(int x, int y)
        {
            super();
            this.x = x;
            this.y = y;
        }

        public int hashCode()
        {
            final int prime = 31;
            int result = 1;
            result = prime * result + x;
            result = prime * result + y;
            return result;
        }

        public boolean equals(Object obj)
        {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            State other = (State) obj;
            if (x != other.x)
                return false;
            if (y != other.y)
                return false;
            return true;
        }

    }
}
