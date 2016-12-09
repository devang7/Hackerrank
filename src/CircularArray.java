import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CircularArray {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int q = Integer.parseInt(s[2]);
		int a[] = new int[n];
		int c[] = new int[n];
		int query[] = new int[q];
		
		String si[] = br.readLine().split(" ");
		for(int m = 0; m < q; m++)
		{
			query[m] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(si[i]);
		}
		k = k % n;
		
		int j = k;
		int i = 0;
		while(i != n)
		{
			c[j] = a[i];
			i++;
			j = (j+1) % n;
		}
		for(int l = 0 ; l < q; l++)
		{
			System.out.println(c[query[l]]);
		}
		
	}
}
