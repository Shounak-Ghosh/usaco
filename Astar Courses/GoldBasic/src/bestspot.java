import java.util.Scanner;

public class bestspot
{
    static int p,f,c,best;
    static int[][] mat;
    static int[] favorite;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        p = sc.nextInt();
        f = sc.nextInt();
        c = sc.nextInt();

        favorite = new int[500];
        mat = new int[500][500];
        for (int i = 0; i < f; i++)
        {
            favorite[i] = sc.nextInt();
        }

        int a, b, d;

        for (int i = 0; i < c; i++)
        {
            a = sc.nextInt() - 1;
            b = sc.nextInt() - 1;
            d = sc.nextInt();
            mat[a][b] = d;
            mat[b][a] = d;
        }

        for (int i=0; i<p; i++)
            for (int j=0; j<p; j++)
                if (mat[j][i] != 0)
                    for (int k=0; k<p; k++)
                        if (mat[i][k] != 0 && (mat[j][k] == 0 || mat[j][k]>mat[j][i]+mat[i][k]))
                            mat[j][k]=mat[j][i]+mat[i][k];
        for (int i=0; i<p; i++) mat[i][i]=0;

        // find best pasture
        int bestsum=1000000000;
        for (int i=0; i<p; i++)
        {
            // calculate the total distance
            //	from the current pasture to favourite pastures
            int sum=0;
            for (int j=0; j<f; sum+=mat[i][favorite[j++]]);
            if (bestsum>sum)
            {
                bestsum = sum;
                best = i + 1;
            }
        }

        System.out.println(best);
    }
}

/*
using namespace std;

#define MAX 500

int p,mat[MAX][MAX],f,favorite[MAX],best;

// read file
void fRead()
{
	int c;
	ifstream fl("bestspot.in");
	fl >> p >> f >> c;
	// read favourite pastures
	for (int i=0; i<f; favorite[i++]--)
		fl >> favorite[i];
	int a,b,d;
	// read cowpaths
	for (int i=0; i<c; i++)
	{
		fl >> a >> b >> d;
		mat[--a][--b]=d,mat[b][a]=d;
	}
	fl.close();
}

// write file
void fWrite()
{
	ofstream fl("bestspot.out");
	fl << best << "\n";
	fl.close();
}

void solve()
{
	// Floyd-Warshall all shortest path
	for (int i=0; i<p; i++)
		for (int j=0; j<p; j++)
			if (mat[j][i])
				for (int k=0; k<p; k++)
					if (mat[i][k] && (!mat[j][k] || mat[j][k]>mat[j][i]+mat[i][k]))
							mat[j][k]=mat[j][i]+mat[i][k];
	for (int i=0; i<p; i++) mat[i][i]=0;

	// find best pasture
	int bestsum=1000000000;
	for (int i=0; i<p; i++)
	{
		// calculate the total distance
		//	from the current pasture to favourite pastures
		int sum=0;
		for (int j=0; j<f; sum+=mat[i][favorite[j++]]);
		if (bestsum>sum) bestsum=sum,best=i+1;	// update if it is a better pasture
	}
}

int main(void)
{
	fRead();
	solve();
	fWrite();
}
 */