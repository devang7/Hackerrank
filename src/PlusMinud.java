import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PlusMinud {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a[] = new int[n];
		String s[] = br.readLine().split(" ");
		double p = 0 ,ne = 0,z = 0;
		for(int i = 0; i < n; i++)
		{
			a[i] = Integer.parseInt(s[i]);
			if(a[i] < 0)
			{
				ne += 1;
			}
			if(a[i] == 0)
			{
				z++;
			}
			if(a[i] > 0)
			{
				p++;
			}
			
		}
		System.out.print(String.format("%.6g%n", p/n));
		System.out.print(String.format("%.6g%n", ne/n));
		System.out.print(String.format("%.6g%n", z/n));
		
	}

}
