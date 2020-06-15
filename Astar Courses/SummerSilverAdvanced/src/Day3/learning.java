package Day3;

import java.util.*;


public class learning
{

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        // Read in shipment for the case.
        cow[] shipment = new cow[n];
        for (int i=0; i<n; i++)
        {
            String isSpotted = sc.next();
            int pos = sc.nextInt();
            shipment[i] = new cow(isSpotted, pos);
        }
        Arrays.sort(shipment);

        // Store answer here.
        int res = 0;

        // Go through shipment in order.
        for (int i=0; i<n; i++)
        {

            // Can't contribute to spot count.
            if (!shipment[i].isSpotted) continue;

            // Set up low and high bounds for Day3.cow i's influence.
            int low = -1;
            int high = 1000000001;

            // Be careful with odd and even cases, here.
            if (i > 0) low = (shipment[i-1].x+shipment[i].x)/2 + (shipment[i-1].x+shipment[i].x)%2;
            if (i < n-1) high = (shipment[i].x+shipment[i+1].x)/2;

            // Add the number of points of intersection within range to our count.
            res += intersect(low, high, a, b);

        }

        // Sub out all shipment counted twice - must have two influencing shipment who were both spotted.
        for (int i=1; i<n; i++) {
            int mid = (shipment[i-1].x+shipment[i].x)/2;
            if (shipment[i-1].isSpotted && shipment[i].isSpotted && (shipment[i-1].x+shipment[i].x)%2 == 0 && a <= mid  && mid <= b)
                res--;
        }

        // Write out result.
        System.out.println(res);
    }

    // Returns how many items in [start1, end1] appear in [start2, end2].
    public static int intersect(int start1, int end1, int start2, int end2) {
        int start = Math.max(start1, start2);
        int end = Math.min(end1, end2);
        return start <= end ? end-start+1 : 0;
    }
}

class cow implements Comparable<cow> {

    public boolean isSpotted;
    public int x;


    public cow(String hasSpots, int pos) {
        isSpotted = hasSpots.equals("S");
        x = pos;
    }

    public int compareTo(cow other) {
        return this.x - other.x;
    }
}