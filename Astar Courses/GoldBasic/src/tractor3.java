import java.util.*;

public class tractor3
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);


        int hay = sc.nextInt();
        Deque<Integer> x = new ArrayDeque<>();
        Deque<Integer> y = new ArrayDeque<>();
        Deque<Integer> d = new ArrayDeque<>();
        x.addFirst(sc.nextInt());
        y.addFirst(sc.nextInt());
        d.addFirst(1);
        int max_x = 0, max_y = 0;
        int min_x = 1000, min_y = 1000;
        int[][] field = new int[1005][1005];
        for (int i = 0; i < hay; i++) {
            int hay_x = sc.nextInt();
            int hay_y = sc.nextInt();
            field[hay_x][hay_y] = -1;
            if (hay_x > max_x) max_x = hay_x;
            if (hay_y > max_y) max_y = hay_y;
        }
        max_x++;
        max_y++;

        while (!d.isEmpty())
        {
            int current_x = x.peekFirst();
            int current_y = y.peekFirst();
            int current_d = d.peekFirst();
            x.removeFirst();
            y.removeFirst();
            d.removeFirst();
            field[current_x][current_y] = current_d;

            // Check right
            if (current_x < max_x && field[current_x + 1][current_y] == 0)
            {
                x.addFirst(current_x + 1);
                y.addFirst(current_y);
                d.addFirst(current_d);
                field[current_x + 1][current_y] = current_d;
            }
            else if (current_x < max_x && field[current_x + 1][current_y] == -1)
            {
                x.addLast(current_x + 1);
                y.addLast(current_y);
                d.addLast(current_d + 1);
                field[current_x + 1][current_y] = current_d + 1;
            }

            // Check left
            if (current_x > 0 && field[current_x - 1][current_y] == 0)
            {
                x.addFirst(current_x - 1);
                y.addFirst(current_y);
                d.addFirst(current_d);
                field[current_x - 1][current_y] = current_d;
            }
            else if (current_x > 0 && field[current_x - 1][current_y] == -1)
            {
                x.addLast(current_x - 1);
                y.addLast(current_y);
                d.addLast(current_d + 1);
                field[current_x - 1][current_y] = current_d + 1;
            }

            // Check up
            if (current_y > 0 && field[current_x][current_y - 1] == 0) {
                x.addFirst(current_x);
                y.addFirst(current_y - 1);
                d.addFirst(current_d);
                field[current_x][current_y - 1] = current_d;
            } else if (current_y > 0 && field[current_x][current_y - 1] == -1) {
                x.addLast(current_x);
                y.addLast(current_y - 1);
                d.addLast(current_d + 1);
                field[current_x][current_y - 1] = current_d + 1;
            }

            // Check down
            if (current_y < max_y && field[current_x][current_y + 1] == 0) {
                x.addFirst(current_x);
                y.addFirst(current_y + 1);
                d.addFirst(current_d);
                field[current_x][current_y + 1] = current_d;
            } else if (current_y < max_y && field[current_x][current_y + 1] == -1) {
                x.addLast(current_x);
                y.addLast(current_y + 1);
                d.addLast(current_d + 1);
                field[current_x][current_y + 1] = current_d + 1;
            }

            // Check if finished
            if (current_x == 0 && current_y == 0) {
                System.out.println(field[0][0] - 1);
                System.exit(0);
            }

        }

    }

}