import java.util.Arrays;

public class Pascal {
	
	public static void main(String args[]) throws Exception
	{
		Pascal p = new Pascal();
		p.pas(10);
	}
	public void pas(int k)
	{
		System.out.println("1");
		System.out.println("1 1");
		int c = 2;
		while(c < k)
		{
			long a[] = new long[(c/2)+1];
			for(int i = 0; i <= c/2; i++)
			{
				a[i] = ncr(c,i);
				//System.out.println(a[i]);
			}
			//System.out.println(Arrays.toString(a));
			for(int i = 0; i <= c/2; i++)
			{
				System.out.print(a[i]+" ");
			}
			if(c % 2 == 0)
			{
				for(int i = c/2 - 1; i >= 0; i--)
				{
					System.out.print(a[i]+" ");
				}
			}
			else
			{
				for(int i = c/2; i >= 0; i--)
				{
					System.out.print(a[i]+" ");
				}
			}
			System.out.println();
			c++;
		}
			
	}
	public long ncr(int n,int r)
	{
		int c = n - r;
		long temp = 1;
		while(n != c)
		{
			temp = temp*n;
			n = n - 1;
		}
		//System.out.println("temp "+temp+"fact"+fact(r));
		return temp/fact(r);
	}
	public long fact(int r)
	{
		long f = 1;
		for(int i = 1; i <= r; i++)
		{
			f = f*i;
		}
		return f;
	}
	
}
