import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Catalan {
	
	public static void main(String args[]) throws Exception
	{
		Catalan cu = new Catalan();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int a[] = new int[2001];
		for(int i = 1; i <= 100;i++)
		{
			a[i] = (a[i-1] % (int)(Math.pow(10, 9)+7) + cu.findNumber(i) % (int)(Math.pow(10, 9)+7)) % (int)(Math.pow(10, 9)+7);
		}
		//System.out.println((int)(Math.pow(10, 9)+7));
		System.out.println(Arrays.toString(a));
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			System.out.println(a[n/2]);
			t--;
		}
		
		//System.out.println(cu.findNumber(100));
	}
	public int findNumber(int n)
	{
		int c = bino(2*n,n);
		return c/(n+1);
	}
	public int bino(int n,int k)
	{
		int res = 1;
		if(k > n - k)
		{
			k = (n - k);
		}
		for(int i = 0; i < k; i++)
		{
		//	System.out.println("n-i:"+(n-i));
			res = (res  % (int)(Math.pow(10, 9)+7) * (n-i)) % (int)(Math.pow(10, 9)+7);
			res = (res  % (int)(Math.pow(10, 9)+7) / (i+1)) % (int)(Math.pow(10, 9)+7);
		}
		//System.out.println(res);
		return res;
	}

}
