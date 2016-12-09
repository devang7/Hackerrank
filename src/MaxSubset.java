import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MaxSubset {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			String s[] = br.readLine().split(" ");
			int a[] = new int[n];
			long count = 0;
			int flag = 0;
			MaxSubset m = new MaxSubset();
			for(int i = 0; i <  s.length; i++)
			{
				a[i] = Integer.parseInt(s[i]);
				if(a[i] > 0)
				{
					flag = 1;
					count += a[i];
				}
			}
			if(flag == 0)
			{
				count = m.findMin(a);
			}
			long c = m.findMax(a);
			System.out.print(c+" ");
			System.out.println(count);
			t--;
		}
		
	}
	public long findMax(int a[])
	{
		long curr_max = a[0];
		long max_far = a[0];
		for(int i = 1; i < a.length; i++)
		{
			curr_max = Math.max(a[i], curr_max + a[i]);
			max_far = Math.max(max_far, curr_max);
		}
		return max_far;
	}
	
	public int findMin(int a[])
	{
		//System.out.println("min");
		int min = Integer.MIN_VALUE;
		for(int i = 0; i < a.length; i++)
		{
			if(a[i] > min)
			{
				min = a[i];
			}
		}
		return min;
	}

}
