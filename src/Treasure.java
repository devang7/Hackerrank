import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Treasure {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		double x = Double.parseDouble(s[0]);
		double y = Double.parseDouble(s[1]);
		String si[] = br.readLine().split(" ");
		double a = Double.parseDouble(si[0]);
		double b = Double.parseDouble(si[1]);
		
		double k = (x*a + y*b) / (Math.pow(a, 2) + Math.pow(b, 2));
		double n = (k*a - x) / b;
		System.out.println(String.format("%.12f",k));
		System.out.println(String.format("%.12f",n));
	}
}
