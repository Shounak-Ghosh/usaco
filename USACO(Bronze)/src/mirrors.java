import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class mirrors
{
    static char[][] matrix;
    static fence[] mirrors;
    static int numFences;
    static int barnRow;
    static int barnCol;
    static int row;
    static int col;
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("mirrors.in"));
        PrintWriter outf = new PrintWriter(new File("mirrors.out"));

        StringTokenizer st = new StringTokenizer(f.readLine());
        numFences = Integer.parseInt(st.nextToken());
        barnRow = Integer.parseInt(st.nextToken());
        barnCol = Integer.parseInt(st.nextToken());
        int colMin = 0;
        int rowMin = 0;
        int rowMax = 0;
        int colMax = 0;

        mirrors = new fence[numFences];
        for(int i = 0; i < numFences; i++)
        {
            st = new StringTokenizer(f.readLine());
            mirrors[i] = new fence(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),st.nextToken().charAt(0));
            rowMin = Math.min(rowMin,mirrors[i].row);
            colMin = Math.min(colMin,mirrors[i].col);
            rowMax = Math.max(rowMax,mirrors[i].row);
            colMax = Math.max(colMax,mirrors[i].col);
        }

        if(rowMin < 0 || colMin < 0)
        {
            rowMin = -rowMin;
            colMin = -colMin;
            for(int i = 0; i < mirrors.length; i++)
            {
                mirrors[i].row += rowMin;
                mirrors[i].col += colMin;
                rowMax = Math.max(rowMax,mirrors[i].row);
                colMax = Math.max(colMax,mirrors[i].col);
            }
            barnRow += rowMin;
            barnCol += colMin;
        }

        rowMax = Math.max(rowMax,barnRow);
        colMax = Math.max(colMax,barnCol);

        matrix = new char[colMax + 1][rowMax + 1];

        for(fence mirror : mirrors)
        {
            matrix[matrix.length - 1 - mirror.col][mirror.row] = mirror.type;
        }

        //System.out.println("ORIGINAL");
        /*
        for(char[] m : matrix)
        {
            System.out.println(Arrays.toString(m));
        }

        System.out.println(Arrays.toString(mirrors));

        System.out.println(rowMax + " " + colMax);
        */

        int index = -1;

        //System.out.println(rowMin + " " + colMin);
        //System.out.println(row + " " + col);

        matrix[matrix.length - barnCol - 1][barnRow] = '*';

        row = matrix.length - 1 - colMin;
        col = rowMin;

        if(!look())
        {
            for (int i = 0; i < numFences; i++)
            {
                row = matrix.length - 1 - colMin;
                col = rowMin;
                //System.out.println(row + " " + col);
                toggle(i);
                if(look())
                {
                    index = i + 1;
                    break;
                }
                /*System.out.println("\n" + (i + 1));
                for(char[] m : matrix)
                {
                    System.out.println(Arrays.toString(m));
                }*/

                untoggle(i);
            }
        }
        else {index = 0;}
        outf.println(index);


        f.close();
        outf.close();
    }

    public static boolean look()
    {
        char direction = 'R';

        while (isValid())
        {
            /*char temp = matrix[row][col];
            matrix[row][col] = 'X';
            for(char[] m : matrix)
            {
                System.out.println(Arrays.toString(m));
            }
            matrix[row][col] = temp;
            System.out.println("(" +(matrix.length - 1 - row) + ", " + col+") " + direction);*/
            if(direction == 'R' && !(matrix[row][col] == '/' || matrix[row][col] == '\\'))
            {
                col++;
            }
            else if(direction == 'L' && !(matrix[row][col] == '/' || matrix[row][col] == '\\'))
            {
                col--;
            }
            else if(direction == 'U' && !(matrix[row][col] == '/' || matrix[row][col] == '\\'))
            {
                row--;
            }
            else if(direction == 'D' && !(matrix[row][col] == '/' || matrix[row][col] == '\\'))
            {
                row++;
            }
            if(isValid())
            {
                if (matrix[row][col] == '/' && direction == 'R')
                {
                    direction = 'U';
                    row--;
                } else if (matrix[row][col] == '/' && direction == 'L')
                {
                    direction = 'D';
                    row++;
                } else if (matrix[row][col] == '/' && direction == 'U') {
                    direction = 'R';
                    col++;
                } else if (matrix[row][col] == '/' && direction == 'D') {
                    direction = 'L';
                    col--;
                } else if (matrix[row][col] == '\\' && direction == 'R') {
                    direction = 'D';
                    row++;
                } else if (matrix[row][col] == '\\' && direction == 'L') {
                    direction = 'U';
                    row--;
                } else if (matrix[row][col] == '\\' && direction == 'U') {
                    direction = 'L';
                    col--;
                } else if (matrix[row][col] == '\\' && direction == 'D') {
                    direction = 'R';
                    col++;
                }
            }
            if (isValid())
            {
                if (matrix[row][col] == '*') {
                    return true;
                }
            }
        }
        return  false;

    }

    public static void toggle(int i)
    {
        int r = matrix.length - 1 - mirrors[i].col;
        int c = mirrors[i].row;

        if(mirrors[i].type == '/')
        {
            matrix[r][c] = '\\';
        }
        else
        {
            matrix[r][c] = '/';
        }
    }

    public static void untoggle(int i)
    {
        int r = matrix.length - 1 - mirrors[i].col;
        int c = mirrors[i].row;
        matrix[r][c] = mirrors[i].type;
    }

    public static boolean isValid()
    {
        return row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length;
    }


}




class fence
{
    int row;
    int col;
    char type;

    public fence(int r, int c, char t)
    {
        row = r;
        col = c;
        type = t;
    }

    public String toString()
    {
        return row + " " + col + " " + type;
    }
}

