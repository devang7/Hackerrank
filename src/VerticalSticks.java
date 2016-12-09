import java.io.BufferedReader;
import java.io.InputStreamReader;

public class VerticalSticks {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			int n = Integer.parseInt(br.readLine());
			int a[] = new int[n];
			String s[] = br.readLine().split(" "); 
			for(int i = 0; i < n; i++)
			{
				a[i] = Integer.parseInt(s[i]);
			}
			
			t--;
		}
		
	}

}
