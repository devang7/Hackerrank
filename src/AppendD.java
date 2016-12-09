import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppendD {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String t = br.readLine();
		int k = Integer.parseInt(br.readLine());
		if(k >= s.length() + t.length())
		{
			System.out.println("YES");
		}
		else
		{
			//find common count
			int count = 0;
			for(int i = 0, j = 0; i < s.length() && j < t.length(); i++,j++)
			{
				if(s.charAt(i) == t.charAt(j))
					count++;
				else
				{
					break;
				}
			}
			int min = (s.length() - count) + (t.length() - count);
			if(k < min)
			{
				System.out.println("NO");
			}
			else
			{
				int x = min;
				while(x < s.length() + t.length())
				{
					if(x == k)
					{
						break;
					}
					x = x+2;
				}
				if(x < s.length() + t.length())
				{
					System.out.println("YES");
				}
				else
				{
					System.out.println("NO");
				}
			}
				
		}
	}

}
