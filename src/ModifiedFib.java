import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class ModifiedFib {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		while(t != 0)
		{
			String s[] = br.readLine().split(" ");
			long t1 = Long.parseLong(s[0]);
			long t2 = Long.parseLong(s[1]);
			int n = Integer.parseInt(s[2]);
			if(n == 1)
			{
				System.out.println(t2);
			}
			else
			{
				BigInteger temp = new BigInteger("1");
				BigInteger bd1 = new BigInteger(Long.toString(t1));
				BigInteger bd2 = new BigInteger(Long.toString(t2));
				while(n != 1)
				{
				
				temp = bd1.add(bd2);
				bd1 = bd2;
				bd2 = temp;
				//System.out.println(n+": "+t1+" "+t2);
				n--;
				}
				System.out.println(temp.toString());
			}
			
			t--;
		}
	}

}
