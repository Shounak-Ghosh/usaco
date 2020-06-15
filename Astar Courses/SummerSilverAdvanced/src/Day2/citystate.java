package Day2;

import java.util.*;
public class citystate
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Map<String, Long> map = new HashMap<>();

        for(int i = 0; i < N; i++)
        {
            String city = sc.next().substring(0,2);
            String state = sc.next();

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

        // pairs are double counted
        System.out.println(ans / 2);
    }
}