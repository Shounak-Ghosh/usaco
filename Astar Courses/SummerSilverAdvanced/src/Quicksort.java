import java.util.Scanner;

public class Quicksort
{
    static int[] array;
    public static void main(String[] args)
    {
        // read input
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        array = new int[N];

        for (int i = 0; i < N; i++)
        {
            array[i] = sc.nextInt();
        }

        quicksort(array,0,N - 1);

    }

    public static int partition(int[] array, int lo, int hi)
    {
        int pivotIndex = hi; // pivot over last element
        int pivotValue = array[hi];
        int storeIndex = lo;
        int temp = 0;


        for (int i = lo; i < hi; i++)
        {
            if (array[i] < pivotValue)
            {
                temp = array[i];
                array[i] = array[storeIndex];
                array[storeIndex] = temp;
                storeIndex++;
            }
        }
        temp = array[pivotIndex];
        array[pivotIndex] = array[storeIndex];
        array[storeIndex] = temp;
        return storeIndex;
    }

    public static void quicksort(int[] arr, int lo, int hi)
    {
        int p;
        if (lo < hi)
        {
            p = partition(arr,lo,hi);
            for (int i = 0; i < array.length;i++)
            {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            quicksort(arr,lo,p-1);
            quicksort(arr,p+1,hi);
        }
    }
}
