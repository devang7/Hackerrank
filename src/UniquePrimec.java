import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UniquePrimec {
	
	public static void main(String args[]) throws Exception
	{
		System.out.println(Integer.MAX_VALUE);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		UniquePrimec t = new UniquePrimec();
		while(n != 0)
		{
			int count = 0; 
			long h = Long.parseLong(br.readLine());
			for(long i = 1; i <= (int)Math.sqrt(h); i++)
			{
				if(h % i == 0)
				{
					if(t.isPrime(i))
					{
						System.out.println(i);
						count++;
					}
					if(i != h/i && t.isPrime(h/i))
					{
						System.out.println((long)(h/i));
						count++;
						
					}
				}
			}
			System.out.println(count);
			n--;
		}
	}
	public boolean isPrime(long x)
	{
		if(x == 1)
		{
			return false;
		}
		else
		{
			for(long i = 2; i <= Math.sqrt(x); i++)
			{
				if(x % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}

}
