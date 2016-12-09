import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DPCandies {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(br.readLine());
		}
		long b[] = new long[n];
		b[0] = 1;
		for(int i = 1; i < n; i++)
		{
			
			if(a[i] > a[i-1])
			{
				b[i] = b[i-1] + 1;
			}
			else
			{
				if(a[i-1] == a[i])
					b[i] = 1;
				else if(b[i-1] != 1)
					b[i] = 1;
				else
				{
					
					b[i] = 1;
					int j = i-1;
					while(j >= 0 && b[j] == b[j+1] && a[j] > a[j+1])
					{
						b[j]++;
						j--;
					}
					
				}
			}
		//	System.out.println("i:"+i+" "+Arrays.toString(b));
		}
		System.out.println(Arrays.toString(b));
		long sum = 0;
		for(int i = 0; i <  n; i++)
		{
			sum += b[i];
		}
		System.out.println(sum);
	}
	

}
