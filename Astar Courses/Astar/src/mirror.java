import java.util.*;


public class mirror {

    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        // Read in the grid.
        //BufferedReader stdin = new BufferedReader(new FileReader("mirror.in"));
        StringTokenizer tok = new StringTokenizer(sc.nextLine());

        int rows = Integer.parseInt(tok.nextToken());
        int cols = Integer.parseInt(tok.nextToken());

        String[] grid = new String[rows];
        for (int i=0; i<rows; i++)
            grid[i] = sc.nextLine();
        //stdin.close();

        // Try horizontal shots.
        int result = 1;
        for (int i=0; i<rows; i++) {
            result = Math.max(result, sim(grid, i, -1, 0, 1));
            result = Math.max(result, sim(grid, i, cols, 0, -1));
        }

        // Try vertical shots.
        for (int i=0; i<cols; i++) {
            result = Math.max(result, sim(grid, -1, i, 1, 0));
            result = Math.max(result, sim(grid, rows, i, -1, 0));
        }

        // Write out the result.
        System.out.println(result);
        //BufferedWriter fout = new BufferedWriter(new FileWriter("mirror.out"));
        //fout.write(result+"\n");
        //fout.close();
    }

    // Note: +x is going down...
    public static int sim(String[] grid, int x, int y, int dX, int dY) {

        int cnt = 0;

        while (true) {

            // Move the laser beam.
            cnt++;
            x += dX;
            y += dY;

            // Get out!
            if (x<0 || y<0 || x>=grid.length || y>=grid[0].length()) break;

            // This is roughly what happens.
            int newdX = dY;
            int newdY = dX;

            // For this mirror, we switch signs.
            if (grid[x].charAt(y) == '/') {
                newdX = -newdX;
                newdY = -newdY;
            }

            // Now, update direction.
            dX = newdX;
            dY = newdY;
        }

        // Our result.
        return cnt-1;
    }
}
