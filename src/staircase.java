import java.io.BufferedReader;
import java.io.InputStreamReader;

public class staircase {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = ""; 
		for(int i = 0; i < n; i++)
		{
			s = "";
			for(int j = 0; j < n-i-1; j++)
			{
				s += " ";
			}
			for(int j = n-i-1; j < n; j++)
			{
				s += "#";
			}
			System.out.println(s);
		}
	}
}
