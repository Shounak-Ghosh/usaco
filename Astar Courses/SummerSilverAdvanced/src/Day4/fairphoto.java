package Day4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;


public class fairphoto
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter w = new PrintWriter(System.out);

        //BufferedReader in = new BufferedReader(new FileReader("Day4.fairphoto.in"));
        //PrintWriter w = new PrintWriter(new BufferedWriter(new FileWriter("Day4.fairphoto.out")));

        int N = Integer.parseInt(in.readLine());

        Cow[] cows = new Cow[N];

        for (int i = 0; i < N; i++) {
            String[] inputs = in.readLine().split(" ");
            cows[i] = new Cow(Integer.parseInt(inputs[0]), inputs[1].equals("S"));
        }

        Arrays.sort(cows);

        int whiteCount = 0;
        int spotCount = 0;
        int[] whitesTo = new int[N];
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                if (cows[i].spots) {
                    whitesTo[i]--;
                } else {
                    whitesTo[i]++;
                }
            } else {
                whitesTo[i] = whitesTo[i - 1];
                if (cows[i].spots)
                {
                    whitesTo[i]--;
                } else {
                    whitesTo[i]++;
                }
            }
        }

        int maxSize = 0;
        int whites = whiteCount;
        int spots = spotCount;

        outer:
        for (int i = 0; i < N; i++) {
            int innerSpots = spots;
            int innerWhites = whites;
            for (int j = N - 1; j >= i + 1; j--) {
                if ((j - i) % 2 == 1) { //we have even number of cows since we include cows i and j;
                    //if number of white cows >= number of spotted cows;
                    if (innerWhites >= innerSpots) { //valid ding ding ding ding ding
                        if (cows[j].x - cows[i].x > maxSize) {
                            maxSize = cows[j].x - cows[i].x;
                        }
                    } else {
                        if (cows[i].spots) {
                            spots--;
                        } else {
                            whites--;
                        }
                        continue outer;
                    }
                }
                if (cows[j].spots) {
                    innerSpots--;
                } else {
                    innerWhites--;
                }
            }
            if (cows[i].spots) {
                spots--;
            } else {
                whites--;
            }
        }

        w.println(maxSize);
        w.flush();
    }

    public static class Cow implements Comparable<Cow> {
        int x;
        boolean spots;

        public Cow(int x, boolean s) {
            this.x = x;
            spots = s;
        }

        public int compareTo(Cow c) {
            return x - c.x;
        }
    }

}