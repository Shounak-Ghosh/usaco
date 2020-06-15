import java.util.Scanner;

public class dna2
{
    public static int numDigits;  // how many digits to be given
    public static int numberLen;  // how long each printed number should be
    public static int[] digits;   // the digits from stdin
    public static int[] indexes;  // stores the index values of each digit
    public static boolean[] mark; // marks whether a digit is usable or not
    public static String[] sequences;
    public static int N, minLength;


    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        numberLen = N;
        numDigits = N;
        digits = new int[N + 1];
        indexes = new int[N + 1];
        mark = new boolean[N + 1];
        for (int i = 0; i < N; i++)
        {
            digits[i] = i;
        }

        sequences = new String[N];
        for (int i = 0; i < N; i++)
        {
            sequences[i] = sc.next();
        }

        genPermutations(0);
    }

    static int min = Integer.MAX_VALUE;
    static String s;
    public static void genPermutations(int pos)
    {
        if(pos == numberLen) // print number if digit length has been reached
        {
            s = "";
            for(int i = 0; i < numberLen; i++)
            {
                //System.out.print(digits[indexes[i] - 1]);
                s += digits[indexes[i] - 1];

            }
            min = Math.min(min,createString(s));
            return;
        }
        for(int i = 1; i <= numDigits; i++)
        {
            if(!mark[i]) // if  a digit is not marked
            {
                indexes[pos] = i; // store the number at the index position
                mark[i] = true; // mark the number
                genPermutations(pos + 1); // generate a new loop
                mark[i] = false; // get rid of the marking
            }
        }
    }

    static char[] indices;
    public static int createString(String permutation)
    {
        indices = permutation.toCharArray();
        String current = sequences[indices[0] - '0'];

        for (int i = 1; i < sequences.length; i++)
        {
            merge(current,sequences[indices[i] - '0']);
        }
        System.out.println(current);
        return current.length();
    }

    public static char[] A;
    public static char[] B;
    public static String merge(String a, String b)
    {
        A = a.toCharArray();
        B = b.toCharArray();
        int pointerA = A.length - 1;
        int pointerB = 0;

        while (a.substring(pointerA).equals(b.substring(0,pointerB)))
        {
            pointerA--;
            pointerB++;
        }

        return a.substring(0,pointerA) + b;
    }
}
