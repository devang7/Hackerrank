import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AbsolutePerm {

	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t != 0)
		{
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			//System.out.println(n);
			if(k == 0)
			{
				for(int i = 1; i <= n; i++)
				{
					System.out.print(i+" ");
				}
			}
			else if(k > n/2)
			{
				System.out.print("-1");
			}
			else if(n % (k*2) != 0)
			{
				System.out.print("-1");
			}
			else
			{
				//every k change the sign
				int c = k;
				int f = 0;
				for(int i = 1; i <= n; i++)
				{
					//System.out.println(i);
					if(c > 0)
					{
						if(f == 1)
						{
							c = k;
							f = 0;
						}
					//	System.out.println("c1:"+c);
						System.out.print((i+k)+" ");
						c--;
						f = 0;
					}
					else
					{
						if(f == 0)
						{
							c = -k+1;
							f = 1;
						}
						System.out.print((i-k)+" ");
						//System.out.println("c:"+c);
						c++;
					}
				}
			}
			System.out.println();
			t--;
		}
		
	}
}
