package Day1;

import java.util.ArrayList;
import java.util.Scanner;


public class lepr
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] matrix = new int[N][N];

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                matrix[i][j] = sc.nextInt();
            }
        }

        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();

        for (int i = 0; i < N; i++)
        {
            ArrayList<Integer> row = new ArrayList<>();
            ArrayList<Integer> col = new ArrayList<>();
            ArrayList<Integer> diagOne = new ArrayList<>();
            ArrayList<Integer> diagTwo = new ArrayList<>();

            for (int j = 0; j < N; j++)
            {
                // Rows: i, j
                row.add(matrix[i][j]);

                // Columns: j, i
                col.add(matrix[j][i]);

                // Diagonal 1: i+j, j
                diagOne.add(matrix[(i+j)%N][j]);

                // Diagonal 2: i+j, N-j-1
                diagTwo.add(matrix[(i+j)%N][N-j-1]);

            }

            paths.add(row);
            paths.add(col);
            paths.add(diagOne);
            paths.add(diagTwo);

        }

        int max = Integer.MIN_VALUE;

        for (ArrayList<Integer> list : paths)
        {
            int total = 0;
            for (int j : list)
            {
                total += j;
            }
            if (total > max)
            {
                max = total;
            }

            for (int j = 0; j < N; j++)
            {
                for (int k = j+1; k < N; k++)
                {
                    int sum = 0;

                    for (int l : list.subList(j, k))
                    {
                        sum += l;
                    }

                    if (sum > max)
                    {
                        max = sum;
                    }

                    if (total - sum > max)
                    {
                        max = total - sum;
                    }
                }
            }
        }

        System.out.println(max);
    }

}