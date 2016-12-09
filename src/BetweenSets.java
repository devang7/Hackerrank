import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BetweenSets {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		s = br.readLine().split(" ");
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		s = br.readLine().split(" ");
		int b[] = new int[m];
		for(int j = 0; j < m; j++)
		{
			b[j] = Integer.parseInt(s[j]);
		}
		BetweenSets bd = new BetweenSets();
		int x = bd.lcm(a);
		//System.out.println(x);
		int count = 0;
		int mi = bd.min(b);
		while(x < mi)
		{
			int i;
			for(i = 0; i < b.length; i++)
			{
				if(b[i] % x != 0)
					break;
			}
			if(i == b.length)
			{
				count++;
				
			}
			x++;
			
		}
		System.out.println(count);
	}
	public int min(int b[])
	{
		int min = b[0];
		for(int i = 1; i < b.length; i++)
		{
			if(min < b[i])
				min = b[i];
		}
		return min;
	}
	public int lcm(int a[])
	{
		int ans = a[0];
		for(int i = 1; i < a.length; i++)
		{
			ans = (a[i]*ans)/(hcf(a[i],ans));
		}
		return ans;
	}
	public int hcf(int a,int b)
	{
		if(b == 0)
			return a;
		
		return hcf(b,a%b);
		
	}

}
