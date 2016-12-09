import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BabyStepEasy {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int q = Integer.parseInt(br.readLine());
		BabyStepEasy ba = new BabyStepEasy();
		while(q != 0)
		{
			String s[] = br.readLine().split(" ");
			int current = 0;
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			//ba.initialize(b);
			//System.out.println(ba.findMin(a,b,d,current));
			
			System.out.println(ba.findMin1(a, b, d));
			q--;
		}
	}
	public int findMin1(int a,int b,int d)
	{
		int current = 0;
		if(current == d)
		{
			return 0;
		}
		int count = 0;
		while(current <= d)
		{
			if(current == d)
				return count;
			else if(current+a == d || current+b == d)
			{
				return count+1;
			}
			else if((a+b>=d-current && a+d-current>=b && b+d-current>=0) || (2*a>=d-current && d-current>=0) || (2*b>=d-current && d-current>=0))
			{
				return count+2;
				
			}
			else
			{
				if(current+a > current+b)
				{
					current+=a;
				}
				else
					current+=b;
				count+=1;
			}
		}
		return 1;
	}
}
