import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockAndCast {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			int max = 0; 
			String s[] = br.readLine().split(" ");
			for(int i = 0; i < n; i++)
			{
				a[i] = Integer.parseInt(s[i]);
				if(a[i] > max)
					max = a[i];
			}
			int mem[][] = new int[max+1][n];
			for(int i = 0; i < max+1; i++)
			{
				for(int j = 0; j < n; j++)
				{
					mem[i][j] = Integer.MIN_VALUE;
				}
			}
			for(int i = 0; i < max+1; i++)
			{
				if(i <= a[0])
					mem[i][0] = 0;
			}
			for(int i = 0; i < n; i++)
			{
				mem[0][i] = 0;
			}
			for(int j = 1; j < n; j++)
			{
				int k = 1;
				int count = 1;
				while(count <= 2)
				{
					count++;
					int max1 = Integer.MIN_VALUE;
					for(int i = 1; i < max+1; i++)
					{
						int ti = Math.abs(k-i)+mem[i][j-1];
						if(ti > max1)
							max1 = ti;
					}
					mem[k][j] = max1;
					k = a[j];
				}	
					
			}
			/*for(int i = 0; i < max+1; i++)
			{
				for(int j = 0; j < n; j++)
				{
					System.out.print(mem[i][j]+" ");
				}
				System.out.println();
			}*/
			int maxf = Integer.MIN_VALUE;
			for(int i = 0; i < max+1; i++)
			{
				if(mem[i][n-1] > maxf)
					maxf = mem[i][n-1];
			}
			System.out.println(maxf);
			t--;
		}
	}

}
