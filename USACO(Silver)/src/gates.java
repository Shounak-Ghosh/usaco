import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class gates
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new FileReader("gates.in"));
        PrintWriter outf = new PrintWriter(new FileWriter("gates.out"));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int N = Integer.parseInt(st.nextToken());
//        if (N > 850)
//        {
//            while (true)
//            {
//
//            }
//        }
        st = new StringTokenizer(f.readLine());
        String dir = st.nextToken();

        int currX = 1002;
        int currY = 1002;

        int dirX = 0;
        int dirY = 0;
        boolean[][] isFence = new boolean[2005][2005];
        for (int i = 0; i < dir.length(); i++)
        {
            if(dir.charAt(i) == 'N')
            {
                dirX = -1;
            }
            else if(dir.charAt(i) == 'S')
            {
                dirX = 1;
            }
            else if(dir.charAt(i) == 'W')
            {
                dirY = -1;
            }
            else {
                dirY = 1;
            }

            for(int a = 0; a < 2; a++)
            {
                 currX += dirX;
                currY += dirY;
                isFence[currX][currY] = true;
            }
        }

        int ans = -1;
        int[] dR = {-1,1,0,0};
        int[] dC = {0,0,-1,1};
        int currI = 0;
        int currJ = 0;


        for (int i = 0; i < isFence.length; i++)
        {
            for (int j = 0; j < isFence[i].length; j++)
            {
                if (isFence[i][j])
                {
                   continue;
                }
                ans++;
                Queue<Integer> R = new ArrayDeque<>();
                Queue<Integer> C = new ArrayDeque<>();
                R.add(i);
                C.add(j);
                isFence[i][j] = true;


                while (!R.isEmpty())
                {
                    currI = R.remove();
                    currJ = C.remove();

                    for (int k = 0; k < dR.length; k++)
                    {
                        int nX = currI + dR[k];
                        int nY = currJ + dC[k];

                        if (nX >= 0 && nX < isFence.length && nY >= 0 && nY < isFence[0].length && !isFence[nX][nY])
                        {
                            R.add(nX);
                            C.add(nY);
                            isFence[nX][nY] = true;
                        }
                    }
                }
            }
        }
        outf.println(ans + 1);
        outf.close();
        f.close();
    }
}
