import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class invite
{
    private static int N;
    private static int G;
    private static HashMap<Integer,HashSet<Integer>> groups;
    private static HashMap<Integer,HashSet<Integer>> cows;
    private static boolean[] invited;

    public static void main(String[] args) throws IOException
    {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());

        groups = new HashMap<>(G);
        cows = new HashMap<>(N);
        invited = new boolean[N];
        int n = 0;

        for (int i = 0; i < N; i++)
        {

            cows.put(i, new HashSet<>());

        }

        for (int i = 0; i < G; i++)
        {
            groups.put(i, new HashSet<>());

            st = new StringTokenizer(in.readLine());

            int S = Integer.parseInt(st.nextToken());

            for (int j = 0; j < S; j++)
            {

                n = Integer.parseInt(st.nextToken());
                groups.get(i).add(n - 1);
                cows.get(n-1).add(i);
            }

        }

//        System.out.println("GROUPS");
//        for (int i = 0; i < groups.length; i++)
//        {
//            System.out.println(i  + " " + groups[i].toString());
//        }
//
//        System.out.println("COWS");
//        for (int i = 0; i < cows.length; i++)
//        {
//            System.out.println(i  + " " + cows[i].toString());
//        }

        Deque<Integer> q = new ArrayDeque<>();

        long time = System.nanoTime();

        int result = 0;
        q.push(0);
        invited[0] = true;

        while (!q.isEmpty())
        {
            int cow = q.pop();
            result++;
            for (int group : cows.get(cow)) // broken
            {
                groups.get(group).remove(cow);

                if (groups.get(group).size() == 1)
                {
                    int last = (Integer) groups.get(group).toArray()[0];

                    if (!invited[last])
                    {
                        invited[last] = true;
                        q.push(last);
                    }
                }
            }
        }
        System.out.println(result);
    }
}