import java.io.BufferedReader;
import java.io.InputStreamReader;

public class divisible {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String b[] = br.readLine().split(" ");
		int n = Integer.parseInt(b[0]);
		int k = Integer.parseInt(b[1]);
		int a[] = new int[n];
		String s[] = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		int count = 0;
		for(int i = 0; i < n; i++)
		{
			for(int j = i+1; j < n; j++)
			{
				if((a[i] + a[j]) % k == 0)
				{
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
