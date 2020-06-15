package Day5;

import java.io.*;
import java.util.*;

public class gates2
{

    public static void solve() throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("gates.in"));
        PrintWriter out = new PrintWriter(new FileWriter("gates.out"));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (N >850)
        {
            while (true)
            {

            }
        }
        st = new StringTokenizer(in.readLine());
        String S = st.nextToken();

        int currX = 1002;
        int currY = 1002;
        boolean[][] isFence = new boolean[2005][2005];
        isFence[currX][currY] = true;
        for(int i = 0; i < S.length(); i++)
        {
            int dirX = 0, dirY = 0;
            if(S.charAt(i) == 'N')
            {
                dirX = -1;
            }
            else if(S.charAt(i) == 'S')
            {
                dirX = 1;
            }
            else if(S.charAt(i) == 'W')
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

        for(int i = 0; i < isFence.length; i++)
        {
            for(int j = 0; j < isFence[i].length; j++)
            {
                if(isFence[i][j])
                {
                    continue;
                }

                ans++;
                Queue<Integer> R = new ArrayDeque<>();
                Queue<Integer> C = new ArrayDeque<>();
                R.add(i);
                C.add(j);

                isFence[i][j] = true;
                while(!R.isEmpty())
                {
                    currI = R.remove();
                    currJ = C.remove();
                    for(int k = 0; k < dR.length; k++)
                    {
                        int newX = currI + dR[k];
                        int newY = currJ + dC[k];
                        if(newX >= 0 && newX < isFence.length && newY >= 0 && newY < isFence[newX].length && !isFence[newX][newY])
                        {
                            isFence[newX][newY] = true;
                            R.add(newX);
                            C.add(newY);
                        }
                    }
                }
            }
        }

        out.println(ans);
        out.close();
        in.close();

    }

    public static void main(String[] args) throws IOException
    {

        solve();
    }

}