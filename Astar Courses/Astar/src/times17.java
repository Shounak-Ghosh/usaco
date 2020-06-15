import java.math.BigInteger;
import java.util.Scanner;

public class times17
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String binaryInput = sc.next();
        BigInteger i = new BigInteger(binaryInput,2);
        i = i.multiply(new BigInteger("17"));
        System.out.print(i.toString(2));


    }
}
