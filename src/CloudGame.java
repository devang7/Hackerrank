import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CloudGame {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		String s[] = br.readLine().split(" ");
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
		}
		int i = 0;
		int count = 0;
		while(i < n-1)
		{
			int j = i; 
			if(j + 2 >= n)
			{
				i = j + 1;
				count++;
				break;
			}
			if(a[j+1] == 1 && a[j+2] == 0)
			{
				i = j+2;
				count++;
			}
			else if(a[j+1] == 0 && a[j+2] == 1)
			{
				i = j + 1;
				count++;
			}
			else 
			{
				i = j + 2;
				count++;
			}
			          
		}
		System.out.println(count);
		
	}
}
