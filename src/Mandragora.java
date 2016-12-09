import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mandragora {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String s[] = br.readLine().split(" ");
			for(int i = 0; i < n; i++)
			{
				a[i] = Integer.parseInt(s[i]);
			}
			Arrays.sort(a);
			Mandragora m = new Mandragora();
			int r[][] = new int[a.length+1][a.length];
			for(int i = 0; i < a.length+1; i++)
			{
				for(int j = 0; j < a.length; j++)
				{
					r[i][j] = -1;
				}
			}
			System.out.println(m.bk(a,1,0,r));
			t--;
		}
		
		
	}
	public int bk(int a[],int s,int j,int r[][])
	{
		//System.out.println(s+" "+j);
		if(r[s][j] >= 0)
		{
			//System.out.println("Dp");
			return r[s][j];
		}
		if(j == a.length - 1)
		{
			r[s][j] = s*a[j];
			return s*a[j];
		}
		else
		{
			int p = Math.max(s*a[j] + bk(a,s,j+1,r), bk(a,s+1,j+1,r));
			r[s][j] = p;
			//printl(r);
			return p;
		}
		
	}
	public void printl(int a[][])
	{
		for(int i = 0; i < a.length; i++)
		{
			System.out.println(Arrays.toString(a[i]));
		}
		System.out.println();
	}
}
