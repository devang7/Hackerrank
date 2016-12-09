import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotFlip {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int t = Integer.parseInt(s[1]);
		int ind0 = 0;
		int ind1 = 1;
		while(t != 0)
		{
			String y[] = br.readLine().split(" ");
			int type = Integer.parseInt(y[0]);
			int k = Integer.parseInt(y[1]);
			if(type == 1)
			{
				ind0 = (ind0 + k) % n;
				ind1 = (ind1 + k) % n;
			}
			else
			{
				ind0 = ((k+n) - ind0) % n;
				ind1 = ((k+n) - ind1) % n;
			}
			t--;
		}
		if((ind0 + 1) % n == ind1)
		{
			System.out.println("1"+" "+(n-ind0));
		}
		else
		{
			System.out.println("2"+" "+ ind0);
		}
	}

}
