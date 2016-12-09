import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class StoneDiv {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		long n = Long.parseLong(s[0]);
		int m = Integer.parseInt(s[1]);
		long a[] = new long[m];
		s = br.readLine().split(" ");
		for(int i = 0; i < m; i++)
		{
			a[i] = Long.parseLong(s[i]);
		}
		Arrays.sort(a);
	}

}
