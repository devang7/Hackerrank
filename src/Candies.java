import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Candies {
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		long m = Long.parseLong(s[0]);
		long w = Long.parseLong(s[1]);
		long p = Long.parseLong(s[2]);
		long n = Long.parseLong(s[3]);
		long count = 1;
		long candies = m*w;
		Candies c = new Candies();
		while(candies < n)
		{
			//System.out.println(candies);
			long max_buy = candies / p;
			//System.out.println("max:"+max_buy);
			long max = m*w;
			long t = c.optProd(m, w, max_buy);
			//System.out.println("t:"+t);
			if(t > m*w)
			{
				candies += t - max_buy*p;
			}
			else
			{
				candies += m*w;
			}
			count++;
			
		}
		System.out.println(count);
		
		
	}
	public long optProd(long a,long b,long x)
	{
		long diff = a - b;
		if(Math.abs(diff) >= x)
		{
			if(a < b)
				return (a+x)*b;
			else
				return a*(b+x);
		}
		else
		{
			if(a <= b)
			{
				x = x + diff;
				a = a - diff;
				return (a+x/2)*(b+(x - x/2));
			}
			else
			{
				x = x - diff;
				b = b + diff;
				return (a+x/2)*(b+(x - x/2));
			}
			
			
		}
	}

}
