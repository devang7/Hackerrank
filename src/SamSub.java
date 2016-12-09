import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class SamSub {

	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String a[][] = new String[s.length()][s.length()];
		BigInteger sum = new BigInteger("0");
		for(int i = 0; i < s.length(); i++)
		{
			a[i][i] = s.substring(i, i+1);
			sum = sum.add(new BigInteger(a[i][i]));
			//sum += Integer.parseInt(a[i][i]);
		}
		
		int k = 1;
		while(k < s.length())
		{
			int i = 0;
			for(int j = k; j < s.length(); j++)
			{
				a[i][j] = a[i][j-1] + a[i+1][j].substring(a[i+1][j].length()-1, a[i+1][j].length());
				sum = sum.add(new BigInteger(a[i][j]));
				//sum += Integer.parseInt(a[i][j]);
				i++;
			}
			k++;
		}
		/*k = 1;
		while(k < s.length())
		{
			int i = 0;
			for(int j = k; j < s.length(); j++)
			{
				System.out.print(a[i][j]+" ");
				//sum += Integer.parseInt(a[i][j]);
				i++;
			}
			System.out.println();
			k++;
		}*/
		
		int x = (int)Math.pow(10, 9) + 7;
		BigInteger mod1 = new BigInteger(Integer.toString(x));
		System.out.println(sum.mod(mod1));
		//System.out.println(sum % x);
		
		
	}
}
