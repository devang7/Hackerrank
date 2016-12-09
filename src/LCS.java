
public class LCS {
	
	public static void main(String args[])
	{
		String s1 = "10010101";
		String s2 = "010110110";
		System.out.println(LCS.findlcs(s1,s2));
	}
	public static int findlcs(String x, String y)
	{
		String s = " ";
		x = s + x;
		y = s + y;
		int m = x.length();
		int n = y.length();
		char xc[] = x.toCharArray();
		char yc[] = y.toCharArray();
		//System.out.println(xc.length);
		int a[][] = new int[m][n];
		int b[][] = new int[m][n];
		for(int i = 0; i < m; i++)
		{
			a[i][0] = 0;
		}
		for(int i = 0; i < n; i++)
		{
			a[0][i] = 0;
		}
		for(int i = 1; i < m; i++)
		{
			for(int j = 1; j < n; j++)
			{
				if(xc[i] == yc[j])
				{
					a[i][j] = a[i-1][j-1] + 1;
					b[i][j] = 1;
				}
				else if(a[i-1][j] >= a[i][j-1])
				{
					a[i][j] = a[i-1][j];
					b[i][j] = 2;
				}
				else
				{
					a[i][j] = a[i][j-1];
					b[i][j] = 3;
				}
			}
		}
		int i = m-1;
		int j = n-1;
		String t = new String();
		while(i != 0 && j != 0)
		{
			//System.out.println(b[i][j]);
			if(b[i][j] == 1)
			{
				t += Character.toString(xc[i]);
				i = i - 1;
				j = j - 1;
			}
			else if(b[i][j] == 2)
			{
				i = i - 1;
			}
			else
			{
				j = j - 1;
			}
		}
		StringBuilder f = new StringBuilder(t);
		System.out.println(f.reverse());
		return a[m-1][n-1];
	}

}
