import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class citystate
{
    static int N;
    public static void main(String[] args) throws Exception
    {
        BufferedReader f = new BufferedReader(new FileReader("citystate.in"));
        PrintWriter outf = new PrintWriter(new File("citystate.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        N = Integer.parseInt(st.nextToken());

        HashMap<String, Long> map = new HashMap<>();

        for(int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            String city = st.nextToken().substring(0,2);
            String state = st.nextToken();

            if(!city.equals(state))
            {
                String key = city + state;
                if(!map.containsKey(key))
                {
                    map.put(key, 0L); // 0 long
                }
                map.put(key, map.get(key) + 1);
            }
        }

        long ans = 0;

        for(String key: map.keySet())
        {
            String otherKey = key.substring(2) + key.substring(0, 2);
            if(map.containsKey(otherKey))
            {
                ans += map.get(key) * map.get(otherKey);
            }
        }

        outf.println(ans/2);
        f.close();
        outf.close();
    }
}
