import java.util.*;
import java.io.*;


public class mirrors
{
    static Map<Integer, TreeMap<Integer, Integer>> H = map();
    static Map<Integer, TreeMap<Integer, Integer>> V = map();
    static void add(int x, int y, int val) {
        if(!V.containsKey(x)) V.put(x, map());
        if(!H.containsKey(y)) H.put(y, map());
        H.get(y).put(x, val);
        V.get(x).put(y, val);
    }
    static PrintWriter out = null;

    static TreeMap map() { return new TreeMap(); }
    static void done(int exit)
    {
        out.println(exit);
        out.flush();
        System.exit(0);
    }
    enum D { N,E,S,W;
        D m0() {
            switch(this) {
                case N: return E;
                case E: return N;
                case S: return W;
                case W: return S;
            }
            return null;
        }
        D m1() {
            switch(this){
                case N: return W;
                case W: return N;
                case S: return E;
                case E: return S;
            }
            return null;
        }
    }
    static boolean ok() {
        Set<int[]> seen = new TreeSet<int[]>(new
                                                     Comparator<int[]>() {
                                                         public int compare(int[] A, int[] B) {
                                                             if(A[0]!=B[0]) return A[0]-B[0];
                                                             if(A[1]!=B[1]) return A[1]-B[1];
                                                             if(A[2]!=B[2]) return A[2]-B[2];
                                                             return 0;
                                                         }
                                                     });
        Integer x = 0;
        Integer y = 0;
        D d = D.E;
        while(true) {
            if(seen.contains(new int[]{x,y,d.ordinal()})) return false;
            seen.add(new int[]{x,y,d.ordinal()});
            switch(d) {
                case N: y = V.get(x).higherKey(y); break;
                case E: x = H.get(y).higherKey(x); break;
                case S: y = V.get(x).lowerKey(y); break;
                case W: x = H.get(y).lowerKey(x); break;
            }
            if(x==null || y==null) return false;
            int val = H.get(y).get(x);
            if(val == 2) return true;
            if(val == 0) d = d.m0();
            if(val == 1) d = d.m1();
        }
    }

    public static void main(String[] args) throws Exception
    {
        Scanner in = new Scanner(new FileReader("mirrors.in"));
        out = new PrintWriter(new BufferedWriter(new
                FileWriter("mirrors.out")));
        int n = in.nextInt();
        int X = in.nextInt();
        int Y = in.nextInt();
        H.put(0, map());
        V.put(0, map());
        add(X, Y, 2);
        int[][] P = new int[n][3];
        for(int i=0; i<n; i++) {
            P[i] = new int[]{in.nextInt(), in.nextInt(), in.next().equals("/")
                    ? 0 : 1};
            add(P[i][0], P[i][1], P[i][2]);
        }
        if(ok()) done(0);
        for(int i=0; i<n; i++) {
            add(P[i][0], P[i][1], 1-P[i][2]);
            if(ok()) done(i+1);
            add(P[i][0], P[i][1], P[i][2]);
        }
        done(-1);
    }
}