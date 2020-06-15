import java.io.*;
//import java.util.*;

class typo {
    public static void main(String[] args) throws IOException
    {

        BufferedReader f = new BufferedReader(new FileReader("typo.in"));


        PrintWriter outf =
                new PrintWriter(new BufferedWriter(new FileWriter("typo.out")));

        String text = f.readLine();

        String[] result = solve(text);

        //doesn't work well with large outputs.
        for (int i = 0; i < result.length; i++) {
            outf.println(result[i]);
        }
        outf.close();
    }

    public static String[] solve(String text) {
        char[] fieldArr = text.toCharArray();
        int result = 0;

        // the string can not be balanced if the length is not even
        // so if the length is odd we skip the testing and return 0 by default.
        if (fieldArr.length % 2 == 0) {
            int openToPoint = 0; // open parentheses to index
            int closedToPoint = 0; // closed parentheses to index

            int depth = 0; // depth is how many levels of parentheses "deep" we are.
            // for example, ((a)b)c, here, a is at depth 2, b is at 1, and c is
            // outside at depth 0. this can be compared to code blocks in
            // programming and how nested they are.

            for (int i = 0; i < fieldArr.length; i ++) {
                if (fieldArr[i] == '(') {
                    openToPoint ++;
                    depth ++;
                } else {
                    closedToPoint ++;
                    depth --;

                }

                if (depth <= 1) {
                    openToPoint = 0;//we are at the top level, so everything at and
                    // before this index is perfectly balanced and does not have an
                    // opportunity to be changed to make it "more" balanced.
                }
                if (depth == -1) {
                    result = closedToPoint;//When the depth is negative
                    // (i.e. above the base level) we have a closing parentheses
                    // that does not close an opening parentheses before it. By swapping any
                    // parentheses before or at this index we can make the depth 0 again.
                    break;
                }

            }

            if (depth > 0) {//if the ending depth is greater than 0, it means that
                // somewhere a opening parentheses should be closed. When we swap it
                // means that the depth is changed by 2, so only the parentheses at
                // a depth of 2 or greater can be swapped.
                result = openToPoint;
            }

        }



        String[] out = new String[1];
        out[0] = Integer.toString(result);
        return out;
    }
}