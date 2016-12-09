import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SherlockArr {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			int front[] = new int[n];
			int back[] = new int[n];
			int a[] = new int[n];
			String s[] = br.readLine().split(" ");
			for(int i = 0; i < n; i++)
			{
				a[i] = Integer.parseInt(s[i]);
			}
			front[0] = a[0];
			for(int i = 1; i < n; i++)
			{
				front[i] = a[i]+front[i-1];
			}
			back[n-1] = a[n-1];
			for(int j = n-2; j >=0; j--)
			{
				back[j] = back[j+1]+a[j];
			}
			int sum = 0,sum1 = 0,sum2 = 0;
			int i = 0;
			for(i = 0; i < n; i++)
			{
				if(i - 1 >= 0)
					sum1 = front[i-1];	
				else
					sum1 = 0;
				if(i+1 < n)
					sum2 = back[i+1];
				else
					sum2 = 0;
				if(sum1 == sum2)
				{
					sum = sum1;
					break;
				}
					
			}
			if(i == n)
				System.out.println("NO");
			else
				System.out.println("YES");
			t--;
			
		}
	}

}
