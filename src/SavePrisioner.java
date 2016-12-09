import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SavePrisioner {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int st = Integer.parseInt(s[2]);
			if(m == 1 && n == 1)
			{
				System.out.println("1");
			}
			else
			{
				m = m % n;
				int end = n - st + 1;
				int ans = 0;
				if(m <= end)
				{
					ans = st + m - 1;
				}
				else
				{
					ans = m - end;
				}
				if(ans != 0)
					System.out.println(ans);
				else
					System.out.println(n);
		
			}
			t--;
		}
	}

}
