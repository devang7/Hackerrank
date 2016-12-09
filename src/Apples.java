import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Apples {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String r[] = br.readLine().split(" ");
		int s = Integer.parseInt(r[0]);
		int t = Integer.parseInt(r[1]);
		r = br.readLine().split(" ");
		int a = Integer.parseInt(r[0]);
		int b = Integer.parseInt(r[1]);
		r = br.readLine().split(" ");
		int m = Integer.parseInt(r[0]);
		int n = Integer.parseInt(r[1]);
		r = br.readLine().split(" ");
		int counter = 0;
		for(int i = 0; i < m; i++)
		{
			int q = Integer.parseInt(r[i]);
			if(q + a >= s && q + a <= t)
			{
				counter++;
			}
		}
		System.out.println(counter);
		r = br.readLine().split(" ");
		counter = 0;
		for(int i = 0; i < n; i++)
		{
			int q = Integer.parseInt(r[i]);
			if(q + b >= s && q + b <= t)
			{
				counter++;
			}
		}
		System.out.println(counter);
	}

}
