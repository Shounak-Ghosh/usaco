import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class digits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        String baseTwo = sc.next();
        String baseThree = sc.next();

//        System.out.println(baseTwoPossibilities("" + baseTwo));
//        System.out.println(baseThreePossibilities("" + baseThree));

        ArrayList<String> baseTwoOptions = baseTwoPossibilities("" + baseTwo);
        ArrayList<String> baseThreeOptions = baseThreePossibilities("" + baseThree);

        BigInteger base3Decimal;
        BigInteger base2Decimal;

        outerloop:
        for(String base3: baseThreeOptions)
        {
            base3Decimal = new BigInteger(base3,3);
            for (String base2: baseTwoOptions)
            {
                base2Decimal = new BigInteger(base2,2);
                if(base3Decimal.equals(base2Decimal))
                {
                    System.out.println(base3Decimal);
                    break outerloop;
                }
            }
        }


    }

    public static ArrayList<String> baseTwoPossibilities(String num)
    {
        ArrayList<String> options = new ArrayList<>();

        for(int i = 0; i < num.length(); i++)
        {
            if(num.substring(i,i + 1).equals("1"))
            {
                options.add(num.substring(0,i) + "0" + num.substring(i + 1));
            }

            if(num.substring(i,i + 1).equals("0"))
            {
                options.add(num.substring(0,i) + "1" + num.substring(i + 1));
            }
        }

        return options;
    }

    public static ArrayList<String> baseThreePossibilities(String num)
    {
        ArrayList<String> options = new ArrayList<>();

        for(int i = 0; i < num.length(); i++)
        {
            if(num.substring(i,i + 1).equals("0"))
            {
                options.add(num.substring(0,i) + "1" + num.substring(i + 1));
                options.add(num.substring(0,i) + "2" + num.substring(i + 1));
            }

            if(num.substring(i,i + 1).equals("1"))
            {
                options.add(num.substring(0,i) + "0" + num.substring(i + 1));
                options.add(num.substring(0,i) + "2" + num.substring(i + 1));
            }

            if(num.substring(i,i + 1).equals("2"))
            {
                options.add(num.substring(0,i) + "1" + num.substring(i + 1));
                options.add(num.substring(0,i) + "0" + num.substring(i + 1));
            }
        }

        return options;
    }


}
