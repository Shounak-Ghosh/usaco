import java.io.*;
import java.util.StringTokenizer;
import java.util.Arrays;

public class angry_
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("angry.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] bales = new int[N];
        for (int i = 0; i < N; i++)
        {
            st = new StringTokenizer(f.readLine());
            bales[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(bales);

        int low = 1;
        // the maximal radius is half the distance between the first and last bales
        int high = (bales[N-1] - bales[0]) / 2;
        int mid;
        while (low < high - 1)
        {
            mid = (low + high)/2;

            if (valid(bales, K,mid)) // the mid value works, and every value above
            {
                high = mid;
            }
            else // the mid value doesn't work, R must be larger
                {
                    low = mid + 1;
                }
        }

        if (!valid(bales,K,low))
        {
            low++;
        }

        outf.println(low);
        outf.close();
        f.close();

    }

    public static boolean valid(int[] arr, int k,int R)
    {
        int currBale = 0;

        for (int i = 0; i < k; i++)
        {
            int start = arr[currBale]; // starts at the lowest coordinate
            while (currBale < arr.length && arr[currBale]-start <= 2*R)
            {
                currBale++;
            }

            if (currBale == arr.length)
                return true;
        }

        return false;
    }


//    public static void main(String[] args) throws Exception
//    {
//        // Read in data.
//        BufferedReader f = new BufferedReader(new FileReader("angry.in"));
//        StringTokenizer st = new StringTokenizer(f.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//        int[] arr = new int[N];
//        for (int i = 0; i < N; i++)
//        {
//            arr[i] = Integer.parseInt(f.readLine().trim());
//        }
//
//
//        // Sort it.
//        Arrays.sort(arr);
//
//        // Do binary search.
//        int low = 1, high = arr[N-1]-arr[0];
//        while (low < high-1)
//        {
//            int mid = (low+high)/2;
//
//            if (!valid(arr, K, mid))
//                low = mid+1;
//            else
//                high = mid;
//        }
//
//        if (!valid(arr, K, low)) low++;
//
//        // Write result.
//        PrintWriter outf = new PrintWriter(new FileWriter("angry.out"));
//        outf.println(low);
//        outf.close();
//        f.close();
//    }
//
//    public static boolean valid(int[] arr, int numCows, int range)
//    {
//
//        int curBale = 0;
//
//
//        for (int i=0; i<numCows; i++) {
//
//
//            int start = arr[curBale];
//            while (curBale < arr.length && arr[curBale]-start <= 2*range) curBale++;
//
//
//            if (curBale == arr.length) return true;
//        }
//
//        return false;
//    }
}
