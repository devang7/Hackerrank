import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class UniquePrime {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		UniquePrime s = new UniquePrime();
		int q = Integer.parseInt(br.readLine());
		while(q != 0)
		{
			long n = Long.parseLong(br.readLine());
			if(n == 1)
			{
				System.out.println(0);
			}
			else
			{
				long x = 1;
				int count = 0;
				int p[] = s.primen(55);
				for(int i = 0; i < p.length; i++)
				{
					x = x*p[i];
					if(x <= n)
						count++;
					else
						break;
					
				}
				System.out.println(count);
			}
		
			q--;
		}
		
	}
	public int[] primen(int n)
	{
		int arr[] = new int[n];
		arr[0] = 1;
		arr[1] = 1;
		for(int i = 2; i <= Math.sqrt(55); i++)
		{
			if(arr[i] == 0)
			{
				for(int j = i*i; j < 55; j = j + i)
				{
					arr[j] = 1;
				}
			}	
		}
		int p[] = new int[20];
		int l = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == 0)
			{
				p[l++] = i;
			}
		}
		return p;
	}
}
