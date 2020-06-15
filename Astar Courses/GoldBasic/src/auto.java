import java.util.*;
public class auto
{
    public static HashMap<String,Integer> indexes;
    public static String[] dict;

    public static void main(String[] args)
    {
        Scanner sc =  new Scanner(System.in);
        int numWords = sc.nextInt();
        int numQueries = sc.nextInt();
        dict = new String[numWords];
        indexes = new HashMap<>();

        for (int i=0; i<numWords; i++)
        {
            dict[i] = sc.next();
            indexes.put(dict[i], i+1);
        }
        Arrays.sort(dict);

        for (int i=0; i < numQueries; i++)
        {
            int rank = sc.nextInt();
            String partial = sc.next();
            System.out.println(solve(partial,rank));
        }
    }

    public static int solve(String partial, int rank)
    {
        char[] last = new char[1001];
        Arrays.fill(last, 'z');
        for (int i=0; i<partial.length(); i++)
        {
            last[i] = partial.charAt(i);
        }
        int start = binarySearch(partial, 0, dict.length);
        int end = binarySearch(new String(last), 0, dict.length);
        if (rank > end-start)
        {
            return -1;
        }
        return indexes.get(dict[start+rank-1]);
    }

    public static int binarySearch(String partial, int low, int high)
    {
        while (low < high-1)
        {
            int mid = (low+high)/2;
            if (partial.compareTo(dict[mid]) < 0)
            {
                high = mid;
            }
            else
                low = mid;
        }

        while (low < dict.length && dict[low].compareTo(partial) < 0)
        {
            low++;
        }
        return low;
    }
}