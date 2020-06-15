import java.io.*;
import java.util.*;

public class milk3
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());
        in.close();

        int aCap = Integer.parseInt(st.nextToken());
        int bCap = Integer.parseInt(st.nextToken());
        int cCap = Integer.parseInt(st.nextToken());
        int aVal = 0;
        int bVal = 0;
        int cVal = cCap;
        boolean[] temp = new boolean[cCap+1];
        boolean[][][][] checked = new boolean[aCap+1][bCap+1][cCap+1][6];
        for (int i = 0; i < checked.length; i++)
        {
            for (int j = 0; j < checked[0].length; j++)
            {
                for (int k = 0; k < checked[0][0].length; k++)
                {
                    Arrays.fill(checked[i][j][k], false);
                }
            }
        }

        temp = solve(aVal, bVal, cVal, aCap, bCap, cCap, 0, 0, temp, checked);
        boolean everTrue = false;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]) {
                out.print(i);
                everTrue=true;
                if(i<temp.length-1) {
                    out.print(" ");
                }
            }
        }
        if(!everTrue)
        {
            out.print("NONE");
        }
        out.println();
        out.close();
        //long endTime = System.nanoTime();
        //System.out.println((endTime-startTime)/1000000000.0);
    }

    public static boolean[] solve(int aVal, int bVal, int cVal, int aCap, int bCap, int cCap, int times, int which, boolean[] temp, boolean[][][][] checked) {
        if (!checked[aVal][bVal][cVal][which]) {
            if (times == 0) {
                if (aVal == 0) {
                    temp[cVal]=true;
                }
                for (int i = 0; i < 6; i++) {
                    temp=solve(aVal, bVal, cVal, aCap, bCap, cCap, times + 1, i, temp, checked);
                }
            } else if (times < cCap && aVal >= 0 && cVal >= 0 && bVal >= 0 && cCap - cVal >= 0 && aCap - aVal >= 0 && bCap - bVal >= 0) {
                if (which == 0) {
                    //cVal->aVal
                    if (aCap>=aVal+cVal) {
                        aVal+=cVal;
                        cVal=0;
                    } else {
                        cVal-=aCap-aVal;
                        aVal=aCap;
                    }
                } else if (which == 1) {
                    //cVal->bVal
                    if (bCap>=bVal+cVal) {
                        bVal+=cVal;
                        cVal=0;
                    } else {
                        cVal-=bCap-bVal;
                        bVal=bCap;
                    }
                } else if (which == 2) {
                    //aVal->cVal
                    if (cCap>=cVal+aVal) {
                        cVal+=aVal;
                        aVal=0;
                    } else {
                        aVal-=cCap-cVal;
                        cVal=cCap;
                    }
                } else if (which == 3) {
                    //aVal->bVal
                    if (bCap>=bVal+aVal) {
                        bVal+=aVal;
                        aVal=0;
                    } else {
                        aVal-=bCap-bVal;
                        bVal=bCap;
                    }
                } else if (which == 4) {
                    //bVal->cVal
                    if (cCap>=cVal+bVal) {
                        cVal+=bVal;
                        bVal=0;
                    } else {
                        bVal-=cCap-cVal;
                        cVal=cCap;
                    }
                } else if (which == 5) {
                    //bVal->aVal
                    if (aCap>=aVal+bVal) {
                        aVal+=bVal;
                        bVal=0;
                    } else {
                        bVal-=aCap-aVal;
                        aVal=aCap;
                    }
                } else {
                    return temp;
                }
                int[] linked = new int[] {2, 4, 0, 5, 1, 3};
                if (aVal == 0) {
                    temp[cVal]=true;
                }
                for (int i = 0; i < 6; i++) {
                    if (i!=which && i!=linked[which])
                        temp = solve(aVal, bVal, cVal, aCap, bCap, cCap, times + 1, i, temp, checked);
                }
            } else {
                return temp;
            }
        }
        checked[aVal][bVal][cVal][which]=true;
        return temp;
    }
}