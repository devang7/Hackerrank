import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CutSticl {
	
	public static void main(String args[]) throws Exception
	{
		CutSticl c = new CutSticl();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s[] = br.readLine().split(" ");
		int a[] = new int[n];
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		a = c.asort(a,0,a.length-1);
		int p = 0;
		int sub = 0;
		while(p < n)
		{
			System.out.println(a.length - p);
			sub = a[p];
			while(p < n && (a[p] - sub) == 0)
			{
				p++;
			}
			for(int i = p; i < n; i++)
			{
				a[i] = a[i] - sub;
			}
		}
		
	}
	public int[] asort(int a[],int s,int e)
	{
		int mid = (s + e)/2;
		int temp1[] = new int[a.length];
		int temp2[];
		if((e-s) <= 1)
		{
			if((e-s) == 0)
			{
				int arr[] = new int[1];
				arr[0] = a[e];
				return arr;
			}
			else
			{
				int abc[] = new int[2];
				if(a[e] <= a[s])
				{
					abc[0] = a[e];
					abc[1] = a[s];
				}
				else
				{
					abc[0] = a[s];
					abc[1] = a[e];
				}
				return abc;
			}
		}
		else
		{
			temp1 = asort(a,s,mid);
			temp2 = asort(a,mid+1,e);
			return merge_a(temp1,temp2);
			
		}
	}
	public int[] merge_a(int a[],int b[])
	{
		int c[] = new int[a.length+b.length];
		int p =0, q = 0;
		int j = 0;
		while(p != a.length && q != b.length)
		{
			if(a[p] <= b[q])
			{
				c[j++] = a[p++];
				
			}
			else
			{
				c[j++] = b[q++];
			}
		}
		if(p == a.length)
		{
			while(q != b.length)
			{
				c[j++] = b[q++];
			}
		}
		else
		{
			while(p != a.length)
			{
				c[j++] = a[p++];
			}
		}
		return c;
	}
}
