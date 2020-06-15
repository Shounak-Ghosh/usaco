import java.util.Scanner;

public class Mergesort
{
    private  static int[] numbers;
    private  static int[] helper;

    private int number;


    public static void main(String[] args)
    {
        // read input
        int N;
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numbers = new int[N];

        for (int i = 0; i < N; i++)
        {
            numbers[i] = sc.nextInt();
        }
        sort(numbers);

    }

    public static void sort(int[] values)
    {
        numbers = values;
        int number = values.length;
        helper = new int[number];

        ///System.out.println("START");

        mergesort(0, number - 1);

        //System.out.println("END");
    }

    private static void mergesort(int low, int high)
    {
        // Check if low is smaller then high, if not then the array is sorted
        if (low < high)
        {
            // Get the index of the element which is in the middle
            int middle = (low + high) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
            printArray();
        }
    }

    private static void merge(int low, int middle, int high)
    {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++)
        {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high)
        {
            if (helper[i] <= helper[j])
            {
                numbers[k] = helper[i];
                i++;
            }
            else
            {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }

        // Copy the rest of the left side of the array into the target array
        while (i <= middle)
        {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }

    private static void printArray()
    {
        for(int x : numbers)
            System.out.print(x + " ");

        System.out.println(" ");
    }
}