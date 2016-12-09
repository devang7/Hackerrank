import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BonAppetit {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		String a[] = br.readLine().split(" ");
		long ba = 0;
		for(int i = 0; i < a.length; i++)
		{
			if(i != k)
				ba += Integer.parseInt(a[i]);
		}
		ba = ba/2;
		int bc = Integer.parseInt(br.readLine());
		if(ba == bc)
			System.out.println("Bon Appetit");
		else
			System.out.println(bc-ba);
	}
	

}
