import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class XorMatrix {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		long m = Long.parseLong(s[1]);
		int a[] = new int[n];
		s = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		long i = 1;
		XorMatrix x = new XorMatrix();
		while(i+2 <= m && i < n)
		{
			a = x.xor(a);
			i = i + 2;
		}
		if(i+1 == m)
		{
			a = x.xor1(a);
			for(int k = 0; k < n; k++)
			{
				System.out.print(a[k]+" ");
			}
		}	
		if(i == m && i < n) 
		{
			for(int k = 0; k < n; k++)
			{
				System.out.print(a[k]+" ");
			}
		}
		if(i >= n)
		{
			for(int k = 0; k < n; k++)
			{
				System.out.print(0 + " ");
			}
		}
		//System.out.println(Arrays.toString(a));
		
	}
	public int[] xor(int a[])
	{
		int n = a.length;
		int temp[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			int j = i;
			temp[i] = a[i] ^ a[(j+2) % n];
		}
		a = temp;
		return a;
	}
	public int[] xor1(int a[])
	{
		int n = a.length;
		int temp[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			temp[i] = a[i] ^ a[(i+1)%n];
		}
		a = temp;
		return a;
	}

}
