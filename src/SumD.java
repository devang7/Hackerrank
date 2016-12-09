import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumD {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[][] = new int[n][n];
		for(int i = 0; i < n; i++)
		{
			String s = br.readLine();
			String si[] = s.split(" ");
			for(int j = 0; j < n; j++)
			{
				a[i][j] = Integer.parseInt(si[j]);
			}	
		}
		int count1 = 0;
		int count2 = 0;
		for(int i = 0, j = 0; i < n; i++,j++)
		{
			count1 += a[i][j];
		}
		for(int i = 0, j = n-1; i < n; i++,j--)
		{
			count2 += a[i][j];
		}
		System.out.println(Math.abs(count1-count2));
	}

}
