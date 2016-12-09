import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DecimalToBinary {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		//String s = Integer.toUnsignedString(n);
		//System.out.println(s.charAt(s.length() - 4));
		for(int i = 1; i <= 3; i++)
		{
			n = n/2;
		}
		System.out.println(n%2);
		
	}

}
