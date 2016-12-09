
public class Edit {
	public static void main(String args[])
	{
		String s1 = "sunday";
		String s2 = "saturday";
		System.out.println(Edit.findedit(s1,s2));
	}
	public static int findedit(String x, String y)
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
		for(int i = 0; i < m; i++)
		{
			a[i][0] = i;
		}
		for(int i = 0; i < n; i++)
		{
			a[0][i] = i;
		}
		for(int i = 1; i < m; i++)
		{
			for(int j = 1; j < n; j++)
			{
				if(xc[i] == yc[j])
				{
					a[i][j] = a[i-1][j-1];	
				}
				else
				{
					a[i][j] = Edit.min(a[i-1][j-1],a[i-1][j],a[i][j-1]) + 1;
				}
			}
		}
		for(int i = 0; i < m; i++)
		{
			for(int j = 0; j < n; j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		return a[m-1][n-1];
	}
	public static int min(int a,int b,int c)
	{
		//System.out.println(a+" "+b+" "+c);
		int min = 0;
		if(a < b)
		{
			min = Math.min(a, c);
		}
		else 
		{
			min = Math.min(b,c);
		}
		//System.out.println("min:"+min);
		return min;
	}
}
