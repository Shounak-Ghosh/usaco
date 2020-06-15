public class main
{
    public static void main(String[] args)
    {
        System.out.println(Integer.toBinaryString(1));
        String val = "0000" + Integer.toBinaryString(1);
        val = val.substring(val.length() - 4);
        System.out.println(val);
    }
}

