import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepeatedStrings {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		char a[] = s.toCharArray();
		int count = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(a[i] == 'a')
				count++;
		}
		long k = Long.parseLong(br.readLine());
		long d = k / s.length();
		long r = d * count;
		long closest = k - d*s.length();
		//System.out.println(closest);
		for(int i = 0; i < closest; i++)
		{
			if(a[i] == 'a')
				r++;
		}
		System.out.println(r);
		
		
	}
}
